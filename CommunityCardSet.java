import java.util.ArrayList;

/**
  @author Brendan Pritikin
  *Professor Aaron Cass
  *CSC 120 - Union College
  *Fall 2020
  *Project 4
  *
  * I affirm that I have carried out my academic endeavors with full academic honesty.
  *
*/



public class CommunityCardSet {

    private ArrayList<Card> communityCardSet = new ArrayList<>();
    private static final int CARDSETSIZE = 5;


    public CommunityCardSet() {
        communityCardSet = this.communityCardSet;
    }

    public CommunityCardSet(ArrayList<Card> cardList) { // use this for testing
        communityCardSet = new ArrayList<>(cardList);
    }



    /**
     * Adds a single card to the CommunityCardSet.
     *
     * @param card: passed-in Card.
     * @return communityCardSet
     */
    public ArrayList<Card> addCard(Card card) {
        if (communityCardSet.size() < CARDSETSIZE) {
            communityCardSet.add(card);
            return communityCardSet;
        } else {
            return null;
        }
    }


    /**
     * Gets Card at specified CommunityCardSet index (ith value), returns it.
     * @param ithCard specified index of card to return
     * @return Card
     */
    public Card getIthCard(int ithCard) {
        if (ithCard >= 0 && ithCard <= 4) {
            return communityCardSet.get(ithCard);
        } else {
            return null;
        }
    }


    /**
     * Converts result to English for returning.
     * @return converted communityCardSet result.
     */
    public String toString() {
        return "" + communityCardSet + "";
    }

}
