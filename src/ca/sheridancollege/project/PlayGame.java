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
                playerCount = scn.nextInt();
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
                
                Console.printPlayerName(i);                      
                playerName = scn.nextLine();
                nameMatchesCriteria = valName.validate(playerName);
            }
            nameMatchesCriteria = false; // set criteria to false again for next player
        }
    }
}
