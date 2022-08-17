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
    
    public static void printPlayerName(int playerNumber) {
        System.out.println("Player " + playerNumber + ", Please enter/choose a username"
                + " having" + UsernameValidator.minUsernameLength
                + UsernameValidator.maxUsernameLength + "characters");             
    }
}
