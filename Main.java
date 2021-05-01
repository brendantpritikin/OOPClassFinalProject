import java.util.ArrayList;
import java.util.Scanner;

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

public class Main {


    /**
     * Builds a Deck object, returns it.
     * @return 52-card Deck object.
     */
    public static Deck buildDeck() {
        Deck newDeck = new Deck();
        return newDeck;
    }

    /**
     * Shuffles passed-in deck in-place.
     * @param passedDeck passed-in 52-card Deck.
     */
    public static void shuffleDeck(Deck passedDeck) {
        passedDeck.shuffle();

    }

    /**
     * Removes two cards from the passed-in Deck and creates a stud poker hand with it, returns it.
     * @param passedDeck passed-in Deck.
     * @return Two-card PokerHand.
     */
    public static StudPokerHand buildStudPokerHand(Deck passedDeck, CommunityCardSet communityCards) {

        Card newSPHCard1 = passedDeck.deal();
        Card newSPHCard2 = passedDeck.deal();
        ArrayList<Card> StudPokerHandCards = new ArrayList<>();
        StudPokerHandCards.add(newSPHCard1);
        StudPokerHandCards.add(newSPHCard2);
        StudPokerHand newStudPokerHand = new StudPokerHand(communityCards, StudPokerHandCards);
        newStudPokerHand.addCard(newSPHCard1);
        newStudPokerHand.addCard(newSPHCard2);
//        System.out.println("new stud poker hand is: " + newStudPokerHand);

        return newStudPokerHand;
        //        StudPokerHand newHand = new StudPokerHand();
//
//        for (int cardToAdd = 0; cardToAdd < 2; cardToAdd++) {
//            Card newCard = passedDeck.deal();
//            newHand.addCard(newCard);
//        }
//        return newHand;
    }

    /**
     * Removes five cards from the passed-in Deck and creates a Community Card Set with it, returns it.
     * @param passedDeck Passed-in Deck.
     * @return Five-card PokerHand.
     */
    public static CommunityCardSet getCommunityCards(Deck passedDeck) {
        CommunityCardSet newCommunityCardSet = new CommunityCardSet();

        for (int cardToAdd = 0; cardToAdd < 5; cardToAdd++) {
            Card newCard = passedDeck.deal();
            newCommunityCardSet.addCard(newCard);
        }
//        System.out.println("Here are your community cards internal CCSET: " + newCommunityCardSet);
        return newCommunityCardSet;
    }

//    /**
//     * Tests given hand to see if it's a Flush, Two Pair, Pair, or High Card hand, returns test result.
//     * @param passedHand passed-in PokerHand.
//     * @return test result: 'Flush', 'Two Pair', 'Pair', or 'High Card'
//     */
//    public String testHand(PokerHand passedHand) {
//        return passedHand.handTests();
//    }


    /**
     * Runs a single game, returns win (True) or loss (False) result.
     * @param passedDeck passed-in Deck.
     * @return True or False.
     */
    public static boolean playGame(Deck passedDeck) {

        boolean isWinner = false;
        String userGuess = "";
        boolean validUserEntry = false;

        CommunityCardSet gameCommunityCards = getCommunityCards(passedDeck);
        System.out.println("Here are your community cards: " + gameCommunityCards);
        StudPokerHand studPokerHand1 = buildStudPokerHand(passedDeck, gameCommunityCards);
        StudPokerHand studPokerHand2 = buildStudPokerHand(passedDeck, gameCommunityCards);

        System.out.println("\nWe've pulled two new sets of hole cards, each being a two-card hand, from a " +
                "freshly-shuffled deck! Here are the two hands: \n");
        System.out.println("Hand 1: " + studPokerHand1);
        System.out.println("Hand 2: " + studPokerHand2);

        int winner = studPokerHand1.compareTo(studPokerHand2);

        Scanner userGuessScannerObj = new Scanner(System.in);
        System.out.print("\nNow, which hand, when added to the community cards, makes the better five-card" +
                " hand?\nPlease enter the hand number " + "that you think is worth more. \nOr, if you think that the" +
                " two hands are tied, please enter '3'.\n" +
                "\nPlease enter your choice followed by the 'return' key: ");
        userGuess = userGuessScannerObj.nextLine();

        if (userGuess.equals("1") || userGuess.equals("2") || userGuess.equals("3")) {
            validUserEntry = true;
        }

        while (validUserEntry == false) {

            System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n" +
                    "Oops! You either didn't enter a guess or entered an invalid guess.\n" +
                    "Please type in your guess and press the 'return' key... \nn..enter 1 to choose Hand 1\nEnter" +
                    " 2 to choose Hand 2\n" +
                    " Enter 3 if you think that the two hands result in a tie.\n\nPlease enter your choice now" +
                    " followed by the 'return' key: ");
            userGuess = userGuessScannerObj.nextLine();

            if (userGuess.equals("1") || userGuess.equals("2") || userGuess.equals("3")) {
                validUserEntry = true;
            }
        }

