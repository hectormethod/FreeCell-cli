
import java.util.Random;
import java.util.ArrayList;

public class Deck {
	private ArrayList<Card> cards;
	

	public Deck() //create new deck by iterating over rank, then suit)
	{
		cards = new ArrayList<Card>();
		for (int rank=0; rank<=12; rank++)
		{
			for (int suit=0; suit<=3; suit++)
			 {
			   Card c = new Card(rank,suit);
			   cards.add( c );
			 }
		}
	}
	

	public Card drawFromDeck()
	{
		Random random = new Random();
		int index= random.nextInt(cards.size());
		return cards.remove(index);
	}
	
	public Card drawFromDeck(int i){
		return cards.get(i);
	}

	 public int getTotalCards()
	{
		return cards.size();
	}


	public static void main(String[] args)
	{
		Deck deck = new Deck();
		Card C;

		System.out.println( deck.getTotalCards() + " total cards" );
	  for (int i = 0; i < deck.getTotalCards(); i++) {
		  System.out.println( deck.drawFromDeck(i).toString() );
	}
//	   while (deck.getTotalCards()!= 0 )
//	   {
//		   C = deck.drawFromDeck();
//		   System.out.println( C.toString() );
//	   }
	}
	}
