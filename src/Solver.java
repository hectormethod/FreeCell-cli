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
		boolean gameover = false;
		System.out.println(b);
		int source=0;
		int dest=0;
		for (int k = 0; k < 500; k++){ //brute force it a lot of times until Game Over
			for (source = 0; source < 16; source++) {  //try all 16 columns as destination
				for(dest = 0; dest <16; dest++){ // try all 16 columns as source
					if (b.getColumn(source).isEmpty()){continue;} //don't try move if source is empty
					if (source == dest) {continue;}   //don't try move if source and destination are same;
					/*
					 * Reached special case where only cards in Cells are left (not on foundations).
					 * If source is a Cell AND Cascades are empty, then Foundations are only valid destinations.
					 * Loop through foundations as destination to finish off.
					 */
					if (b.isMoveLegal(source, dest) && source < 4 && b.isCascadesEmpty()){
						for (int i = 4; i < 8; i++) {
							if(b.isMoveLegal(source,i)){
								b = new GameBoard(source, i, b);
								System.out.println(b);
							}
						}
					}
					if (b.isMoveLegal(source, dest)){
						b = new GameBoard(source, dest, b);
						System.out.println(b);
						break;
					} else {System.out.println(source + ", "+ dest + " is Invalid Move");}
			
			}	
				if(b.isGameOver()){
				System.out.println(b);
				System.out.println("Game Over");
				gameover = true;
				break;
				}	
			}
		if(gameover){
			System.out.println("Thanks for playing.");
			break;
		}
		}
	}
	
	public static GameBoard backTrackSolve(int source, int dest, GameBoard b){
		return b;
	}
		
	
	public static void main(String[] args) {
		Deck deck = new Deck();
		GameBoard testboard = new GameBoard(deck); //test deck
		GameBoard boardfull = new GameBoard(); //real random deck
		bruteForceSolve(testboard);

	}

}
