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

public class PokerHandTester {

    public static void testCompareToHighCard(PokerHand winningHCHand, PokerHand losingHCHand, Testing myTestingSuite) {
        System.out.println("Testing this high-card hand: " + winningHCHand + "\n" + "against this high-card " +
                "hand: " + losingHCHand);
        myTestingSuite.assertEquals("Testing high-card hand against hand with lesser high card",
                1, winningHCHand.compareTo(losingHCHand));
    }

    public static void testCompareToPair(PokerHand pairHand, PokerHand anyHCHand, Testing myTestingSuite) {
        System.out.println("Testing this pair hand: " + pairHand + "\n" + "against this high-card hand: " + anyHCHand);
        myTestingSuite.assertEquals("Testing pair hand against high-card hand",
                1, pairHand.compareTo(anyHCHand));
    }

    public static void testCompareToTwoPair(PokerHand twoPairHand, PokerHand pairHand, Testing myTestingSuite) {
        System.out.println("Testing this two pair hand: " + twoPairHand + "\n" + "against this pair hand: " + pairHand);
        myTestingSuite.assertEquals("Testing two pair hand against pair hand",
                1, twoPairHand.compareTo(pairHand));
    }

    public static void testCompareToFlush(PokerHand flushHand, PokerHand twoPairHand, Testing myTestingSuite) {
        System.out.println("Testing this flush hand: " + flushHand + "\n" + "against this two pair hand: " + twoPairHand);
        myTestingSuite.assertEquals("Testing flush hand against two pair hand",
                1, flushHand.compareTo(twoPairHand));
    }




    public static void main(String[] args) {

        System.out.println("~~Testing module~~\n\n");
        Testing myTestSuite = new Testing();

        PokerHand handFlush = new PokerHand();
        Card card1F = new Card("4", "2");
        Card card2F = new Card("2", "2");
        Card card3F = new Card("8", "2");
        Card card4F = new Card("11", "2");
        Card card5F = new Card("6", "2");
        handFlush.addCard(card1F);
        handFlush.addCard(card2F);
        handFlush.addCard(card3F);
        handFlush.addCard(card4F);
        handFlush.addCard(card5F);

        PokerHand handTwoPair = new PokerHand();
        Card card1TP = new Card("14", "2");
        Card card2TP = new Card("14", "3");
        Card card3TP = new Card("12", "1");
        Card card4TP = new Card("12", "0");
        Card card5TP = new Card("7", "2");
        handTwoPair.addCard(card1TP);
        handTwoPair.addCard(card2TP);
        handTwoPair.addCard(card3TP);
        handTwoPair.addCard(card4TP);
        handTwoPair.addCard(card5TP);

        PokerHand handPair = new PokerHand();
        Card card1p = new Card("14", "2");
        Card card2p = new Card("14", "3");
        Card card3p = new Card("5", "1");
        Card card4p = new Card("8", "0");
        Card card5p = new Card("2", "2");
        handPair.addCard(card1p);
        handPair.addCard(card2p);
        handPair.addCard(card3p);
        handPair.addCard(card4p);
        handPair.addCard(card5p);

        PokerHand handWinningHighCard = new PokerHand();
        Card card1whc = new Card("14", "2");
        Card card2whc = new Card("11", "3");
        Card card3whc = new Card("9", "0");
        Card card4whc = new Card("7", "1");
        Card card5whc = new Card("2", "2");
        handWinningHighCard.addCard(card1whc);
        handWinningHighCard.addCard(card2whc);
        handWinningHighCard.addCard(card3whc);
        handWinningHighCard.addCard(card4whc);
        handWinningHighCard.addCard(card5whc);

        PokerHand handLosingHighCard = new PokerHand();
        Card card1lhc = new Card("4", "2");
        Card card2lhc = new Card("2", "3");
        Card card3lhc = new Card("9", "0");
        Card card4lhc = new Card("7", "1");
        Card card5lhc = new Card("3", "2");
        handLosingHighCard.addCard(card1lhc);
        handLosingHighCard.addCard(card2lhc);
        handLosingHighCard.addCard(card3lhc);
        handLosingHighCard.addCard(card4lhc);
        handLosingHighCard.addCard(card5lhc);


        System.out.println("Now comparing a high-card hand to a lesser high-card hand...");
        testCompareToHighCard(handWinningHighCard, handLosingHighCard, myTestSuite);

        System.out.println("Now comparing a pair hand to a high-card hand...");
        testCompareToPair(handPair, handWinningHighCard, myTestSuite);

        System.out.println("Now comparing a two pair hand to a pair hand...");
        testCompareToTwoPair(handTwoPair, handPair, myTestSuite);

        System.out.println("Now comparing a flush hand to a two pair hand...");
        testCompareToFlush(handFlush, handTwoPair, myTestSuite);



    }
}
