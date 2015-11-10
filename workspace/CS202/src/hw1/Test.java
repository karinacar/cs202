package hw1;

public class Test {

	public static void main(String[] args) {
		Deck deck1 = new Deck();
		
		Deck deck2 = deck1.split();
		System.out.printf("Player 1 deck has %s cards\n", deck1.getCount());
		System.out.printf("Player 2 deck has %s cards\n", deck2.getCount());
		
		for(int i = 0; i< 26; i++){
			System.out.printf("Player 1 drew %s\n", deck1.dealCard());
			System.out.printf("Player 2 drew %s\n", deck2.dealCard());
		}
	}
}

/*


Include a Test class with a main method that creates a deck, 
withdraws and prints the suit and rank of 3 cards.

1pt extra credit: implement a toString() method that prints out the suit and rank of the card, e.g., "King of Hearts" for the

king of hearts. 

Submit your Deck.java and Card.java files here.*/