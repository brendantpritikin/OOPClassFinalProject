public class CommunityCardSetTester {

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

    public static void testAddCardToCommCardSet(CommunityCardSet communityCardSet, Card cardToAdd, Testing myTestingSuite) {
        System.out.println("Testing adding this card to an empty CommunityCardSet: " + cardToAdd + " ");
        communityCardSet.addCard(cardToAdd);
        myTestingSuite.assertEquals("Testing adding card to empty CommunityCardSet",
                cardToAdd, communityCardSet.getIthCard(0));
    }

    public static void testGetCardFromCommCardSet(CommunityCardSet communityCardSet, Card cardToFind, Testing myTestingSuite) {
        System.out.println("Testing adding this card to an empty CommunityCardSet: " + cardToFind + " ");
        myTestingSuite.assertEquals("Testing finding card in a pre-filled CommunityCardSet",
                cardToFind, communityCardSet.getIthCard(0));
    }


    public static void main(String[] args) {

        System.out.println("\n~~Testing module~~\n\n");
        Testing myTestSuite = new Testing();

        CommunityCardSet myEmptyCommunityCardSet = new CommunityCardSet();
        Card myCardToAdd = new Card(2, 3);

        System.out.println("Now adding a card to an empty CommunityCardSet...");
        testAddCardToCommCardSet(myEmptyCommunityCardSet, myCardToAdd, myTestSuite);


        CommunityCardSet preFilledCommunityCardSet = new CommunityCardSet();
        Card myCardToFind = new Card(4, 1);
        preFilledCommunityCardSet.addCard(myCardToFind);
        System.out.println("Now finding a card in a pre-filled community card set...");
        testAddCardToCommCardSet(preFilledCommunityCardSet, myCardToFind, myTestSuite);

    }
}