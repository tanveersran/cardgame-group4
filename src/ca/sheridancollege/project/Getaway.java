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

    private int playerCount; // number of players in the game.
    private int roundNo = 1; // contains the round number
    boolean cardOfSuitExists; // keep track if players have cards of current suit being played
    boolean firstTurnPlayed = false; // tracks whether first turn has been played or not.
    private String currentSuit; // stores the current suit of the game.

    Card highestCard = new Card(); // this will keep track of highest card of the round.
    Player highestCardPlayer; // this will keep track of player having highest card.

    /**
     * One arg constructor to set the name of the game.
     *
     * @param name
     */
    public Getaway(String name) {
        super(name);
    }

    /**
     *
     * @return the player count of the game
     */
    public int getPlayerCount() {
        return playerCount;
    }

    /**
     * Sets the player count of the game
     *
     * @param playerCount player count to be set
     */
    public void setPlayerCount(int playerCount) {
        if (playerCount >= Game.minPlayerCount && playerCount <= Game.maxPlayerCount) {
            this.playerCount = playerCount;
        } else {
            throw new IllegalArgumentException("Player count should be between "
                    + Game.minPlayerCount + " - " + Game.maxPlayerCount);
        }
    }

    /**
     * This method contains logic to begin the game. It will call player turn
     * methods and end the game as players run out of cards.
     */
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
            if (PlayerList.getPlayers().isEmpty()) {
                gameFinished = true; // finish game when all players are out of the game
            }
        }

        System.out.println(Console.clear());
        System.out.println(Console.gameEnds()); // print game ending message

        // print winners and their scores.
        for (Player winner : ScoreBoard.getWinners()) {
            System.out.println(winner.getName() + " (Score: " + winner.getPlayerScores() + ")");
        }

    }

    /**
     * This method is run after every round to verify if any player has used up
     * all their cards. That player is declared the winner and is out of the
     * game!
     */
    @Override
    public void declareWinner() {
        for (Player player : PlayerList.getPlayers()) {
            if (player.getPlayerHand().getCards().isEmpty()) {
                if (!player.equals(highestCardPlayer)) {
                    System.out.println("Player " + player.getName() + " has managed to get away! Congratulations.");
                    PlayerList.getPlayers().remove(player); // remove the player from playerlist
                    player.setPlayerScores(5); // winners get 5 scores.
                    ScoreBoard.addWinners(player);
                } else {
                    System.out.println("Player " + player.getName() + " tried to get away but had the highest card! \n");
                    System.out.println("Giving them a card from discard pile..");
                    player.getPlayerHand().addCard(discardPile.get(0));
                    endRound();
                    nextRound();
                }
            }
        }
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
                        enterToContinue("Press enter when you're ready");

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
        throwCard();// throw cards
        declareWinner(); // check if anyone has managed to get away

    }

    /**
     * This method contains logic of throwing cards when player has their turn.
     */
    private void throwCard() {
        System.out.println(currentPlayer.getName() + " , Its your turn!");

        // ask user to press enter to continue so they have time to look away from screen
        enterToContinue("Press enter when you're ready");

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
               
                try {
                    Card card = currentPlayer.getPlayerCard().get(i);
                    if (card.getCardNumber() == cardNo) {
                        System.out.println(Console.clear());
                        System.out.println(currentPlayer.getName() + " played: " + card + "\n\n\n");

                        if (cardOfSuitExists == false) { // this runs when player has to take all cards from discard pile
                            discardPile.add(card);

                            giveDiscardPile(); // give discard pile to the player with the highest rank card.
                            endRound(); // round will end
                            nextRound();
                            cardFound = true;

                            break;
                        }
                        if (card.getCardRank() > highestCard.getCardRank()) {
                            highestCard = card; // if played card has higher rank, it will be set as highest card.
                            highestCardPlayer = currentPlayer;
                        }

                        currentSuit = card.getSuit(); // update current suit to match card suit
                        discardPile.add(card); // add card to played card array    
                        currentPlayer.getPlayerCard().remove(i); // remove card from players cards
                        
                        cardFound = true;
                        currentPlayer.setCurrentPlayer(false);
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
        enterToContinue("\n\nPress Enter to begin next Round");
        System.out.println(Console.clear());

        System.out.println("Round " + roundNo);
    }

    /**
     * This method displays cards of the current player along with the card IDs.
     *
     */
    private void showCards() {
        System.out.println("Your Cards: "); // printing player cards

        cardOfSuitExists = false;

        for (int i = 0; i < currentPlayer.getPlayerHand().getSize(); i++) {
            if (!firstTurnPlayed) {
                try {
                    System.out.println(currentPlayer.getPlayerCard().get(i));
                    cardOfSuitExists = true; // set to true if this condition is met
                } catch (IndexOutOfBoundsException e) {
                    //
                }
            } else {
                try {
                    if (currentPlayer.getPlayerHand().getCards().get(i).getSuit().equals(currentSuit)) {
                        cardOfSuitExists = true;
                        System.out.println(currentPlayer.getPlayerCard().get(i));
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
                    System.out.println(currentPlayer.getPlayerCard().get(i));
                } catch (IndexOutOfBoundsException e) {
                }
            }
        }

    }

    /**
     * This method will give all the cards that are in the discard pile back to
     * the player having the highest card.
     */
    private void giveDiscardPile() {
        System.out.println(highestCardPlayer.getName() + " has taken all the cards from discard pile!\n");

        for (Card cards : discardPile) {
            highestCardPlayer.getPlayerCard().add(cards);
        }
        discardPile.clear();
    }

    /**
     * This will ask user to press enter to continue and will display a message
     * as per the requirements.
     *
     * @param message the prompt message
     */
    private void enterToContinue(String message) {
        scn = new Scanner(System.in);

        System.out.println(message);
        String input = scn.nextLine();
        while (!input.equals("")) {
            System.out.println(message);
            input = scn.nextLine();
        }
    }
}
