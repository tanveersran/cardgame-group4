/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 * This class can be used to print basic messages for a console game
 * @author Tanveer
 */
public class Console {

    /**
     * This method returns a String containing a greeting message when the game
     * begins
     *
     * @return String containing welcome message
     */
    public static String printWelcome() {
        String message = ("////  Welcome to Takeaway ///// \n"
                + "//// Created by :         //// \n"
                + "//// Tanveer Singh Sran  //// \n"
                + "//// Rajat Rajat         //// \n"
                + "//// Nimrat Kaur Virk    //// \n"
                + "//// Nancy Nancy         //// \n\n");
        return message;
    }

    /**
     * This method prints the player selection part of a game screen.
     *
     * @return String
     */
    public static String printPlayerSelection() {
        String message = ("Please enter players between "
                + Game.minPlayerCount + " - " + Game.maxPlayerCount);
        return message;
    }
    
    /**
     * This method clears the screen by using system.out.println
     * @return String with 50 spaces
     */
    public static String clear() {
        String message = "";
        for(int i = 0; i < 50; i++) {
            message += "\n";
        }
        return message;
    }
    
    /**
     * This method prints output to ask user to enter their name
     * @param playerNumber 
     * @return String 
     */
    
    public static String printPlayerNumber(int playerNumber) {
        String message = ("Player " + playerNumber + ", Please enter/choose a username "
                + "having " + UsernameValidator.minUsernameLength + " - "
                + UsernameValidator.maxUsernameLength + " characters");
        return message;
    }
    
    /**
     * This method prints the game beggining message and prompts user to either
     * type rules or press enter to continue
     * @return 
     */
    
    public static String printGameBegin() {
        String message = "---------------------------------------------------"
                + "/                                                 / \n"
                + "/               GAME IS STARTING                  / \n"
                + "/                                                 / \n"
                + "/  PRESS ENTER TO BEGIN OR TYPE 'rules' FOR RULES / \n"
                + "/                                                 / \n"
                + "                                                  / \n"
                + "------------------------------------------------------";
        
        return message;
    } 
    
    public static String printRules() {
        String message = "Game Rules: \n"
                + "1. Player having the ACE of SPADES begins the game \n"
                + "2. This game is to be played between " + Game.minPlayerCount
                + " - " + Game.maxPlayerCount + " players. \n"
                + "3. The consecutive rounds begin with the player who played "
                + "the highest ranked card in previous round. \n"
                + "4. The cards that have been played in the rounds will be kept in "
                + "a discard pile. \n"
                + "5. The players who successfully use all their cards are counted"
                + " as one of the winners. \n "
                + "6. However, if the last card the player threw was the highest ranked card of that round,\n "
                + "the player will be given a random card from the discard pile "
                + "and will have to stay in the game\n "
                + "7. The player left at the end is considered the loser, \n while "
                + "all other players get score based on the position the got out of the game at.";
        return message;
    }
}
