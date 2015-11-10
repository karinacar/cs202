package hw1;

public class Card {
	// Class fields
	private int rank;
	private String suit;
	public final static String SPADES = "Spades";
	public final static String HEARTS = "Hearts";
	public final static String CLUBS = "Clubs";
	public final static String DIAMONDS = "Diamonds";

	// Constructors
	public Card() {
	}

	public Card(int rank, String suit) {
		this.rank = rank;
		this.suit = suit;
	}

	// Other methods
	public String toString() {
		String rankName = null;
		if (rank > 10) {
			switch (rank) {
			case 11:
				rankName = "Jack";
				break;
			case 12:
				rankName = "Queen";
				break;
			case 13:
				rankName = "King";
				break;
			case 14:
				rankName = "Ace";
				break;
			}
		} else {
			rankName = String.valueOf(rank);
		}

		return rankName + " of " + suit;
	}

	// Getters and Setters
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}
}
