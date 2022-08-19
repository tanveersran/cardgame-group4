/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 * This is an extension of the GroupOfCards class. It contains the personal
 * cards of a player.
 *
 * @author Tanveer Singh Sran
 * @author Nimrat Kaur Virk
 * @author Rajat Rajat
 * @author Nancy Nancy
 */
public class PlayerHand extends GroupOfCards {

    private int size; // stores the size of the player hand.

    /**
     * @return size of player hand
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size set size of the playerHand
     */
    public void setSize(int size) {
        this.size = size;
    }

}
