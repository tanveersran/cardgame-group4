/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the
 * code should remember to add themselves as a modifier.
 *
 * @author dancye
 * @modified Tanveer Singh Sran
 * @modified Nimrat Kaur Virk
 * @modified Rajat Rajat
 * @modified Nancy Nancy
 */
public class Card {

    //default modifier for child classes
    private String cardName;
    private int cardNumber; // unique number used to help in card selectiom   
    private int cardRank; // rank value of card
    private String suit;

    /**
     * no-args Constructor
     */
    public Card() {
    }

    /**
     * constructor
     *
     * @param cardName
     * @param cardRank
     * @param suit
     */
    public Card(String suit, String cardName, int cardRank) {
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
     *
     * @return card number
     */
    public int getCardNumber() {
        return cardNumber;
    }

    /**
     *
     * @param cardNumber set card number
     */
    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a
     * regular playing card etc.
     */
    /**
     * This method nicely returns a string value with card name, its suit and
     * its number
     *
     * @return String containing card details
     */
    public String toString() {
        String printCard = cardName + " of " + suit + "(ID: " + cardNumber + ")";
        return printCard;
    }

}
