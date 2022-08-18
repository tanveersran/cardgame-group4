/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Tanveer
 */
public class Getaway extends Game {

    Scanner scn = new Scanner(System.in);
    Player currentPlayer; // keep track of current player.
    ArrayList<Card> playedCards = new ArrayList<>(); // arraylist containing the current cards

    private int playerCount;
    private int roundNo = 1;
    private boolean allHasPlayed = false; // keep track if all player have played
     boolean firstTurnPlayed = false;
    private String currentSuit;

    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        if (playerCount >= Game.minPlayerCount && playerCount <= Game.maxPlayerCount) {
            this.playerCount = playerCount;
        } else {
            throw new IllegalArgumentException("Player count should be between "
                    + Game.minPlayerCount + " - " + Game.maxPlayerCount);
        }
    }

    public Getaway(String name) {
        super(name);
    }

    @Override
    public void play() {

        System.out.println("Round " + roundNo);
       
        boolean gameFinished = false; // this will turn to true when game has finished
        
        while (!gameFinished) {
            if (!firstTurnPlayed) {
                firstPlayerTurn();
                firstTurnPlayed = true; // set to true after first turn
            } else {
                nextPlayerTurn();
            }
            if (playedCards.size() == PlayerList.getPlayers().size()) { // if all players have played their card, end round
                endRound();   
                
                System.out.println("Round has ended.");
                nextRound();
            }
        }
    }

    @Override
    public void declareWinner() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * This method decides the player who plays first during the first round.
     */
    private void firstPlayerTurn() {
        scn = new Scanner(System.in); // flushing the scanner

        if (roundNo == 1) { // if it is first round, this condition is met.
            for (Player player : PlayerList.getPlayers()) {
                for (int i = 0; i < player.getPlayerHand().getSize(); i++) {
                    if (player.getPlayerHand().getCards().get(i).getCardNumber() == 14) { // check if card is ace of spades (id 14)
                        player.setCurrentPlayer(true); // set players turn
                        player.setHasPlayed(true);
                        break;
                    }
                }
            }
        }
        else {
            
        }

        // finding the current player\
        for (Player player : PlayerList.getPlayers()) {
            if (player.isCurrentPlayer()) {
                currentPlayer = player;
            }
        }
        
        throwCard(); // throw cards.

    }

    /**
     * This method is run for the players that will be playing after the first player.
     */
    
    private void nextPlayerTurn() {
        scn = new Scanner(System.in); // flushing the scanner

        for (Player player : PlayerList.getPlayers()) {
            if (!player.hasPlayed()) {
                player.setCurrentPlayer(true);
                player.setHasPlayed(true);
                break;
            }
        }

        // finding the current player\
        for (Player player : PlayerList.getPlayers()) {
            if (player.isCurrentPlayer()) {
                currentPlayer = player;
            }
        }

        throwCard(); // throw cards
        
    }


    private void throwCard() {
        
        System.out.println(currentPlayer.getName() + " , Its your turn!");

        // ask user to press enter to continue so they have time to look away from screen
        System.out.println("Press enter when you're ready");
        String input = scn.nextLine();
        while (!input.equals("")) {
            System.out.println("Press enter when you're ready");
            input = scn.nextLine();
        }

        System.out.println(Console.clear());

        System.out.println("Your Cards: "); // printing player cards
        for (int i = 0; i < currentPlayer.getPlayerHand().getSize(); i++) {
            System.out.println(currentPlayer.getPlayerHand().getCards().get(i));
        }

        boolean cardFound = false;

        while (!cardFound) {
            System.out.println("Please type corresponding ID of the card to play");
            int cardNo = 0;
            try {
                cardNo = scn.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid Card ID.");
                scn = new Scanner(System.in); // flushing the scanner
            }

            for (int i = 0; i < currentPlayer.getPlayerHand().getSize(); i++) {
                ArrayList<Card> cardList = currentPlayer.getPlayerHand().getCards();
                Card card = cardList.get(i);

                if (card.getCardNumber() == cardNo) {
                    System.out.println(Console.clear());
                    System.out.println(currentPlayer.getName() +" played: " + card  + "\n\n\n");
                    currentSuit = card.getSuit(); // update current suit to match card suit
                    playedCards.add(card); // add card to played card array
                    cardList.remove(i); // remove card from players cards
                    cardFound = true;
                    currentPlayer.setCurrentPlayer(false);

                    break;
                }
            }
        }
    }
    /** 
     * This method is run when the round is going to end, it resets the players has played values,
     * and increments the round number.
     */
    private void endRound() {
        for (Player player : PlayerList.getPlayers()) {
            player.setHasPlayed(false);
        }
        
        playedCards = new ArrayList(); // reset played card arraylist
        roundNo++;
        firstTurnPlayed = false; // reset first turned played value
    }
    
    private void nextRound() {
        System.out.println("\n\n Press Enter to begin next Round");
        System.out.println(Console.clear());
        
        System.out.println("Round " + roundNo);
    }

}
