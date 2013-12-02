import java.util.ArrayList;
import java.util.TreeMap;


public class Solver {
	
	public Solver(){
		
	}
	
	//constructor for creating a board with a certain deck (for debugging mostly)
	public ArrayList<CardCollect> createTestBoard (Deck testdeck){
		ArrayList <CardCollect> board = new ArrayList<CardCollect>();
		for(int i = 0; i < 4; i++ ){ //add cells in 0-3
			Cell cell = new Cell();
			board.add(cell);
			}
		for(int i = 0; i < 4; i++ ){ //add foundations in 4-7
			Foundation foundation = new Foundation();
			board.add(foundation);
			}
		
		for(int i = 0; i < 8; i++ ){ //add cascades in 8-15
			Cascade cascade = new Cascade();
			board.add(cascade);
			}
		//insert cards from test Deck into foundations up through Queen rank
				int k =0;
				for (int i = 0; i < 12; i++) { //insert 50 cards in foundation 4-7
					
					for (int j = 4; j <= 7; j++) {
							board.get(j).pushCard(testdeck.drawFromDeck(k));
							k++;
							}
						}
				//insert remaining King rank onto Cascades 8-12
				for (int m = 8; m < 12; m++){
					board.get(m).pushCard(testdeck.drawFromDeck(k));
					k++;
				}
			return board;
			}
	
	public void bruteForceSolve(GameBoard b){
		b = createTestBoard();
	
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
