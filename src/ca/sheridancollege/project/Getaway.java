/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Tanveer
 */
public class Getaway extends Game{
    
    private int playerCount;
    private int roundNo;

    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        if (playerCount >= Game.minPlayerCount && playerCount <= Game.maxPlayerCount)
        this.playerCount = playerCount;
        
        else
            throw new IllegalArgumentException("Player count should be between "
                    + Game.minPlayerCount + " - " + Game.maxPlayerCount);
    }
    
    public Getaway(String name) {
        super(name);
    }

    
    @Override
    public void play() {
  
        
    }

    @Override
    public void declareWinner() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
