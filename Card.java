import java.util.ArrayList;


public class Card
{
	public int suit, rank;
	public static Card[] allCards;
	public static boolean [] suitIsRed = {true, true, false, false};
	public static String[] suitLabel = { "h", "d", "S", "C" };
	public static String[] rankLabel = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };


	public Card(int rank, int suit) // TODO configure to switch rank, suit - need to change Deck loop
	{
		this.suit = suit;
		this.rank = rank;
	}

	public Card getRandomCard(){
		Card card = new Card(StdRandom.uniform(12),StdRandom.uniform(3));
		return card;
	}
	public String toString()
	{
		  return rankLabel[rank] + suitLabel[suit];
	}
	
	public boolean isRed(){
		if (suit == 0 || suit == 1 ){
			return true;
		}
		return false;
	}
	public int getRank() {
		 return rank;
	}

	public int getSuit() {
		return suit;
	}

}
