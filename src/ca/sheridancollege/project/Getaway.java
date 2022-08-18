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
 * @author Tanveer Singh Sran
 * @author Nimrat Kaur Virk
 * @author Rajat Rajat
 * @author Nancy Nancy
 */
public class Getaway extends Game {

    Scanner scn = new Scanner(System.in);
    Player currentPlayer; // keep track of current player.
    
    ArrayList<Card> discardPile = new ArrayList<>(); // arraylist containing the current cards

    private int playerCount;
    private int roundNo = 1;
    boolean cardOfSuitExists; // keep track if players have cards of current suit being played
    boolean firstTurnPlayed = false;
    private String currentSuit;

    Card highestCard = new Card(); // this will keep track of highest card of the round.
    Player highestCardPlayer; // this will keep track of player having highest card.

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
        highestCard.setCardRank(0);
        System.out.println("Round " + roundNo);

        boolean gameFinished = false; // this will turn to true when game has finished

        while (!gameFinished) {
            if (!firstTurnPlayed) {
                firstPlayerTurn();
                firstTurnPlayed = true; // set to true after first turn
            } else {
                nextPlayerTurn();
            }
            if (discardPile.size() == PlayerList.getPlayers().size()) { // if all players have played their card, end round
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
                    Card card = player.getPlayerHand().getCards().get(i);
                    if (card.getCardNumber() == 14) { // check if card is ace of spades (id 14)
                        player.setCurrentPlayer(true); // set players turn
                        player.setHasPlayed(true);
                        currentPlayer = player;

                        System.out.println(currentPlayer.getName() + " has Ace of Spades , Its your turn!");

                        // ask user to press enter to continue so they have time to look away from screen
                        System.out.println("Press enter when you're ready");
                        String input = scn.nextLine();
                        while (!input.equals("")) {
                            System.out.println("Press enter when you're ready");
                            input = scn.nextLine();
                        }

                        System.out.println(currentPlayer.getName() + " played: " + card + "\n\n\n");
                        currentSuit = card.getSuit(); // update current suit to match card suit
                        discardPile.add(card); // add card to played card array
                        currentPlayer.getPlayerHand().getCards().remove(i); // remove card from players cards                   
                        currentPlayer.setCurrentPlayer(false);

                        highestCard = card; // the played card will be highest card.
                        highestCardPlayer = player;
                        currentSuit = card.getSuit();
                        break;
                    }
                }
            }
        } else {
            currentPlayer = highestCardPlayer; // set current player to player who had highest card in last round.
            throwCard(); // throw cards.
        }
    }

    /**
     * This method is run for the players that will be playing after the first
     * player.
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

        showCards();

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
                try {
                    Card card = cardList.get(i);

                    if (card.getCardNumber() == cardNo) {
                        System.out.println(Console.clear());
                        System.out.println(currentPlayer.getName() + " played: " + card + "\n\n\n");
                        
                        if(cardOfSuitExists == false) { // this runs when player has to take all cards from discard pile
                            giveDiscardPile();
                            endRound(); // round will end
                            nextRound();                        
                            break;
                        }
                        if (card.getCardRank() > highestCard.getCardRank()) {
                            highestCard = card; // if played card has higher rank, it will be set as highest card.
                            highestCardPlayer = currentPlayer;
                        }

                        currentSuit = card.getSuit(); // update current suit to match card suit

                        discardPile.add(card); // add card to played card array    

                        cardList.remove(i); // remove card from players cards

                        cardFound = true;
                        currentPlayer.setCurrentPlayer(false);
                        System.out.println(firstTurnPlayed);
                        break;
                    }
                } catch (IndexOutOfBoundsException e) {
                }
            }
        }
    }

    /**
     * This method is run when the round is going to end, it resets the players
     * has played values, and increments the round number.
     */
    private void endRound() {
        for (Player player : PlayerList.getPlayers()) {
            player.setHasPlayed(false);
        }

        discardPile.clear(); // reset played card arraylist
        roundNo++;
        firstTurnPlayed = false; // reset first turned played value
    }

    /**
     * This method is run when the next round begins. This prints the round
     * number and clears the console to prepare for the next round.
     */
    private void nextRound() {
        System.out.println("\n\nPress Enter to begin next Round");
        System.out.println(Console.clear());

        System.out.println("Round " + roundNo);
    }

    private void showCards() {
        System.out.println("Your Cards: "); // printing player cards

        cardOfSuitExists = false;

        for (int i = 0; i < currentPlayer.getPlayerHand().getSize(); i++) {
            if (!firstTurnPlayed) {
                try {
                    System.out.println(currentPlayer.getPlayerHand().getCards().get(i));
                    cardOfSuitExists = true; // set to true if this condition is met
                } catch (IndexOutOfBoundsException e) {
                    //
                }
            } else {
                try {
                    if (currentPlayer.getPlayerHand().getCards().get(i).getSuit().equals(currentSuit)) {
                        cardOfSuitExists = true;
                        System.out.println(currentPlayer.getPlayerHand().getCards().get(i));
                    }
                } catch (IndexOutOfBoundsException e) {
                    // 
                }
            }

        }

        if (cardOfSuitExists == false) { // run this if no condition above is met
            System.out.println("You do not have a card of that suit, Choose any card.");
            for (int i = 0; i < currentPlayer.getPlayerHand().getSize(); i++) {
                try {
                System.out.println(currentPlayer.getPlayerHand().getCards().get(i));
                } catch (IndexOutOfBoundsException e) {}
            }        
        }

    }

    /** This method will give all the cards that are in the discard pile back to the player 
     * having the highest card.
     */
    private void giveDiscardPile() {
        System.out.println(highestCardPlayer.getName() + " has taken all the cards from discard pile!\n");
        
        for (Card cards: discardPile) {
            highestCardPlayer.getPlayerHand().getCards().add(cards);        
        }
        discardPile.clear();
    }
}
