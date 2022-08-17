/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @modified Tanveer Singh Sran
 * 
 */
public class Player {

    private String name; // the unique name for this player
    private int playerNumber; // used to assign player turns
    private boolean hasHighestCard; // to check if player has the highest card in round
    
    private PlayerHand playerHand = new PlayerHand(12); // cards the player has
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

    /**
     * The method to be overridden when you subclass the Player class with your specific type of Player and filled in
     * with logic to play your game.
     */

}
