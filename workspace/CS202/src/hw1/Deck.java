package hw1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Deck {
	private Card[] cards;
	private int count;
	private int position;

	public Deck() {
		fillCardArray();
		shuffle();
		count = cards.length;
	}

	public Card dealCard() {
		Card card = null;
		if (position < cards.length) {
			card = cards[position];
		}
		position++;
		count--;
		
		return card;
	}

	public void shuffle() {
		ArrayList<Card> cardsList = new ArrayList<Card>(Arrays.asList(cards));
		Collections.shuffle(cardsList);
		cards = cardsList.toArray(new Card[cardsList.size()]);	
	}

	public Deck split() {
		Deck deck2 = new Deck();
		Card[] cardArray2 = Arrays.copyOf(cards, cards.length/2);
		cards = Arrays.copyOfRange(cards, 26, 52);
		count = cards.length;
		deck2.setCards(cardArray2);
		return deck2;
	}

	public void fillCardArray(){
		cards = new Card[52];
		
		for(int suitNo = 0; suitNo < 4; suitNo++){			
			for(int rankNo = 2; rankNo < 15; rankNo++){
				String suit = null;
				switch(suitNo){
					case 0:
						suit = Card.SPADES;
						break;
					case 1:
						suit = Card.HEARTS;
						break;
					case 2:
						suit = Card.DIAMONDS;
						break;
					case 3:
						suit = Card.CLUBS;
						break;
				}								
				cards[suitNo*13+(rankNo-2)]= new Card(rankNo, suit);
			}			
		}		
	}

	public Card[] getCards() {
		return cards;
	}

	public void setCards(Card[] cards) {
		this.cards = cards;
		count = cards.length;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
}
