import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


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

public class Deck {


    private ArrayList<Card> cardList = new ArrayList<>();
    private static final int MAXRANK = 13;
    private static final int MAXSUIT = 4;
    private final int INITIALDECKSIZE;
    private int nextToDeal = 0;


    /**
     * Constructs a Deck with a 52-card Deck.
     */
    public Deck() {
        int cardRank = 1;
        int cardSuit = -1;

        for (int suit = 0; suit < MAXSUIT; suit++) {

            cardSuit += 1;
            cardRank = 1;

            for (int rank = 0; rank < MAXRANK; rank++) {

                cardRank += 1;
//                String cardSuitAsString = new String("" + cardSuit + "");
                Card theCard = new Card(cardRank, cardSuit);
                cardList.add(theCard);
            }
        }
        INITIALDECKSIZE = cardList.size(); // 52 cards
    }


    /**
     * Shuffles deck in-place.
     */
    public void shuffle() {
        Card originalCard;
        Card randomSwapCard;
        Card originalCardCopy;
        int endIndex = cardList.size();

        for (int currentIndex = nextToDeal; currentIndex < endIndex; currentIndex++) {
            int randomSwapIndex = ThreadLocalRandom.current().nextInt(nextToDeal, endIndex);
            originalCard = cardList.get(currentIndex);
            randomSwapCard = cardList.get(randomSwapIndex);
            originalCardCopy = originalCard;
            shuffleHelper(currentIndex, randomSwapCard, randomSwapIndex, originalCardCopy);
        }
    }

    /**
     * Swaps two cards
     * @param currentIndex Index of card to be moved.
     * @param randomSwapCard Random card to be moved into currentIndexs' place.
     * @param randomSwapIndex Index for randomSwapCard.
     * @param originalCardCopy Required copy of original card.
     */
    private void shuffleHelper(int currentIndex, Card randomSwapCard, int randomSwapIndex,Card originalCardCopy) {
        cardList.set(currentIndex, randomSwapCard);
        cardList.set(randomSwapIndex, originalCardCopy);
    }


    /**
     * Removes a single card from the end of the deck, returns it.
     *
     * @return a single card
     */
    public Card deal() {
        if (nextToDeal <= cardList.size()) {
            Card cardToDeal = cardList.get(nextToDeal);
            nextToDeal += 1; // current card has been "dealt", so increment to next card.
            return cardToDeal;
        } else {
            return null;
        }
    }


    /**
     * Returns deck to state where all cards are undealt.
     *
     * @return deck to undealt state.
     */
    public void gather() {
        nextToDeal = 0;
    }


    /**
     * Returns the remaining number of cards to deal in the deck
     *
     * @return remaining number of cards to deal.
     */
    public int size() {
        return (INITIALDECKSIZE - nextToDeal);
    }


    /**
     * Checks if Deck is empty or not, returns true or false.
     * @return true or false.
     */
    public boolean isEmpty() {
        if (INITIALDECKSIZE - nextToDeal == 0) {
            return true;
        } else {
            return false;
        }
    }



    /**
     * Returns all the undealt cards in the deck as a string.
     */
    public String toString() {
        ArrayList<Card> undealtCards = new ArrayList<>(cardList.subList(nextToDeal, cardList.size()));
        String undealtCardsAsString = ("");
        undealtCardsAsString += undealtCards;
        return undealtCardsAsString;
    }


    public static void main(String[] args) {

        System.out.println("\nClass Deck\n~~~~~~~~~~~~~~~");
        System.out.println("Let's make a new Deck, shuffle it, and display it.");
        System.out.println("Making new Deck...");
        Deck myDeck = new Deck();
        myDeck.shuffle();
        System.out.println("\nDone. \nHere's your new Deck: \n\n" + myDeck);

        System.out.println("\nNow, let's deal a few cards and make sure the Deck reduces in length... ");
        Card card1 = myDeck.deal();
        Card card2 = myDeck.deal();
        Card card3 = myDeck.deal();

        System.out.println("\nThree Cards have been dealt. Here they are: \n" + card1 + "\n" + card2 + "\n" + card3 + "\n");

        System.out.println("Your Deck's size should now be 49. Your Deck's size is actually: " + myDeck.size());
    }
}