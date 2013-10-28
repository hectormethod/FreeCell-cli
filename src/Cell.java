
public class Cell extends CardCollect {
	//private CardCollect cell;
	
	public Cell(){
		//this.cell = new CardCollect();
	}
	
	/*can only play on empty cell*/
	public boolean playTo(Card card){
		if(!super.isEmpty()){
			return false;
		}
		return true;
	}
	
	public boolean playTo(CardCollect cards){
		if(!super.isEmpty()){
			return false;
		}
		return true;
	}

	public boolean playFrom(){
		if (!super.isEmpty()){ //has 1 card, can play is true
			return true;
		}
		
		return false; //has no card, can play is false
	}
	
	public static void main(String[] args) {
		Cell cell = new Cell();
		Card card1 = new Card(8,3);
		Card card2 = new Card(7,1);
		//cell.add(card1);
		if(cell.playTo(card1)){
			cell.add(card1);
			System.out.println("Added card1");
	} else {System.out.println("returned false");}

	}
}