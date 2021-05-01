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


public class PokerHand {

    private ArrayList<Card> pokerHand = new ArrayList<>();
    private static final int HANDSIZE = 5;

    public PokerHand() {
        pokerHand = this.pokerHand;
    }

    public PokerHand(ArrayList<Card> cardList) { //use for testing?
        pokerHand = new ArrayList<>(cardList);
    }

    /**
     * Adds a single card to the PokerHand.
     *
     * @param card: passed-in Card.
     * @return pokerHand
     */
    public ArrayList<Card> addCard(Card card) {
        if (pokerHand.size() < 5) {
            pokerHand.add(card);
            return pokerHand;
        } else {
            return null;
        }
    }

    /**
     * Gets Card at specified PokerHand index (ith value), returns it.
     * @param ithCard specified index of card to return
     * @return Card
     */
    public Card getIthCard(int ithCard) {
        if (ithCard >= 0 && ithCard <= 4) {
            return pokerHand.get(ithCard);
        } else {
            return null;
        }
    }


    /**
     * Converts result to English for returning.
     * @return converted hand result.
     */
    public String toString() {
        return "" + pokerHand + "";
    }


    /**
     * Determines how this hand compares to another hand, returns positive, negative,
     * or zero depending on the comparison.
     * @return a negative number if self is worth LESS than other, zero if they are worth the SAME,
     * and a positive number if self is worth MORE than other
     */
    public int compareTo(PokerHand other) {


//        System.out.println("TESTING HAND 1~~~~~~~~~ \n");
        String hand1TestResult = this.handTests();
        int hand1Score = this.rankHand(hand1TestResult);
//        System.out.println("TESTING HAND 2~~~~~~~\n");
        String hand2TestResult = other.handTests();
        int hand2Score = other.rankHand(hand2TestResult);
//        System.out.println("Hand1's score is: " + hand1Score + "& hand 2's score is: " + hand2Score);
//        System.out.println("1 = HAND 1 WINS \n 2 = HAND 2 WINS \n 3 = TIE GAME");
        if (hand1Score == hand2Score) {
//                System.out.println("Now testing for high card first level");
            int hand1FirstHighCard = this.getHighCardValue(0);
            int hand2FirstHighCard = other.getHighCardValue(0);
            hand1Score = hand1FirstHighCard;
            hand2Score = hand2FirstHighCard;
            if (hand1Score > hand2Score) {
//                            System.out.println("Hand1's score is: " + hand1Score + "& hand 2's score is: " + hand2Score);
//                            System.out.println("hand1wins");
                return 1;
            } else if (hand2Score > hand1Score) {
//                            System.out.println("Hand1's score is: " + hand1Score + "& hand 2's score is: " + hand2Score);
//                            System.out.println("hand2wins");
                return -1;
            } else { //hands are still equal
//                    System.out.println("Now testing for high card second level");
                int hand1SecondHighCard = this.getHighCardValue(1);
                int hand2SecondHighCard = other.getHighCardValue(1);
                hand1Score = hand1SecondHighCard;
                hand2Score = hand2SecondHighCard;
                if (hand1Score > hand2Score) {
//                            System.out.println("Hand1's score is: " + hand1Score + "& hand 2's score is: " + hand2Score);
//                            System.out.println("hand1wins");
                    return 1;
                } else if (hand2Score > hand1Score) {
//                            System.out.println("Hand1's score is: " + hand1Score + "& hand 2's score is: " + hand2Score);
//                            System.out.println("hand2wins");
                    return -1;
                } else { //hands are still equal
//                        System.out.println("Now testing for high card third level");
                    int hand1ThirdHighCard = this.getHighCardValue(2);
                    int hand2ThirdHighCard = other.getHighCardValue(2);
                    hand1Score = hand1ThirdHighCard;
                    hand2Score = hand2ThirdHighCard;
                    if (hand1Score > hand2Score) {
//                            System.out.println("Hand1's score different on third card is: " + hand1Score + "& hand 2's score is: " + hand2Score);
//                            System.out.println("hand1wins");
                        return 1;
                    } else if (hand2Score > hand1Score) {
//                            System.out.println("Hand1's score different on fourth card is: " + hand1Score + "& hand 2's score is: " + hand2Score);
//                            System.out.println("hand2wins");
                        return -1;
                    } else { //hands are still equal
//                    System.out.println("Now testing for high card fourth level");
                        int hand1FourthHighCard = this.getHighCardValue(3);
                        int hand2FourthHighCard = other.getHighCardValue(3);
                        hand1Score = hand1FourthHighCard;
                        hand2Score = hand2FourthHighCard;
                        if (hand1Score > hand2Score) {
//                            System.out.println("Hand1's score is: " + hand1Score + "& hand 2's score is: " + hand2Score);
//                            System.out.println("hand1wins");
                            return 1;
                        } else if (hand2Score > hand1Score) {
//                            System.out.println("Hand1's score is: " + hand1Score + "& hand 2's score is: " + hand2Score);
//                            System.out.println("hand2wins");
                            return -1;
                        } else { //hands are still equal
//                    System.out.println("Now testing for high card fifth level");

                            int hand1FifthHighCard = this.getHighCardValue(4);
                            int hand2FifthHighCard = other.getHighCardValue(4);
                            hand1Score = hand1FifthHighCard;
                            hand2Score = hand2FifthHighCard;
                            if (hand1Score > hand2Score) {
//                            System.out.println("Hand1's score on final high card is: " + hand1Score + "& hand 2's score on final high card is: " + hand2Score);
//                            System.out.println("hand1wins");
                                return 1;
                            } else if (hand2Score > hand1Score) {
//                            System.out.println("Hand1's score is: " + hand1Score + "& hand 2's score is: " + hand2Score);
//                            System.out.println("hand2wins");
                                return -1;
                            } else { // hands are STILL tied
//                                System.out.println("HANDS TIED. NOBODY WINS.");
                                return 0;
                            }
                        }
                    }
                }
            }
        }

        if (hand1Score > hand2Score) {
//            System.out.println("outer sequence. hand 1 wins. returning 1. enter 1 to win.");
            return 1;
        } else if (hand2Score > hand1Score) {
//            System.out.println("outer sequence. hand 2 wins. returning -1. enter 2 to win.");
            return -1;
        } else {
//            System.out.println("outer sequence. tie game.. returning 0. Enter 3 to win.");
            return 0;
        }
    }



