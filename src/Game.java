import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    // Spersh Goyal
// cs2 2023


        private ArrayList<Player> players;
        private Deck deck;
        private final String[] RANKS_LIST = {"two", "three", "four", "five", "six",
                "seven", "eight", "nine", "ten", "jack", "queen", "king", "ace"};
        private final String[] SUIT_LIST = {"Diamonds", "Hearts", "Clubs", "Spades"};
        private final int[] VALUES_LIST = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
                12, 13, 14};

        public Game() {
            // gets # of players (always two players, couldnt make more than that work)
            Scanner input = new Scanner(System.in);
            System.out.println("Number of players: ");
            int numPlayers = input.nextInt();

            // consumes the \n after int allowing us to input both player names.
            input.nextLine();

            // initalizes arraylist of players
            players = new ArrayList<>();

            // adds each player to arraylist
            for (int i = 0; i < numPlayers; i++) {
                System.out.println("Player name: ");
                String name = input.nextLine();
                Player temPlayer = new Player(name);
                players.add(temPlayer);
            }
            deck = new Deck(SUIT_LIST, VALUES_LIST, RANKS_LIST);

            int discard = deck.getCardsLeft() % numPlayers;
            int hand_size = deck.getCardsLeft() / numPlayers;

            // discards leftover cards, so equally distributed hands for multi player war
            for (int i = 0; i < discard; i++) {
                deck.deal();
            }

            // asigns hands to each player
            for (int i = 0; i < hand_size; i++) {
                for (Player p : players) {
                    p.addCard(deck.deal());
                }
            }
        }
        // prints instructions of game.
        public void printInstructions()
        {
            System.out.println(" This is a War Card Game. First, the deck is shuffled, and evenly split amongst all players");
            System.out.println("Next, each player draws a card, and whoever has the highest card takes the pot");
            System.out.println("If the card values are tied, each player places 3 more cards, and whoever draws the higher 4th card takes the pot");
            System.out.println("Whoever has the most cards/all of the cards wins");
        }
        public void playGame()
        {
            Scanner input = new Scanner(System.in);
            while (players.size() > 1)
            {
                System.out.println("Hit enter to play a new round!");
                input.nextLine();

                Player winner = null;
                ArrayList<Card> pile = new ArrayList<>();
                Player p1 = players.get(0);
                Player p2 = players.get(1);

                // iterates over the players, and puts the card at the top of their hand, at the top of the pile
                Card c1 = p1.removeCard();
                Card c2 = p2.removeCard();

                // finds the winning point value, and the player that corresponds to that value
                if (c1.getPoints() > c2.getPoints())
                {
                    winner  = p1;
                    p1.addCard(c2);
                    p1.addCard(c1);
                }
                else if (c2.getPoints() > c1.getPoints())
                {
                    winner = p2;
                    p2.addCard(c2);
                    p2.addCard(c1);
                }
                // if its a war then go to this else
                else
                {
                    while (winner == null)
                    {
                        if (p1.getHand().isEmpty()) {
                            winner = p2;
                            System.out.println("Player 1 ran out of cards, player 2 is the winner");
                        } else if (p2.getHand().isEmpty()) {
                            winner = p1;
                            System.out.println("Player 2 ran out of cards, player 1 is the winner");
                        }
                        // if both players have the cardsto play  a war, go on
                        else {

                            {
                                ArrayList<Card> p1WarCards = new ArrayList<>();
                                ArrayList<Card> p2WarCards = new ArrayList<>();
                                for (int i = 0; i < 4; i++) {
                                    if (!p1.getHand().isEmpty()) {
                                        Card temp = p1.removeCard();
                                        p1WarCards.add(temp);
                                        pile.add(temp);
                                    }
                                    if (!p2.getHand().isEmpty()) {
                                        Card temp = p2.removeCard();
                                        p2WarCards.add(temp);
                                        pile.add(temp);
                                    }

                                }
                                c1 = p1WarCards.get(p1WarCards.size() - 1);
                                c2 = p2WarCards.get(p2WarCards.size() - 1);
                                if (c1.getPoints() > c2.getPoints()) {
                                    winner = p1;
                                    p1.addCard(c2);
                                    p1.addCard(c1);
                                } else if (c2.getPoints() > c1.getPoints()) {
                                    winner = p2;
                                    p2.addCard(c2);
                                    p2.addCard(c1);
                                }

                            }

                        }
                    }

                }
                Player loser = null;
                if (p1.equals(winner))
                {
                    System.out.println(p1.getName() + " wins the round with " + c1);
                    System.out.println(p2.getName() + " loses the round with " + c2);

                    if (p2.getHand().isEmpty())
                    {
                        players.remove(p2);
                        System.out.println(p1.getName() +  "wins the whole game!");
                    }
                    for (Card card : pile)
                    {
                        p1.addCard(card);
                    }
                }
                else
                {
                    System.out.println(p2.getName() + " wins the round with " + c2);
                    System.out.println(p1.getName() + " loses the round with " + c1);

                    if (p1.getHand().isEmpty())
                    {
                        players.remove(p1);
                        System.out.println(p2.getName() +  "wins the whole game!");
                    }
                    for (Card card : pile)
                    {
                        p2.addCard(card);

                    }
                }

            }
        }
        public static void main(String[] args)
        {
            Game fun = new Game();
            fun.printInstructions();
            fun.playGame();
        }

    }

