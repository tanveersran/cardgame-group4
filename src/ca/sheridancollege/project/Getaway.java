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

    private int playerCount;
    private int roundNo;

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
        ArrayList<Card> playedCards = new ArrayList<>(); // arraylist containing the current cards

        roundNo++;
        System.out.println("Round " + roundNo);

        if (roundNo == 1) {
            firstRoundTurn(); // call this method on round 1
        }
        for (Player player : PlayerList.getPlayers()) {
            if (player.isCurrentPlayer() == true) {
                System.out.println(player.getName() + " , Its your turn!");
                currentPlayer = player; // set this player as current player
                break;
            }

        }

        System.out.println("Your Cards: ");
        for (int i = 0; i < currentPlayer.getPlayerHand().getSize(); i++) {
            System.out.println(currentPlayer.getPlayerHand().getCards().get(i));
        }

        boolean cardFound = false;

        while (!cardFound) {
            System.out.println("Please choose a card");

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
                    break;
                }
            }

        }
    }

    @Override
    public void declareWinner() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void firstRoundTurn() {
        for (Player player : PlayerList.getPlayers()) {
            for (int i = 0; i < player.getPlayerHand().getSize(); i++) {
                if (player.getPlayerHand().getCards().get(i).getCardNumber() == 14) { // check if card is ace of spades (id 14)
                    player.setCurrentPlayer(true); // set players turn
                }
            }
        }
    }

    private void playerTurn() {

    }

    private void chooseCurrentPlayer() {

    }

}
