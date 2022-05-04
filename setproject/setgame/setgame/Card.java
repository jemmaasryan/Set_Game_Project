package setgame;

/* 
random 12, 3
 */

//import java.util.ArrayList;

public class Card {
    
    /*public enum possibleColors {RED, GREEN, PURPLE};
    public enum possibleShadings {EMPTY, FILLED, STRIPED};
    public enum possibleShapes {DIAMOND, WAVE, OVAL};
    public enum possibleNumbers {ONE, TWO, THREE};

    private possibleColors color;
    private possibleShadings shading;
    private possibleShapes shape;
    private possibleNumbers number;
    protected static Card[] deck = new Card[81];


    public Card(){
        this.color = possibleColors.RED;
        this.shape = possibleShapes.DIAMOND;
        this.shading = possibleShadings.EMPTY;
        this.number = possibleNumbers.ONE;
    }

    public Card(possibleColors color, possibleShadings shading, possibleShapes shape, possibleNumbers number) {
        this.color = color;
        this.shading = shading;
        this.shape = shape;
        this.number = number;
    }
    
    public Card[] createDeck() {
        for(int a = 0; a < deck.length; a++){
            for(possibleColors col: possibleColors.values()) {
                for(possibleShadings shd: possibleShadings.values())  {
                    for(possibleShapes shp: possibleShapes.values()) {
                        for(possibleNumbers num: possibleNumbers.values()) {
                            deck[a] = new Card(color, shading, shape, number);
                        }
                    }
                }
            }
        } return deck;

    }*/
    private String color;
    private String shading;
    private String shape;
    private int number;
    protected Card[] deck;

    public enum possibleColors {RED, GREEN, PURPLE};
    public enum possibleShadings {EMPTY, FILLED, STRIPED};
    public enum possibleShapes {DIAMOND, WAVE, OVAL};
    public enum possibleNumbers {ONE, TWO, THREE};

    public Card(){
        this.color = "red";
        this.shape = "diamond";
        this.shading = "empty";
        this.number = 1;
        this.deck = new Card[81];
    }
    public Card(Card copy) {
        Card newdeck = new Card();
        newdeck.color = copy.color;
        newdeck.shape = copy.shape;
        newdeck.shading = copy.shading;
        newdeck.number = copy.number;
        newdeck.deck = copy.deck;
    }

    // public Card(Card[] deck){
    //     this.deck = new 
    // }

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

    public Card(String col, String shd, String shp, int num) {
        this.color = col;
        this.shading = shd;
        this.shape = shp;
        this.number = num;

    }
    
    //method that creates a deck of 81 unique cards
    public Card[] createDeck() {
    for(int a = 0; a < deck.length; a++){
        for(int i = 0; i < possibleColors.length; i++) {
            for(int j = 0; j < possibleShadings.length; j++)  {
                for(int k = 0; k < possibleShapes.length; k++) {
                    for(int l = 0; l < possibleNumbers.length; l++) {
                        deck[a] = new Card(color, shading, shape, number);
                    }
                }
            }
        }
    } return deck;
        
    }
    
    //method that removes an element from an array

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
    //method that removes 12 cards from the deck and creates the cards on the board

    public Card[] createCardsOnBoard (Card[] deck) {
        Card[] cardsOnBoard = new Card[12];
        Card[] shuffledDeck = shuffle(deck);
        for(int i = 0; i < cardsOnBoard.length; i++) {
            cardsOnBoard[i] = shuffledDeck[i];
        }
        return cardsOnBoard;
    }
    

    ///method that compares 3 cards and checks whether they form a set
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

    Card[] cardsOnBoard = new Card[12];
    //method to check if there is a set present in the cards on the board
    public boolean isSetPresent(Card[] cardsOnBoard){
        
        for(int firstCard = 0; firstCard <= cardsOnBoard.length - 3;firstCard++) {
            for(int secondCard = firstCard+1; secondCard <= cardsOnBoard.length - 2; secondCard++) {
                for(int i = secondCard+1; i <= cardsOnBoard.length - 1; i++){
                
                    if(isSet(deck[firstCard], deck[secondCard], deck[i])){
                        return true;
                    } 
                    
                }
                
            }  
        }
        return false;
        
        
        
        
       
    }

    

}
