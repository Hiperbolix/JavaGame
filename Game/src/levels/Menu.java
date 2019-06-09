package levels;

import java.awt.*;
import java.awt.event.KeyEvent;

import sprites.Background;

public class Menu extends Level {
	private Background bg;

	private Color titleColor;
	private Font titleFont;
	
	private Font font;
	
	private int currentChoice = 0;
	private String[] options= {"Nowa Gra", "DEBUG", "Opcje", "Wyjście"};
	

	public Menu (LevelManager lm) {
		this.lm = lm;

		try {
			bg = new Background("/menubg1.jpg");
			
			titleColor = new Color(128, 0, 128);
			titleFont = new Font("FreeSans", Font.PLAIN, 42);
			
			font = new Font("FreeSans", Font.PLAIN, 24);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void start() {}
	

	public void draw(Graphics2D g) {
		//background
		bg.draw(g);
		 
		//title
		 g.setColor(titleColor);
		 g.setFont(titleFont);
		 g.drawString("...", 50, 70);
		 
		 //menu
		 g.setFont(font);
		 for(int i = 0; i < options.length; i++) {
				if(i == currentChoice) {
					g.setColor(Color.RED);
				}
				else {
					g.setColor(Color.BLACK);
				}
				g.drawString(options[i], 200, 185 + i * 20);
			}

	}

	public void keyPressed(int k) {
		if(k == KeyEvent.VK_ENTER){
			choice();
		}
		if(k == KeyEvent.VK_UP) {
			currentChoice--;
			if(currentChoice == -1) {
				currentChoice = options.length - 1;
			}
		}
		if(k == KeyEvent.VK_DOWN) {
			currentChoice++;
			if(currentChoice == options.length) {
				currentChoice = 0;
			}
		}

	}

	public void keyReleased(int k) {}
	
	private void choice()
	{
		if(currentChoice == 0) {
			lm.setLvl(LevelManager.LVL1ID);
		}
		if(currentChoice == 1) {
			lm.setLvl(LevelManager.DEBUGID);
		}
		if(currentChoice == 2) {
			System.out.println("nie wiem");
		}
		if(currentChoice == 3) {
			System.exit(0);
		}

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}


}

