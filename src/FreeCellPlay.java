import java.util.*;


public class FreeCellPlay {
	private  Deck deck;
	
	public FreeCellPlay() {

	}
	
	public static boolean playGame(GameBoard board){
		boolean play = true;
		String str;
		Scanner line = new Scanner(System.in);
		int source, destination;
		//Scanner parse = new Scanner(input);
		do { 
			System.out.println(board.toString());
			 System.out.println("Enter Source and Destination column, or '0' to QUIT ");
			 str = line.nextLine();
			 String [] moves= str.split(" ");
             source = Integer.parseInt(moves[0]);
            if (source == 0) { 
              System.out.println("Q U I T  G A M E" );
          	  break;
          	}
            
            destination = Integer.parseInt(moves[1]);
             System.out.println("Source is:" + source + "\nDesintation is:" + destination);
             if(! board.isMoveLegal(source, destination)){
            	 System.out.println("\n*** ILLEGAL MOVE. Please try again***\n");
            	 return play;}
             board = new GameBoard(source, destination, board);
		} while (source != 0);
		play = false;
		return play;
	}

	public static void main(String[] args) {
		GameBoard board = new GameBoard();
		while(playGame(board)){
			playGame(board);
		} System.exit(0);
	}

}
