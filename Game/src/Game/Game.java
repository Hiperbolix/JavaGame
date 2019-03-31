package Game;

import javax.swing.JFrame;



public class Game {
	
	public static void main(String[] args) {
		
		JFrame window = new JFrame("Nie wiem");
		window.setContentPane(new Window());
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
	}
}
	