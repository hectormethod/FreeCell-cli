import java.io.*;
import java.util.*;


public class FreeCellPlay {
	private  Deck deck;
	
	public FreeCellPlay() {

	}
	public static boolean isGameOver(GameBoard b){
		boolean test = true;
		for (int i = 8; i <= 15; i++){       //are cascades 8-15 empty? game over
			if(! b.getColumn(i).isEmpty()){
				test =  false;
			}
		}
		return test;
	}
	
	public static boolean playGame(GameBoard board){
		boolean play = true;
		String str;
		Scanner line = new Scanner(System.in);
		int source, destination;
		//Scanner parse = new Scanner(input);
			try{
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
	            	 System.out.println("\n** ILLEGAL MOVE. Please try again **\n");
	            	 return play;}
	             if(isGameOver(board)){
	            	 System.out.println("\n *** Congratulations. You win the game! ***");
	             }
	             board = new GameBoard(source, destination, board);
			} while (source != 0);
				play = false;
				return play;
			} catch(ArrayIndexOutOfBoundsException e) {
				      //inform user that they have not entered two integers for source and destination
				      System.out.println("\nOOPS! need source and destination for move. Try again!\n");
				      return play;
			} 
	         
	}

	public static void main(String[] args) {
		if(args.length > 0){
			try {
		        String filename = args[0].toString();
		        Scanner filescanner = new Scanner (new File(filename));
		    } catch (FileNotFoundException e) {
		        System.err.println("Argument" + "is not a filename");
		        System.exit(1);
		    }
		}
		GameBoard board = new GameBoard();
		while(playGame(board)){
			playGame(board);
		} System.exit(0);
	}
}
