/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you
 * might want to subclass this more than once. The group of cards has a maximum
 * size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @modified Tanveer Singh Sran
 * @modified Nimrat Kaur Virk
 * @modified Rajat Rajat
 * @modified Nancy Nancy
 */
public class GroupOfCards {

    private final String[][] cardDetails = {{"ACE", "14"} , {"KING", "13"}, {"QUEEN", "12"}, {"JACK", "11"}, {"TEN", "10"}, {"NINE", "9"},
    {"EIGHT", "8"}, {"SEVEN", "7"}, {"SIX", "6"}, {"FIVE", "5"}, {"FOUR", "4"},
    {"THREE", "3"}, {"TWO", "2"}, };
    
    private final String[] suitName = {"DIAMONDS", "SPADE", "HEARTS", "CLUBS"};

    //The group of cards, stored in an ArrayList will also be used as the discard pile.
    public ArrayList<Card> cards = new ArrayList<>();
    private int size = 52;//the size of the grouping

    public GroupOfCards() {
        // empty constructor
    }

    public GroupOfCards(int size) {
        this.size = size;
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }

    public void addCard(Card cardName) {
        cards.add(cardName);
    }

    public void initialize() {
        int cardNumber = 1;
        for (String suit : suitName) {
            for (String[] card : cardDetails) {
                Card cardObject = new Card();
                cardObject.setSuit(suit);
                cardObject.setCardName(card[0]);
                cardObject.setCardRank(Integer.parseInt(card[1]));
                cardObject.setCardNumber(cardNumber);
                addCard(cardObject);

                cardNumber++;
            }
        }
    }

}
