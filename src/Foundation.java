
public class Foundation extends CardCollect {
	private CardCollect foundation; 
	
	public Foundation(){
		this.foundation = new CardCollect();
	}
	
	/*cannot play from Foundations.*/
	public boolean canPlayFrom(){
		return false;
	}
	
	public boolean playTo(Card card){
		/*Case1: foundation is empty and card rank is Ace OR
		 *Case2: foundation is not empty and card played is same suit as top card and rank is +1 of top card*/
		if ((foundation.isEmpty() && card.rank == 0) || 
		(!foundation.isEmpty() && foundation.peek().suit == card.suit && (foundation.peek().rank + 1) == card.rank)){
			return true;
		}
		return false; 
	}
	
	public static void main(String[] args) {
		
	}

}
