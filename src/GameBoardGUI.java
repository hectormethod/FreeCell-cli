

import javax.swing.*;

public class GameBoardGUI extends GameBoard{
	
	public GameBoardGUI(){
		super();
	}
	
	private static void displayGameBoard(){
		JFrame frame = new JFrame("FreeCellBoard");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("Free Cell Game");
		frame.getContentPane().add(label);
		
		frame.pack();
		frame.setVisible(true);
		}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				displayGameBoard();
			}
		});

	}

}
