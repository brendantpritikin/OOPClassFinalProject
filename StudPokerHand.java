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



public class StudPokerHand {


    private ArrayList<Card> studPokerHand = new ArrayList<>();
    private CommunityCardSet communityCards;
    private static final int STUDPOKERHANDSIZE = 2;


    public StudPokerHand() {
        studPokerHand = this.studPokerHand;
    }

    public StudPokerHand(CommunityCardSet cc, ArrayList<Card> cardList) {
        studPokerHand = new ArrayList<>(cardList);
        communityCards = cc;
    }


    /**
     * Adds a single card to the StudPokerHand.
     *
     * @param card: passed-in Card.
     * @return studPokerHand
     */
    public ArrayList<Card> addCard(Card card) {
        if (studPokerHand.size() < STUDPOKERHANDSIZE) {
            studPokerHand.add(card);
            return studPokerHand;
        } else {
            return null;
        }
    }


    /**
     * Gets Card at specified studPokerHand index (ith value), returns it.
     * @param ithCard specified index of card to return
     * @return Card
     */
    public Card getIthCard(int ithCard) {
        if (ithCard >= 0 && ithCard <= 1) {
            return studPokerHand.get(ithCard);
        } else {
            return null;
        }
    }



    /**
     * Converts result to English for returning.
     * @return converted studPokerHand result.
     */
    public String toString() {
        return "" + studPokerHand + "";
    }


    /**
     * finds all possible 5-card PokerHands that can be made out of
     * the 7 cards the StudPokerHand has access to, returns all possible PokerHands.
     * @return all possible PokerHands
     */
    private ArrayList<PokerHand> getAllFiveCardHands() {

        ArrayList<PokerHand> allFiveCardHands = new ArrayList<>();

        ArrayList<ArrayList<Card>> hands = new ArrayList<>();
        ArrayList<Card> allTheCards = new ArrayList<>();
        allTheCards.add(communityCards.getIthCard(0));
        allTheCards.add(communityCards.getIthCard(1));
        allTheCards.add(communityCards.getIthCard(2));
        allTheCards.add(communityCards.getIthCard(3));
        allTheCards.add(communityCards.getIthCard(4));
        allTheCards.add(this.getIthCard(0));
        allTheCards.add(this.getIthCard(1));

        for (int i = 0; i < allTheCards.size()-1; i++) {
            for (int j = i + 1; j < allTheCards.size(); j++) {
                for (int k = j + 1; k < allTheCards.size(); k++) {
                    for (int l = k + 1; l < allTheCards.size(); l++) {
                        for (int m = l + 1; m < allTheCards.size(); m++) {
                            PokerHand fiveCardHand = new PokerHand();
                            fiveCardHand.addCard(allTheCards.get(i));
                            fiveCardHand.addCard(allTheCards.get(j));
                            fiveCardHand.addCard(allTheCards.get(k));
                            fiveCardHand.addCard(allTheCards.get(l));
                            fiveCardHand.addCard(allTheCards.get(m));
                            allFiveCardHands.add(fiveCardHand);
                        }
                    }
                }
            }
        }
//        System.out.println("Here are all of the five card hands: " + allFiveCardHands);
        return allFiveCardHands;
    }



    private PokerHand getBestFiveCardHand() {
        ArrayList<PokerHand> hands = getAllFiveCardHands();
        PokerHand bestSoFar = hands.get(0);

        for (int i = 1; i < hands.size(); i++) {
            if (hands.get(i).compareTo(bestSoFar) > 0) {
                bestSoFar = hands.get(i);
            }
        }
        return bestSoFar;
    }


    /**
     * Determines how this hand compares to another hand, using the
     * community card set to determine the best 5-card hand it can
     * make. Returns positive, negative, or zero depending on the comparison.
     *
     * @param other The hand to compare this hand to
     * @return a negative number if this is worth LESS than other, zero
     * if they are worth the SAME, and a positive number if this is worth
     * MORE than other
     */
    public int compareTo(StudPokerHand other) {

        PokerHand thisBestHand = this.getBestFiveCardHand();
        PokerHand otherBestHand = other.getBestFiveCardHand();

//        System.out.println("STUDPOKERHAND: COMPARING HANDS: ~~~~~~~~~ \n");
//        System.out.println("The best hand for the first hand is: " + thisBestHand);
//        System.out.println("The best hand for the second hand is: " + otherBestHand);
        int result = thisBestHand.compareTo(otherBestHand);
//        System.out.println("The winner is: " + result);
        return result;
    }
}
