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

        boolean roundHasEnded = false;

        System.out.println("Round " + roundNo);
        boolean firstTurnPlayed = false;
        while (!roundHasEnded) {
            if (!firstTurnPlayed) {
                firstPlayerTurn();
                firstTurnPlayed = true; // set to true after first turn

            } else {
                nextPlayerTurn();
            }
            if (playedCards.size() == PlayerList.getPlayers().size()) { // if all players have played their card, end round
                roundHasEnded = true;
                endRound();
                System.out.println("Round has ended.");
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
        if (roundNo == 1) {
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

        // finding the current player\
        for (Player player : PlayerList.getPlayers()) {
            if (player.isCurrentPlayer()) {
                currentPlayer = player;
            }
        }

        System.out.println(currentPlayer.getName() + " , Its your turn!");

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
                    System.out.println("You played: " + card);
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
     * This method
     */
    private void nextPlayerTurn() {
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

        System.out.println(currentPlayer.getName() + " , Its your turn!");

        System.out.println("Your Cards: "); // printing player cards
        for (int i = 0; i < currentPlayer.getPlayerHand().getSize(); i++) {
            if (currentPlayer.getPlayerHand().getCards().get(i).getSuit().equals(currentSuit)) {
                System.out.println(currentPlayer.getPlayerHand().getCards().get(i));
            }
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
                    System.out.println("You played: " + card);
                    playedCards.add(card); // add card to played card array
                    cardList.remove(i); // remove card from players cards
                    cardFound = true;
                    currentPlayer.setCurrentPlayer(false);
                    break;
                }
            }
        }
    }

    private void endRound() {
        for (Player player : PlayerList.getPlayers()) {
            player.setHasPlayed(false);
        }
        playedCards = new ArrayList(); // reset played card arraylist
        roundNo++;
    }

}
