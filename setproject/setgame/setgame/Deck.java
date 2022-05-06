public class Deck {
    static Card[] fullDeck = new Card[81];

    //method that creates a deck of 81 unique cards
    public Card[] createDeck() {
        for(int a = 0; a < fullDeck.length; a++){
            for(Card.PossibleColors col: Card.PossibleColors.values()) {
                for(Card.PossibleShadings shd: Card.PossibleShadings.values())  {
                    for(Card.PossibleShapes shp: Card.PossibleShapes.values()) {
                        for(Card.PossibleNumbers num: Card.PossibleNumbers.values()) {
                            fullDeck[a] = new Card(col, shd, shp, num);
                        }
                    }
                }
            }
        } return fullDeck;

    }

    //method that shuffles the deck
    public Card[] shuffle(Card[] deck) {
        int currentIndex = deck.length;
        int randomIndex;
        while (currentIndex != 0) {
            randomIndex = (int) Math.floor(Math.random() * currentIndex);
            currentIndex--;
            Card temp = deck[currentIndex];
            deck[currentIndex] = deck[randomIndex];
            deck[randomIndex] = temp;

        }

        return deck;
    }
}
