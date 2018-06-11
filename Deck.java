//this linked list is responsible for the deck of cards, in which each player gets 8 cards at the start of the game. This list is never used again.
public class Deck {
	card head = null;
	
	class card {
		
		card link;//intialize a link that links the next node in the list
		int suit;//integer menu system for suits (design on cards)
		int value;//integer menu system for number on the card
		public card(int x, int y, card c) {//constructor that takes in the values and assigns to each field
			suit = y;
			value = x;
			link = c;
		}
	}
	
	public void addcard(int x, int y) {//instance method for adding nodes in the front of this list
		head = new card(x,y,head);
	}
	
	public void printlist() {//instance method that loops through list and prints
		for (card temp = head; temp != null; temp = temp.link) {
			System.out.println(temp.value + " " + temp.suit);
		}
	}
	
	public card getposition(int y) { //instance method that takes in position ex. position 0 = head
		card temp = head;
		for (int x = 0; x < y ; x++) {
			temp = temp.link;
		}
		return temp;
	}
	public void deletecard(int x, int y) {//instance method that deletes a node(card) in the deck list
		card current = head;
		card previous = null;
		boolean found = false;
		while(found == false && current != null) {//searches for node
			if(x == current.value && y == current.suit) {
				found = true;
			}
			else {
				previous = current;
				current = current.link;
			}
		}
		if (found == true) {//takes node out if found is true
			if (current == head) {
				head = head.link;
			}
			else {
				previous.link = current.link;
			}
		}
	}
	
}
