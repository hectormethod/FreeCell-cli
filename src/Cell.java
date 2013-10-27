
public class Cell extends CardCollect {
	private CardCollect cell;
	
	public Cell(){
		this.cell = new CardCollect();
	}
	
	/*can only play on empty cell*/
	public boolean playTo(Card card){
		if(cell.isEmpty()){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		

	}

}
