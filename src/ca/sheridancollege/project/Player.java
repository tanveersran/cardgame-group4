/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * A class that models each Player in the game. Players have an identifier,
 * which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @modified Tanveer Singh Sran
 * @modified Nimrat Kaur Virk
 * @modified Rajat Rajat
 * @modified Nancy Nancy
 *
 */
public class Player {

    private String name; // the unique name for this player
    private int playerNumber; // used to assign player turns
    private PlayerHand playerHand = new PlayerHand(); // cards of the player
    private int playerScores; // contains scores of the player.

    
    private boolean currentPlayer; // to check if player has the highest card in round
    private boolean hasPlayed; // check if player has played their turn in the round
    
     /**
     * A constructor that allows you to set the player's name and players number
     *
     * @param name the unique ID to assign to this player.
     * @param playerNumber the number of player to decide turn
     */
    public Player(String name, int playerNumber) {
        this.name = name;
        this.playerNumber = playerNumber;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public boolean isCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(boolean hasHighestCard) {
        this.currentPlayer = hasHighestCard;
    }

    public PlayerHand getPlayerHand() {
        return playerHand;
    }
    
    public int getPlayerScores() {
        return playerScores;
    }

    public void setPlayerScores(int playerScores) {
        this.playerScores = playerScores;
    }

    /**
     * @return the player name
     */
    public String getName() {
        return name;
    }

    /**
     * Ensure that the playerID is unique
     *
     * @param name the player name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public boolean hasPlayed() {
        return hasPlayed;
    }

    public void setHasPlayed(boolean hasPlayed) {
        this.hasPlayed = hasPlayed;
    }
    
    public void addPlayerCard(Card card) {
        playerHand.cards.add(card);
    }
    
    /**
     *
     * @param card card that is to be removed
     */
    public void removePlayerCard(Card card) {
        for (Card playerCard: playerHand.getCards()) {
            if (playerCard.equals(card)) {
                playerHand.getCards().remove(playerCard);
            }
        }
    }
    
    public ArrayList<Card> getPlayerCard() {
        return playerHand.getCards();
    }

}
