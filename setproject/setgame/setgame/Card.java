package setgame;

/* 
random 12, 3
 */

//import java.util.ArrayList;

public class Card {
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
    

    //method that compares 3 cards and checks whether they form a set
    public boolean isSet(Card first, Card second, Card third) {
        if(((first.color).equals(second.color) && (first.color).equals(third.color) && (second.color).equals(third.color))
                && ((first.shading).equals(second.shading) && (first.shading).equals(third.shading) && (second.shading).equals(third.shading))
                && ((first.shape).equals(second.shape) && (first.shape).equals(third.shape) && (second.shape).equals(third.shape))
                && (first.number == second.number && first.number == third.number && second.number == third.number)){
            return true;
        }else if((!(first.color).equals(second.color) && !(first.color).equals(third.color) && !(second.color).equals(third.color))
                && (!(first.shading).equals(second.shading) && !(first.shading).equals(third.shading) && !(second.shading).equals(third.shading))
                && (!(first.shape).equals(second.shape) && !(first.shape).equals(third.shape) && !(second.shape).equals(third.shape))
                && (!(first.number == second.number) && !(first.number == third.number) && !(second.number == third.number))){
          return true;
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
