import java.util.ArrayList;



public class Solver {
	private ArrayList<GameBoard> path = new ArrayList<GameBoard>();
	
	public Solver(){
		
	}
	
	//** implement the brute force first!
	public boolean isBruteSolution(GameBoard b){
		return true;
	}
	
<<<<<<< HEAD
	public static void bruteForceSolve(GameBoard b){
		
		System.out.println(b);
		int source=0;
		int dest=0;
		//for (int k = 0; k < 1000; k++){ //brute force it a lot of times until Game Over
			for (source = 0; source < 16; source++) {  //try all 16 columns as destination
				for(dest = 0; dest <16; dest++){ // try all 16 columns as source
					if (b.getColumn(source).isEmpty()){continue;}
					if (source == dest) {continue;}   //don't test if source and destination are same;
					if (b.isMoveLegal(source, dest)){
						b = new GameBoard(source, dest, b);
						System.out.println(b);
						break;
					} else {System.out.println(source + ", "+ dest + " is Invalid Move");}
			}		
			if(b.isGameOver()){
				System.out.println("Game Over");
				break;
				}
=======
	
	public boolean isSolution(GameBoard b){ //recursive solution
		//GameBoard board = new GameBoard(source, destination, b);
		path.add(b);
		boolean result = false;
		int i = 0;
		if (b.isBoardWon(b)){ //base case true, found winning board.
			result=true;
		}
		
		while (i < 16) {
			b = new GameBoard(i, i+1, b);
			if (isSolution(b)){
				System.out.println("Valid path found");
				result=true;
>>>>>>> 8c4791985510a166290736a003a008ab4c3404fe
			}
			System.out.println("Invalid path removed");
			path.remove(b);
			return result;
		}

		return result;
	}
	
	public static void main(String[] args) {
		Deck deck = new Deck();
		GameBoard b = new GameBoard(deck);
		Solver solution = new Solver();
		System.out.println(b);
		System.out.println(solution.isSolution(b));
	}

}
