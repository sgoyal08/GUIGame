import java.util.ArrayList;

public class Deck {
    // Spersh Goyal
// CS2 2023




        private ArrayList<Card> cards;
        private int cardsLeft;

        //Initializes deck with arraylists of card attributes (suit, point, rank)
        public Deck( String[] suitList, int[] pointList, String[] rankList)
        {
            cards = new ArrayList<>();
            for (String suit : suitList)
            {
                for (int j = 0; j < pointList.length; j++)
                {
                    Card  c = new Card(rankList[j], suit, pointList[j]);

                    cards.add(c);

                }
            }
            cardsLeft = cards.size();
            shuffle();

        }
        // returns true if deck is empty, false otherwise
        public boolean isEmpty()
        {
            return cardsLeft == 0;
        }

        // returns how many cards are left in the deck
        public int getCardsLeft()
        {
            return cardsLeft;
        }

        // selects and returns if the card is in the deck
        // returns null if empty
        public Card deal()
        {
            if (getCardsLeft() == 0)
            {
                return null;
            }
            return cards.get(--cardsLeft);
        }

        // reorders the cards to create a shuffled deck
        public void shuffle()
        {

            for (int i = cardsLeft - 1; i >= 0; i--)
            {
                int r = (int)(Math.random() * i);

                Card temp = cards.get(i);
                cards.set(i, cards.get(r));
                cards.set(r, temp);
            }
        }


}
