/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 */
public class Card {
    //default modifier for child classes
    private String cardName;
    private int cardRank; // rank value of card
    private String suit;
    
    final static String[][] cardDetails = {{"KING","13"},{"QUEEN","12"},{"JACK","11"},{"TEN","10"},{"NINE","9"},
                       {"EIGHT","8"},{"SEVEN","7"},{"SIX","6"},{"FIVE","5"},{"FOUR","4"},
                       {"THREE","3"},{"TWO","2"},{"ACE","14"}};
    final static String[] suitName = {"DIAMONDS","SPADE", "HEARTS","CLUBS"};
    /**
     * no-args Constructor
     */
    public Card (){}
    
    /**
     * constructor
     * @param cardName
     * @param cardRank 
     * @param suit
     */
    public Card (String suit,String cardName,int cardRank){
        this.cardName = cardName;
        this.cardRank = cardRank;
        this.suit = suit;
    }
    
    /**
     * @return the cardName
     */
    public String getCardName() {
        return cardName;
    }

    /**
     * @param cardName the cardName to set
     */
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    /**
     * @return the cardRank
     */
    public int getCardRank() {
        return cardRank;
    }

    /**
     * @param cardRank the cardRank to set
     */
    public void setCardRank(int cardRank) {
        this.cardRank = cardRank;
    }
    /**
     * @return the suit
     */
    public String getSuit() {
        return suit;
    }

    /**
     * @param suit the suit to set
     */
    public void setSuit(String suit) {
        this.suit = suit;
    }

    
    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    
    public String toString(){
        String printCard = "[SUIT] "+suit+" [CARD NAME] "+cardName + " [CARD RANK] "+ cardRank;
        return printCard;
    }

    
}
