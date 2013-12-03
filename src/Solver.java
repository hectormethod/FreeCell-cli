import java.util.ArrayList;

public class Solver {
	
	public Solver(){
		
	}
	
	//constructor for creating a board with a certain deck (for debugging mostly)
	public static ArrayList<CardCollect> createTestBoard (Deck testdeck){
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
	
	
	public static void bruteForceSolve(GameBoard b){
		System.out.println(b);
		int source=0;
		int dest=0;
		for (int k = 0; k < 1000; k++){ //brute force it a lot of times until Game Over
			for (source = 0; source < 16; source++) {  //try all 16 columns as destination
				for(dest = 0; dest <16; dest++){ // try all 16 columns as source
					if (b.getColumn(source).isEmpty() && ! b.isCascadesEmpty()){continue;}
					if (source == dest) {continue;}   //don't test if source and destination are same;
					if (b.isMoveLegal(source, dest)){
						b = new GameBoard(source, dest, b);
						System.out.println(b);
						break;
					} else {System.out.println(source + ", "+ dest + " is Invalid Move");}
			
			}	
				if(b.isGameOver()){
				System.out.println(b);
				System.out.println("Game Over");
				break;
				}	
			}
		}
	}
	
	public static GameBoard backTrackSolve(int source, int dest, GameBoard b){
		return b;
	}
		
	
	public static void main(String[] args) {
		Deck deck = new Deck();
		GameBoard board = new GameBoard(deck);
		bruteForceSolve(board);

	}

}
