import java.util.ArrayList;

/**
 @author Brendan Pritikin
  *Professor Aaron Cass
  *CSC 120
  *Fall 2020
  *Project 4
  *
  * I affirm that I have carried out my academic endeavors with full academic honesty.
  *
*/


public class StudPokerHandTester {


    public static void testAddCardToStudPokerHand(StudPokerHand myStudPokerHand, Card cardToAdd, Testing myTestingSuite) {
        System.out.println("Testing adding this card to an empty StudPokerHand: " + cardToAdd + " ");
        myStudPokerHand.addCard(cardToAdd);
        myTestingSuite.assertEquals("Testing adding card to empty StudPokerHand",
                cardToAdd, myStudPokerHand.getIthCard(0));
    }

    public static void testFindCardFromCommCardSet(StudPokerHand myPreFilledStudPokerHand, Card cardToFind, Testing myTestingSuite) {
        System.out.println("Testing finding a pre-filled card in a StudPokerHand : " + cardToFind + " ");
        myTestingSuite.assertEquals("Testing finding card in a pre-filled StudPokerHand",
                cardToFind, myPreFilledStudPokerHand.getIthCard(0));
    }

    public static void testCompareToFlushSPH(StudPokerHand winningHand, StudPokerHand losingHand,
                                             CommunityCardSet myCommunityCardSet, Testing myTestingSuite) {
        System.out.println("Testing compareTo in StudPokerHand. Testing this hand: " + winningHand + "\n" + "against" +
                " this losing hand: " + losingHand);
        myTestingSuite.assertEquals("Testing tied StudPokerHand hand against other StudPokerHand",
                0, winningHand.compareTo(losingHand));
    }


    public static void main(String[] args) {

        System.out.println("\n~~Testing module~~\n\n");
        Testing myTestSuite = new Testing();

        StudPokerHand myStudPokerhand = new StudPokerHand();
        Card cardToAddToEmpty = new Card(2, 3);
        testAddCardToStudPokerHand(myStudPokerhand, cardToAddToEmpty, myTestSuite);

        CommunityCardSet preFilledCommunityCardSet = new CommunityCardSet();
        Card cardToAdd1 = new Card(4, 1);
        Card cardToAdd2 = new Card(5, 1);
        Card cardToAdd3 = new Card(6, 2);
        Card cardToAdd4 = new Card(8, 3);
        Card cardToAdd5 = new Card(2, 0);
        preFilledCommunityCardSet.addCard(cardToAdd1);
        preFilledCommunityCardSet.addCard(cardToAdd2);
        preFilledCommunityCardSet.addCard(cardToAdd3);
        preFilledCommunityCardSet.addCard(cardToAdd4);
        preFilledCommunityCardSet.addCard(cardToAdd5);

        StudPokerHand myCommCardFindStudPokerHand = new StudPokerHand();
        Card cardToFindInSPH = new Card(2, 3);
        myCommCardFindStudPokerHand.addCard(cardToFindInSPH);
        testFindCardFromCommCardSet(myStudPokerhand, cardToFindInSPH, myTestSuite);


        ArrayList<Card> StudPokerHand1Cards = new ArrayList<>();
        Card cardToAdd1SPH1 = new Card(7, 1);
        Card cardToAdd2SPH1 = new Card(12, 1);
        StudPokerHand1Cards.add(cardToAdd1SPH1);
        StudPokerHand1Cards.add(cardToAdd2SPH1);
        StudPokerHand StudPokerHand1 = new StudPokerHand(preFilledCommunityCardSet, StudPokerHand1Cards);

        ArrayList<Card> StudPokerHand2Cards = new ArrayList<>();
        Card cardToAdd1SPH2 = new Card(11, 1);
        Card cardToAdd2SPH2 = new Card(14, 1);
        StudPokerHand1Cards.add(cardToAdd1SPH1);
        StudPokerHand1Cards.add(cardToAdd2SPH1);
        StudPokerHand StudPokerHand2 = new StudPokerHand(preFilledCommunityCardSet, StudPokerHand1Cards);

        System.out.println("Now testing StudPokerHand's compareTo method...");
        testCompareToFlushSPH(StudPokerHand1, StudPokerHand2, preFilledCommunityCardSet, myTestSuite);

    }
}