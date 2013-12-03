
import java.util.Random;


public class Card
{
	public int suit, rank;
	public static Card[] allCards;
	public static boolean [] suitIsRed = {true, true, false, false};
	public static String[] suitLabel = { "h", "d", "S", "C" };
	public static String[] rankLabel = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };


	public Card(int rank, int suit)
	{	
		this.rank = rank;
		this.suit = suit;
	}
	
	//create a card from String reference, e.g "Ah" or "3C"
	public Card(String str){
		
//		if (str.length() != 2){
//			throw new InvalidFormatException("Not a valid card declaration--must be 2 characters");
//		}
		
		int s,r;
		r=s=0;
		String [] arr = str.split(""); //*index 0 will be [""], so skip in loop
		for (int i = 0; i < rankLabel.length; i++) {
			if (arr[1].equals(rankLabel[i])){
				r = i;
			}
		}
		for (int j = 0; j < suitLabel.length; j++) {
			if (arr[2].equals(suitLabel[j])){
				s = j;
			}
		}
		this.suit = s;
		this.rank = r;
	}
	

	public Card getRandomCard(){
		Random random = new Random();
		Card card = new Card(random.nextInt(12),random.nextInt(3));
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
	
	public static void main (String arg[]){
		String str = "Qd";
		Card card = new Card(str);
		System.out.println(card);
		
	}

}
