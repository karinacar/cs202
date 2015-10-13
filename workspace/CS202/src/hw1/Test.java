package hw1;

public class Test {

	public static void main(String[] args) {
		Deck deck1 = new Deck();
		
		for(int i = 0; i< 4; i++){
			System.out.println(deck1.dealCard());
		}
	}
}

/*


Include a Test class with a main method that creates a deck, 
withdraws and prints the suit and rank of 3 cards.

1pt extra credit: implement a toString() method that prints out the suit and rank of the card, e.g., "King of Hearts" for the

king of hearts. 

Submit your Deck.java and Card.java files here.*/