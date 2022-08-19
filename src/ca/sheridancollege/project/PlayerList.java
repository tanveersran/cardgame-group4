/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * This class stores an ArrayList of player objects of Player class.
 *
 * @author Tanveer Singh Sran
 * @author Nimrat Kaur Virk
 * @author Rajat Rajat
 * @author Nancy Nancy
 */
public class PlayerList {

    private static ArrayList<Player> players = new ArrayList<>(); // keep track of players playing

    /**
     * This method adds
     *
     * @param player object of player class
     */
    public static void addPlayer(Player player) {
        players.add(player);
    }

    /**
     *
     * @return the list of players
     */
    public static ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     *
     * @return the number of players in the player array
     */
    public static int getPlayerCount() {
        return players.size();
    }

}
