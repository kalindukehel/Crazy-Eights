//linked lidt for cards in each player's hand
public class Hand {

	card head = null;
	String name = "";//overwrites what name the players send in
	public Hand(String x) {//constructor that takes in string, assigning to player name
		name = x;
	}
	class card {
		
		card link;//link to connect nodes in list
		int suit;
		int value;
		public card(int x, int y, card c) {//constructor that assigns values to suit, link and value
			suit = y;
			value = x;
			link = c;
		}
	}
	
	public void addcard(int x, int y) {//instance method adds a node/card to the current players hand
		head = new card(x,y,head);//this method works everytime a player picks up a card from the pile. This increases the number of cards in their hand and nodes in the list.
	}
	
	public void printlist() {//instance method that prints list to display to user what cards they have
		for (card temp = head; temp != null; temp = temp.link) {
			System.out.println(temp.value + " " + temp.suit);
		}
	}
	
	public card getposition(int y) { //Takes in position ex. position 0 = head
		card temp = head;
		for (int x = 0; x < y ; x++) {
			temp = temp.link;
		}
		return temp;
	}
	
	public int counthand() {//instnace method that counts how many cards are in players hand for rank/ winner/loser purposes
		int count = 0;
		for (card temp = head; temp != null; temp = temp.link) {
			count = count + 1;
		}
		return count;
	}
	
	public void deletecard(int x, int y) {//when players puts a card in the draw pile, cards from their hand decreases. This instance method deletes a node/card from the players hand.
		card current = head;
		card previous = null;
		boolean found = false;
		while(found == false && current != null) {//finds the card to delete (that card is the one being placed on the draw pile, therefore it is deleting that node in this list).
			if(x == current.value && y == current.suit) {
				found = true;
			}
			else {
				previous = current;
				current = current.link;
			}
		}
		if (found == true) {//this takes the card out
			if (current == head) {
				head = head.link;
			}
			else {
				previous.link = current.link;
			}
		}
	}
	
}
