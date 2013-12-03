
import java.util.Random;
import java.util.ArrayList;

public class Deck {
	private ArrayList<Card> deckcards;
	

	public Deck() //create new deck by iterating over rank, then suit)
	{
		deckcards = new ArrayList<Card>();
		for (int rank=0; rank<=12; rank++)
		{
			for (int suit=0; suit<=3; suit++)
			 {
			   Card c = new Card(rank,suit);
			   deckcards.add( c );
			 }
		}
	}
	
	//constructor to create a custom deck arrangement using given 2D array of cards
	public Deck(int [][] ranksuit){
		ArrayList<Card> customdeck = new ArrayList<Card>();
		for (int i = 0; i < ranksuit[0].length; i++) {
			for (int j = 0; j < ranksuit.length; j++) {
				Card c = new Card (i,j);
				customdeck.add(c);
			}
		}
		this.deckcards = customdeck;
	}
	
	
	public Card drawFromDeck()
	{
		Random random = new Random();
		int index= random.nextInt(deckcards.size());
		return deckcards.remove(index);
	}
	
	public Card drawFromDeck(int i){
		return deckcards.get(i);
	}

	 public int getTotalCards()
	{
		return deckcards.size();
	}


	public static void main(String[] args)
	{
		int[][] suitrank = {{0,1,2,3,4,5,6,7,8,9,10,11,12},{0,1,2,3,4,5,6,7,8,9,10,11,12},
							{0,1,2,3,4,5,6,7,8,9,10,11,12},{0,1,2,3,4,5,6,7,8,9,10,11,12}};
		Deck deck = new Deck(suitrank);

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
