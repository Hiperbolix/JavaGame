package Game;

import javax.swing.JFrame;

public class Game {
	
	public static void main(String[] args) {
		
		JFrame window = new JFrame("...");
		window.setContentPane(new Window());
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setResizable(false);
		//window.setLocationRelativeTo(null);
		window.pack();
		window.setVisible(true);
	
	}
}
	