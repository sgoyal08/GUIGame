import java.util.ArrayList;

public class Player {
    // Spersh Goyal
// CS2 2023

        // instance variables representing a hand of cards, and the point values
        private int points;
        private ArrayList<Card> hand;

        private String name;

        // constructor that initializes name, and sets point to 0.
        public Player(String name)
        {
            this.name = name;
            this.points = 0;
            this.hand = new ArrayList<Card>();
        }
        // constructor that initializes name, hand, and sets point to 0
        public Player(String name, ArrayList<Card> hand)
        {
            this.hand = hand;
            this.name = name;
            this.points = 0;
        }

        // getter method: returns points
        public int getPoints()
        {
            return points;
        }

        // setter methods for points and hand.
        public void setPoints(int points)
        {
            this.points = points;
        }

        public void setHand(ArrayList<Card> hand)
        {
            this.hand = hand;
        }

        // getter method: returns hand
        public ArrayList<Card> getHand()
        {
            return hand;
        }

        // takes in a number of points to add to current point values.
        public int addPoints(int morePoints)
        {
            return points += morePoints;
        }

        // adds a new card to the players hand
        public void addCard(Card newCard)
        {
            hand.add(newCard);
        }

        // returns a card that is going to be removed when the player places a card in the war
        public Card removeCard()
        {
            return hand.remove(0);
        }

        public String getName() {
            return name;
        }


        // tostring emthod that returns a string in format
        public String toString()
        {
            return name + " has " + points + " points\n"
                    + name + "'s cards: " + hand;
        }


}
