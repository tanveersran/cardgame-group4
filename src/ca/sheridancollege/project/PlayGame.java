/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Tanveer
 */
public class PlayGame {

    String clear = Console.clear();
    String playerSelection = Console.printPlayerSelection();
    String welcomeMessage = Console.printWelcome();

    Scanner scn = new Scanner(System.in);
    Getaway game = new Getaway("Getaway");

    public static void main(String[] args) {
        PlayGame game = new PlayGame();
        game.run();
    }

    private void run() {
        // printing the welcome message
        System.out.println(welcomeMessage);

        // continue when user presses enter (empty string)
        String input = "something";
        while (!input.equals("")) {
            System.out.println("Please press Enter to continue");
            input = scn.nextLine();
        }

        System.out.println(clear);

        // printing player selection message and asking user input
        int playerCount = 0; // placeholder value

        while (playerCount < Game.minPlayerCount || playerCount > Game.maxPlayerCount) {
            System.out.println(playerSelection); // loop until value is in the criteria          
            try {
                playerCount = scn.nextInt(); // get user input
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid numerical value");
                scn = new Scanner(System.in);
            }
        }

        game.setPlayerCount(playerCount); // set the player count

        System.out.println(clear);

        // get usernames of players
        UsernameValidator valName = new UsernameValidator();
        String playerName = "";
        boolean nameMatchesCriteria = false;

        for (int i = 1; i <= game.getPlayerCount(); i++) {
            while (!nameMatchesCriteria) {
                scn = new Scanner(System.in); // flushing scanner

                System.out.println(Console.printPlayerNumber(i)); // print player number

                playerName = scn.nextLine();

                if (i > 1) { // start checking if player is in playerlist from 2nd player

                    boolean playerExists = true;

                    /* 
                    CURRENT BUG IN LINE 78 - LINE 89
                    sometimes while loop exists even when name is taken
                    */
                    while (playerExists) {
                        for (Player player : PlayerList.getPlayers()) {
                            if (player.getName().equals(playerName)) {
                                System.out.println("Name already taken, re-enter username");
                                playerName = scn.nextLine(); 

                            } else {
                                playerExists = false;
                            }
                        }
                    }
                }

                nameMatchesCriteria = valName.validate(playerName); // check if name matches criteria

                Player player = new Player(playerName, i);
                PlayerList.addPlayer(player); // create player object and add it to player list
            }

            nameMatchesCriteria = false; // set criteria to false again for next player
        }
    }

}
