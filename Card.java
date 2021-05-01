
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


public class Card {

    private String cardRank;
    private String cardSuit;

    /**
     *
     * @param rank whole cards (2-10) can either be spelled
     *             out like "two" or numeric like "2". Case
     *             insensitive.
     * @param suit "Spades", "Hearts", "Clubs", or "Diamonds"
     */
    public Card(String rank, String suit)
    {
        this.cardRank = rank;
        this.cardSuit = suit;
    }

    /**
     * Creates a card with a given rank and suit.
     *
     * @param rank The rank of the card, which must be between
     *             2 and 14, inclusive.
     * @param suit The suit of the card, which must be
     *             0=SPADES, 1=HEARTS, 2=CLUBS, or 3=DIAMONDS
     */
    public Card(int rank, int suit)
    {
        if (rank >= 2 && rank <= 14) {
            this.cardRank = "" + rank + "";
            this.cardSuit = "" + suit + "";
        } else {
            System.out.println("ERROR. RANK MUST BE BETWEEN 2 AND 14, INCLUSIVE. PLEASE TRY AGAIN. DEFAULTING TO RANK = 2");
            this.cardRank = "2";
            this.cardSuit = "" + suit + "";
        }
    }

    public String getCardRank() {
        return this.cardRank;
    }

    public String getCardSuit() {
        return this.cardSuit;
    }


    /**
     * Converts card suit from numbers to English names, returns it.
     * @return card with suit in English.
     */
    public String toString() {

        String readableCard = "";


        if (cardRank.equalsIgnoreCase("Two")) {
            readableCard += "2";
        } else if (cardRank.equalsIgnoreCase("Three")) {
            readableCard += "3";
        } else if (cardRank.equalsIgnoreCase("Four")) {
            readableCard += "4";
        } else if (cardRank.equalsIgnoreCase("Five")) {
            readableCard += "5";
        } else if (cardRank.equalsIgnoreCase("Six")) {
            readableCard += "6";
        } else if (cardRank.equalsIgnoreCase("Seven")) {
            readableCard += "7";
        } else if (cardRank.equalsIgnoreCase("Eight")) {
            readableCard += "8";
        } else if (cardRank.equalsIgnoreCase("Nine")) {
            readableCard += "9";
        } else if (cardRank.equalsIgnoreCase("Ten")) {
            readableCard += "10";
        } else if (cardRank.equalsIgnoreCase("Jack") || cardRank.equals("11")) {
            readableCard += "Jack";
        } else if (cardRank.equalsIgnoreCase("Queen") || cardRank.equals("12")) {
            readableCard += "Queen";
        } else if (cardRank.equalsIgnoreCase("King") || cardRank.equals("13")) {
            readableCard += "King";
        } else if (cardRank.equalsIgnoreCase("Ace") || cardRank.equals("14")) {
            readableCard += "Ace";
        } else {
            readableCard += cardRank;
        }

        readableCard += (" of ");

        if (cardSuit.equalsIgnoreCase("SPADES")|| cardSuit.equals("0")) {
            readableCard += "Spades";
        } else if (cardSuit.equalsIgnoreCase("HEARTS")|| cardSuit.equals("1")) {
            readableCard += "Hearts";
        } else if (cardSuit.equalsIgnoreCase("CLUBS")|| cardSuit.equals("2")) {
            readableCard += "Clubs";
        } else if (cardSuit.equalsIgnoreCase("DIAMONDS")|| cardSuit.equals("3")) {
            readableCard += "Diamonds";
        }

        readableCard += "";

        return readableCard;
    }


    /**
     * Custom equals method, as necessary.
     * @param other passed-in card.
     * @return equality values set.
     */
    public boolean equals(Card other) {
        return other.cardRank == this.cardRank && other.cardSuit == this.cardSuit;
    }


    public static void main(String[] args) {

        System.out.println("\nClass Card\n~~~~~~~");
        System.out.println("Let's make a new card and display it.");
        Card myCard = new Card("5", "2");
        System.out.println("Done.\nYour new card is:");
        System.out.println(myCard);
        System.out.println("Your card's rank is: " + myCard.getCardRank());
        System.out.println("Your card's suit is: " + myCard.getCardSuit());
    }
}
