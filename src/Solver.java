import java.util.ArrayList;



public class Solver {
	private ArrayList<GameBoard> path = new ArrayList<GameBoard>();
	
	public Solver(){
		
	}
	
	//** implement the brute force first!
	public boolean isBruteSolution(GameBoard b){
		return true;
	}
	
	
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
