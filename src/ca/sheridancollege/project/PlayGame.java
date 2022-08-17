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
    String gameBeginMessage = Console.printGameBegin();
    String gameRules = Console.printRules();

    Scanner scn = new Scanner(System.in);
    Getaway game = new Getaway("Getaway");
    GroupOfCards mainDeck = new GroupOfCards(52);

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

        System.out.println(clear);

        // PRINT GAME BEGIN MESSAGE 
        System.out.println(gameBeginMessage);

        String response = scn.nextLine();

        while (!(response.equals("") || response.equalsIgnoreCase("rules"))) {
            System.out.println("Press Enter to continue, or type 'rules' to view rules.");
            response = scn.nextLine();
        }

        System.out.println(clear);

        if (response.equalsIgnoreCase("rules")) {
            System.out.println(gameRules);
            System.out.println("Press Enter to begin game.");
            response = scn.nextLine();

            while (!response.equals("")) {
                System.out.println("Press Enter to begin game.");
            }
        }

        System.out.println(clear);

        // INITIALIZING THE PLAYING CARDS
        mainDeck.initialize();
        // SHUFFLING THE CARDS
        System.out.println("Shuffling the Cards....");
        mainDeck.shuffle();
        System.out.println("Cards shuffled, now distributing the cards among players...");

        // setting max cards to be distributed to playeers
        // switch case
        switch (PlayerList.getPlayerCount()) {
            case 3:
                int[] cards3 = {17, 17, 18};
                setPlayerMaxCards(cards3);
                break;
            case 4:
                int[] cards4 = {13, 13, 13, 13};
                setPlayerMaxCards(cards4);
                break;
            case 5:
                int[] cards5 = {11, 11, 10, 10, 10};
                setPlayerMaxCards(cards5);
                break;
            case 6:
                int[] cards6 = {9, 9, 9, 9, 8, 8};
                setPlayerMaxCards(cards6);
                break;
            case 7:
                int[] cards7 = {8, 8, 8, 7, 7, 7, 7};
                setPlayerMaxCards(cards7);
                break;
            case 8:
                int[] cards8 = {7, 7, 7, 7, 6, 6, 6, 6};
                setPlayerMaxCards(cards8);
                break;
        }

        // adding cards to player deck
        for (Player player : PlayerList.getPlayers()) {
            for (int i = 0; i < player.getPlayerHand().getSize(); i++) {
                player.getPlayerHand().addCard(mainDeck.cards.get(0)); // add first card to player deck          
                mainDeck.cards.remove(0); // remove the card from main deck
            }
        }
        
        System.out.println("Cards distributed....");
        
    }

    private void setPlayerMaxCards(int[] maxCardValues) {
        for (int i = 0; i < PlayerList.getPlayerCount(); i++) {
            Player player = PlayerList.getPlayers().get(i); // get player object
            player.getPlayerHand().setSize(maxCardValues[i]); // set card size
        }
        for (Player player: PlayerList.getPlayers()) {
            System.out.println(player.getPlayerHand().getSize());
        }
        
    }
    
   

}
