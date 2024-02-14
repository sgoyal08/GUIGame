import java.util.ArrayList;
import java.lang.Math;
public class Card {
    // Spersh Goyal
// CS2 2023


        private String rank;
        private String suit;
        private int points;

        // initializes card variables with a rank, suit, and points.
        public Card(String rank, String suit, int points)
        {
            this.rank = rank;
            this.suit = suit;
            this.points = points;
        }

        // returns the rank of card
        public String getRank()
        {
            return this.rank;
        }

        // sets the rank of card to the variable "rank"
        public void setRank(String rank)
        {
            this.rank = rank;
        }

        // returns the suit of a given card
        public String getSuit()
        {
            return this.suit;
        }

        // sets the suit of card to the variable "suit"
        public void setSuit(String suit)
        {
            this.suit = suit;
        }

        // returns the point value of a given card
        public int getPoints()
        {
            return this.points;
        }

        // sets the points of the card to the variable "points"
        public void setPoints(int points)
        {
            this.points = points;
        }

        // returns a string representation of the card in format (rank of suit)
        public String toString()
        {
            return (rank + " of " + suit);
        }


}
