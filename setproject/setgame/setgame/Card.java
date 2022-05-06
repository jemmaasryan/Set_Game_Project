//package setgame;
//import java.util.ArrayList;

//make an ArrayList
//file i/o
//inheritance
//push in github

public class Card {

    public enum PossibleColors {RED, GREEN, PURPLE}
    public enum PossibleShadings {EMPTY, FILLED, STRIPED}
    public enum PossibleShapes {DIAMOND, WAVE, OVAL}
    public enum PossibleNumbers {ONE, TWO, THREE}

    private PossibleColors color;
    private PossibleShadings shading;
    private PossibleShapes shape;
    private PossibleNumbers number;

    public Card(){
        this.color = PossibleColors.RED;
        this.shape = PossibleShapes.DIAMOND;
        this.shading = PossibleShadings.EMPTY;
        this.number = PossibleNumbers.ONE;
    }

    public Card(PossibleColors color, PossibleShadings shading, PossibleShapes shape, PossibleNumbers number) {
        this.color = color;
        this.shading = shading;
        this.shape = shape;
        this.number = number;
    }

    /*public Card(Card copy) {
        Card newdeck = new Card();
        newdeck.color = copy.color;
        newdeck.shape = copy.shape;
        newdeck.shading = copy.shading;
        newdeck.number = copy.number;
    }*/


    //method that creates a deck of 81 unique cards
    // public  ArrayList<Card> createDeck() {
    //     ArrayList<Card> deck = new ArrayList<Card>(81);
    //     for(int i = 0; i < possibleColors.length; i++) {
    //         for(int j = 0; j < possibleShadings.length; j++)  {
    //             for(int k = 0; k < possibleShapes.length; k++) {
    //                 for(int l = 0; l < possibleNumbers.length; l++) {
    //                     deck.add(new Card(color, shading, shape, number));
    //                 }
    //             }
    //         }
    //     }
    //     return deck;

   /* public Card(String col, String shd, String shp, int num) {
        this.color = col;
        this.shading = shd;
        this.shape = shp;
        this.number = num;

    }*/

    //method that compares 3 cards and checks whether they form a set
    public boolean isSet(Card first, Card second, Card third) {
        if((first.color.ordinal() == second.color.ordinal() && first.color.ordinal() == third.color.ordinal() && second.color.ordinal() == third.color.ordinal()
        || (first.color.ordinal() != second.color.ordinal() && first.color.ordinal() != third.color.ordinal() && second.color.ordinal() != third.color.ordinal()
        ))){
            if((first.shading.ordinal() == second.shading.ordinal() && first.shading.ordinal() == third.shading.ordinal() && second.shading.ordinal() == third.shading.ordinal()
                    || (first.shading.ordinal() != second.shading.ordinal() && first.shading.ordinal() != third.shading.ordinal() && second.shading.ordinal() != third.shading.ordinal()
            ))){
                if((first.shape.ordinal() == second.shape.ordinal() && first.shape.ordinal() == third.shape.ordinal() && second.shape.ordinal() == third.shape.ordinal()
                        || (first.shape.ordinal() != second.shape.ordinal() && first.shape.ordinal() != third.shape.ordinal() && second.shape.ordinal() != third.shape.ordinal()
                ))){
                    if((first.number.ordinal() == second.number.ordinal() && first.number.ordinal() == third.number.ordinal() && second.number.ordinal() == third.number.ordinal()
                            || (first.number.ordinal() != second.number.ordinal() && first.number.ordinal() != third.number.ordinal() && second.number.ordinal() != third.number.ordinal()
                    ))){
                        return true;
                    }
                }
            }
        }
        return false;

    }

    public Card[] removeArrayElement (Card[] arr, int index) {
        Card[] newArray = new Card[arr.length - 1];
        int newIndex = 0;
        for(int i = 0; i < arr.length; i++) {
            if(i != index) {
                newArray[newIndex] = arr[i];
                newIndex++;
            }
        }
        return newArray;
    }

    public Card[] createCardsOnBoard (Card[] deck) {
        Card[] cardsOnBoard = new Card[12];
        Deck newDeck = new Deck();
        Card[] shuffledDeck = newDeck.shuffle(deck);
        for(int i = 0; i < cardsOnBoard.length; i++) {
            cardsOnBoard[i] = shuffledDeck[i];
        }
        return cardsOnBoard;
    }



    //method to check if there is a set present in the cards on the board
    public boolean isSetPresent(Card[] cardsOnBoard){
        for(int firstCard = 0; firstCard <= cardsOnBoard.length - 3;firstCard++) {
            for(int secondCard = firstCard+1; secondCard <= cardsOnBoard.length - 2; secondCard++) {
                for(int thirdCard = secondCard+1; thirdCard <= cardsOnBoard.length - 1; thirdCard++){

                    if(isSet(Deck.fullDeck[firstCard], Deck.fullDeck[secondCard], Deck.fullDeck[thirdCard])){
                        return true;
                    }

                }

            }
        }
        return false;
    }
}
