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

    Scanner scn = new Scanner(System.in);
    Getaway game = new Getaway("Getaway");

    public static void main(String[] args) {
        PlayGame game = new PlayGame();
        game.run();
    }

    private void run() {
        // printing the welcome message
        System.out.println(Console.printWelcome());

        // continue when user presses enter (empty string)
        String input = "something";
        while (!input.equals("")) {
            System.out.println("Please press Enter to continue");
            input = scn.nextLine();
        }

        Console.clear();

        // printing player selection message and asking user input
        int playerCount = 0; // placeholder value
        while (playerCount < Game.minPlayerCount || playerCount > Game.maxPlayerCount) {
            System.out.println(Console.printPlayerSelection()); // loop until value is in the criteria

            try {
                playerCount = scn.nextInt(); // get user input
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid numerical value");
                scn = new Scanner(System.in);
                playerCount = scn.nextInt();
            }
        }

        game.setPlayerCount(playerCount); // set the player count

    }
}
