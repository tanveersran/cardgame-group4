/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author Tanveer Singh Sran
 * @author Nimrat Kaur Virk
 * @author Rajat Rajat
 * @author Nancy Nancy
 */
public class ScoreBoard {

   
    // stores the winners of rounds along with their scores
    private static ArrayList<Player> winners = new ArrayList<>();
    
     public static ArrayList<Player> getWinners() {
        return winners;
    }

    public static void addWinners(Player winners) {
        ScoreBoard.winners.add(winners);
    }
}
