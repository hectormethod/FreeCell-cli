import java.util.*;


public class CardCollect extends Stack <Card> {
	

	public CardCollect(){
	
	}
	
	public void pushCard(Card card){
		push(card);
	}
	
	public Card popTopCard(){
		if (isEmpty()) { 
			return null;
			}
		else return pop();  //pop off the top card of the column
	}
	
	public Card peekTopCard(){
		if (isEmpty()){
		return null;
		}
		return peek();
	}
	
	public boolean playFrom(){ //return TRUE if not empty?
		if (isEmpty()){
			System.out.println("COLLECT SAYS: empty");
			return false;
		}
		return true;
	}
	
	/*Given a card to be played to the top of this card stack, 
	 * either make the legal play and return true, or ignore the illegal play and return false.
	 */
	public boolean playTo(Card card){ //implement
		return true;
	}
	
	/*Given a stack from which the top card is to be played to the top of this card stack, 
	*either make the legal play and return true, or ignore the illegal play and return false.*/
	public boolean playTo(CardCollect cards){
		return true;
	}
	
	
	public Card[] toArray(){
		return toArray();   
	}
	
	public static void main(String[] args) {
		Deck deck = new Deck();
		Card card = deck.drawFromDeck();
		CardCollect cc = new CardCollect();
		cc.pushCard(card);
		System.out.println(cc.peekTopCard()); //print top card.
		System.out.println(cc.playFrom());
		System.out.println("Is the card red? " + cc.peekTopCard().isRed());
		
	}

}