    /**
     * Tests a hand for Flush, Two Pair, and Pair, else High Card; returns test which passes first. Tests each hand
     * in the following order, moving on to the next test if false is returned: Flush > Two Pair > Pair > High Card.
     *
     * @return true or false
     */
    private String handTests() {
        boolean isFlushTest = this.isFlush();
        boolean isTwoPairTest = this.isTwoPair();
        boolean isPairTest = this.isPair();

        if (isFlushTest == true) {
//            System.out.println("is flush yes");
            return ("Flush");
        } else if (isTwoPairTest == true) {
//            System.out.println("is two pair yes");
            return ("Two Pair");
        } else if (isPairTest == true) {
//            System.out.println("is pair yes");
            return ("Pair");
        } else {
            return ("High Card");
        }
    }

    /**
     * Tests hand for presence of a flush, returns true or false.
     *
     * @return True or False
     */
    private boolean isFlush() {
        int suitMatchCounter = 0;
        Card theFirstCard = getIthCard(0);

        for (int card = 0; card < HANDSIZE; card++) {
            Card theComparisonCard = getIthCard(card);

            if (theFirstCard.getCardSuit().equals(theComparisonCard.getCardSuit())) {
                suitMatchCounter += 1;
            }
        }
        if (suitMatchCounter == 5) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Tests hand for prescense of a two pair, returns true or false.
     *
     * @return true or false
     */
    private boolean isTwoPair() {
        boolean trueFalseIsFlush = this.isFlush();
        ArrayList<String> pairOneCounter = new ArrayList<>();
        ArrayList<String> pairTwoCounter = new ArrayList<>();
        ArrayList<String> pairThreeCounter = new ArrayList<>();
        ArrayList<String> pairFourCounter = new ArrayList<>();
        ArrayList<String> pairFiveCounter = new ArrayList<>();

        for (int card = 0; card < HANDSIZE; card++) {
            String cardRank = getIthCard(card).getCardRank();

            if (pairOneCounter.size() == 0 || cardRank.equals(pairOneCounter.get(0))) {
                pairOneCounter.add(cardRank);
            } else if (pairTwoCounter.size() == 0 || cardRank.equals(pairTwoCounter.get(0))) {
                pairTwoCounter.add(cardRank);
            } else if (pairThreeCounter.size() == 0 || cardRank.equals(pairThreeCounter.get(0))) {
                pairThreeCounter.add(cardRank);
            } else if (pairFourCounter.size() == 0 || cardRank.equals(pairFourCounter.get(0))) {
                pairFourCounter.add(cardRank);
            } else if (pairFiveCounter.size() == 0 || cardRank.equals(pairFiveCounter.get(0))) {
                pairFiveCounter.add(cardRank);
            }
        }

        ArrayList<ArrayList> pairValues = new ArrayList<>();

        pairValues.add(pairOneCounter);
        pairValues.add(pairTwoCounter);
        pairValues.add(pairThreeCounter);
        pairValues.add(pairFourCounter);
        pairValues.add(pairFiveCounter);

        int pairCount = 0;

        for (int index = 0; index < pairValues.size(); index++) {
            if (pairValues.get(index).size() >= 2 && pairValues.get(index).size() <= 3) {
                pairCount += 1;
            }
            if (pairValues.get(index).size() > 3) {
                pairCount += 2;
            }
        }

        if (pairCount == 2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * tests hand for prescence of a pair, returns true or false.
     *
     * @return true or false
     */
    private boolean isPair() {
        boolean trueFalseIsFlush = this.isFlush();
        boolean trueFalseIsTwoPair = this.isTwoPair();
        ArrayList<String> pairOneCounter = new ArrayList<>();
        ArrayList<String> pairTwoCounter = new ArrayList<>();
        ArrayList<String> pairThreeCounter = new ArrayList<>();
        ArrayList<String> pairFourCounter = new ArrayList<>();
        ArrayList<String> pairFiveCounter = new ArrayList<>();

        for (int card = 0; card < HANDSIZE; card++) {
            String cardRank = getIthCard(card).getCardRank();

            if (pairOneCounter.size() == 0 || cardRank.equals(pairOneCounter.get(0))) {
                pairOneCounter.add(cardRank);
            } else if (pairTwoCounter.size() == 0 || cardRank.equals(pairTwoCounter.get(0))) {
                pairTwoCounter.add(cardRank);
            } else if (pairThreeCounter.size() == 0 || cardRank.equals(pairThreeCounter.get(0))) {
                pairThreeCounter.add(cardRank);
            } else if (pairFourCounter.size() == 0 || cardRank.equals(pairFourCounter.get(0))) {
                pairFourCounter.add(cardRank);
            } else if (pairFiveCounter.size() == 0 || cardRank.equals(pairFiveCounter.get(0))) {
                pairFiveCounter.add(cardRank);
            }
        }

        ArrayList<ArrayList> pairValues = new ArrayList<>();

        pairValues.add(pairOneCounter);
        pairValues.add(pairTwoCounter);
        pairValues.add(pairThreeCounter);
        pairValues.add(pairFourCounter);
        pairValues.add(pairFiveCounter);

        int pairCount = 0;

        for (int index = 0; index < pairValues.size(); index++) {
            if (pairValues.get(index).size() >= 2) {
                pairCount += 1;
            }
        }

        if (pairCount == 1) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * Gets PokerHand's high card value starting at desired index, returns it.
     * @param checkIndex The PokerHand index to begin the check from to the end.
     * @return Highest rank in PokerHand.
     */
    private int getHighCardValue(int checkIndex) {
        String highestCardValueSoFar = this.pokerHand.get(checkIndex).getCardRank();
        int highestCardValueSoFarInteger = Integer.parseInt(highestCardValueSoFar);

        for (int index = checkIndex; index < this.pokerHand.size(); index++) {
            int thisCardRankInteger = Integer.parseInt(this.pokerHand.get(index).getCardRank());
            if (thisCardRankInteger > highestCardValueSoFarInteger){
                highestCardValueSoFar = this.pokerHand.get(index).getCardRank();
                highestCardValueSoFarInteger = Integer.parseInt(highestCardValueSoFar);
            }
        }
        return highestCardValueSoFarInteger;
    }



    /**
     * ranks hand from 1-4 based on result received from handTests, returns value.
     *
     * @return Number of test result.
     */
    private int rankHand(String testResult) {
        if (testResult.equals("Flush")) {
            return 4;
        } else if (testResult.equals("Two Pair")) {
            return 3;
        } else if (testResult.equals("Pair")) {
            return 2;
        } else {
            return 1;
        }
    }


    private boolean equals(PokerHand other) {
        if (other == this) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (!(other instanceof PokerHand)) {
            return false;
        }
        else {
            System.out.println("POKERHAND EQUALS METHOD ERROR: OOPS! returning false by default");
            return false; //can't return null, so returning false.
        }
    }

    /**
     * Returns the size of the PokerHand
     *
     * @return size of PokerHand
     */
    public int size() {
        return (this.pokerHand.size());
    }



    public static void main(String[] args) {
        System.out.println("Class PokerHand\n~~~~~~~~~~");

        Deck myDeck = new Deck();
        myDeck.shuffle();
        System.out.println("We're going to make a new Deck, shuffle it, and then create a PokerHand from it." +
                "\n\n~~~New Deck created and shuffled!\n\nLet's make a PokerHand!\n");
        PokerHand pokerHand1 = new PokerHand();
        System.out.println("~~~PokerHand created!\n\nLet's add cards... \n");
        Card card1 = myDeck.deal();
        Card card2 = myDeck.deal();
        Card card3 = myDeck.deal();
        Card card4 = myDeck.deal();
        Card card5 = myDeck.deal();
        pokerHand1.addCard(card1);
        pokerHand1.addCard(card2);
        pokerHand1.addCard(card3);
        pokerHand1.addCard(card4);
        pokerHand1.addCard(card5);

        System.out.println("Okay, cards added! Here's your new PokerHand: \n\n" + pokerHand1);

        System.out.println("\n\nand, here's your remaining Deck and length of that Deck: " + myDeck);
        System.out.println("\nDeck length: " + myDeck.size());
    }



}