        if (userGuess.equals("1") && winner == 1) {
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            String userGuessCorrect = String.format("You're right! Hand %s is worth more!", userGuess);
            isWinner = true;
            return isWinner;
        } else if (userGuess.equals("2") && winner == -1) {
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            String userGuessCorrect = String.format("You're right! Hand %s is worth more!", userGuess);
            isWinner = true;
            return isWinner;
        } else if (userGuess.equals("3") && winner == 0) {
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            String userGuessCorrect = String.format("You're right! Hand %s is worth more!", userGuess);
            isWinner = true;
            return isWinner;
        } else {
            return false;
        }
    }


    /**
     * Runs a simulation of playing a simplified Stud Poker game with user input, 11
     * rounds max (one deck of cards, player vs. computer).
     */
    public static void runSimulation() {


        Deck myDeck = buildDeck();
        shuffleDeck(myDeck);

        boolean userIsWinning = true;
        int userPointTotal = 0;
        int maximumGamesPerDeck = 11;
        char continueGame = 'Y';
        String stopForUserKeyPress = "";

        System.out.println("\nWelcome! Today we're going to play a game of " + "'Which STUD POKER hand is worth more?'\n");
        System.out.println("We'll draw five 'community cards', and two sets of 'hole cards'. Your goal will be to" +
                " determine \nwhich hand of hole cards, when considered with the five community cards on the table, " +
                "can make a better\nfive-card poker hand.\n\n" +
                "The hands are ranked using this hierarchy from highest to lowest-ranked:\n\n" + "1. Flush\n2. Two Pair\n" +
                "3. Pair\n4. High Card\n");
        System.out.println("That is, a Flush is worth the most points, and then a Two Pair, and then a Pair, etc.");
        System.out.println("Guess correctly and you'll get to move on to the next round and " +
                "have a point added to your tally!");
        System.out.println("Guess wrong, though, and the game is OVER... just... like... that.\n");
        System.out.println("Ready? Let's start the game!\n");

        while (userIsWinning == true && continueGame != 'N') {

            Scanner continueGameScannerObj = new Scanner(System.in);
            System.out.println("\n***** Press the 'return' key to play a new round *****\n");
            stopForUserKeyPress = continueGameScannerObj.nextLine();

            if (continueGame != 'N') {

                if (userPointTotal != maximumGamesPerDeck) {
                    if (myDeck.size() <= 8 || myDeck.isEmpty()) {
                        myDeck = new Deck();
                        myDeck.shuffle();
                    }
                    userIsWinning = playGame(myDeck);

                    if (userIsWinning == true) {
                        userPointTotal += 1;
                        System.out.println("************CORRECT!*************\n");
                        System.out.println("You get to move on to the next round, and you've earned a point!");
                        System.out.println("Your current point total is: " + userPointTotal);
                        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                    } else if (userIsWinning == false) {
                        System.out.println("Aww, sorry! That wasn't the right answer. You lose.\n\n" +
                                "~~~~~GAME OVER~~~~");
                        System.out.println("Your final score is: " + userPointTotal);
                        System.out.println("Thanks for playing!");
                        continueGame = 'N';
                    }
                }

                if (userPointTotal == maximumGamesPerDeck) {
                    System.out.println("WOW! You've won AlL 11 GAMES! Go buy yourself an ice cream, you deserve it!\n" +
                            "\nThanks for playing!");
                    continueGame = 'N';
                }
            }
        }
    }


    public static void main(String[] args) {

        runSimulation();
    }
}
