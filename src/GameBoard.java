


import java.util.*;

/*Structure of Board:
 * 	cell0  -- 0-3 are cells
*	cell1 
*	cell2 
*	cell3 
 *	found4 -- 4-7 are foundations
* 	found5
*	found6
*	found7
*	casc8 -- 8-11 are 6 count cascades
*	casc9
*	casc10
*	casc11
*	casc12 -- 12-15 are 7 count cascades
*	casc13
*	casc14
*	casc15
 */
public class GameBoard {
	private ArrayList<CardCollect> board; 
	private Deck deck = new Deck();
	
	//constructor for new Gameboard
	public GameBoard(){ //make new GameBoard
		this.board = new ArrayList<CardCollect>();
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
		
		//insert cards from Deck into new board
		for (int i = 0; i < 6; i++) { //insert 6 cards in cascades 8-11
			for (int j = 8; j <= 11; j++) {
					board.get(j).pushCard(deck.drawFromDeck());
					}
				}
	
		for (int i = 0; i < 7; i++) { //insert 7 cards in cascades 12-15
			for (int j = 12; j <= 15; j++) {
					board.get(j).pushCard(deck.drawFromDeck());
				}
			}
		}
	
	//constructor for creating a board from given board and given moves
	public GameBoard (int source, int destination, GameBoard gboard){
		this.board = gboard.board;
		Card card = new Card(0,0);
		card = this.board.get(source).popTopCard();
		this.board.get(destination).pushCard(card);
	}
	
	//constructor for creating a board with a certain deck (for debugging mostly)
	public GameBoard (Deck testdeck){
		this.board = new ArrayList<CardCollect>();
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
	
	}
	
	//constructor to create GameBoard from given ArrayList of cards
	public GameBoard (ArrayList<CardCollect> a){
		this.board = a;
	}
	
	public CardCollect getColumn(int i){
		return this.board.get(i);
	}
	
	public void moveCard(int s, int d){
		this.board.get(d).pushCard(this.board.get(s).popTopCard());
	}
	
	public  boolean isGameOver(){
		boolean test = false;
		for (int i = 8; i <= 15; i++){       //are cascade full? T: game over
			if(board.get(i).size() == 13){  
				test = true;
			}
		}
		return test;
	}
	
	public boolean isMoveLegal (int source, int destination){
		//CardCollect s = this.board.get(source);
		//CardCollect d = this.board.get(destination);
		if(board.get(source).playFrom() && board.get(destination).playTo(board.get(source).peekTopCard())){
			return true;
			}
		return false;
		}
	
	public boolean isBoardWon(GameBoard b){
		boolean test = true;
		for (int i = 8; i <= 15; i++){       //are cascades 8-15 empty? game over
			if(! b.getColumn(i).isEmpty()){
				test =  false;
			}
		}
		return test;
	}
	
	public String toString(){
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < board.size(); i++) {
		if(i < 4){sb.append(i + " " );}
		if(i >= 4 && i < 8) {sb.append(i + " ");}
		if(i >= 8 && i < 16) {sb.append(i + " ");}
		sb.append(board.get(i).toString());
		sb.append("\n");
		}
	String str = sb.toString();
	return str;
	}
	
	public static void main(String[] args) {
		int[][] ranksuit = {{0,1,2,3,4,5,6,7,8,9,10,11,12},{0,1,2,3,4,5,6,7,8,9,10,11,12},
				{0,1,2,3,4,5,6,7,8,9,10,11,12},{0,1,2,3,4,5,6,7,8,9,10,11,12}};
		Deck ordered = new Deck(ranksuit);
		Deck testdeck = new Deck();
		GameBoard b = new GameBoard(ordered);
		
		System.out.println(b);
//		b.moveCard(10, 3);
//		System.out.println(b);
//		if(b.isMoveLegal(11, 3)){
//			System.out.println("should be true");
//			b.moveCard(11, 3);
//			System.out.println(b);
//		}
//		System.out.println(b.isMoveLegal(11,3));
	}
	

}
