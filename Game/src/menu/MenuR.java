package menu;

import java.awt.*;
import java.awt.event.*;

import Game.*;
import levels.*;


public class MenuR extends Level {
	private Background bg;

	private Color titleColor;
	private Font titleFont;
	
	private Font font;
	
	private int currentChoice = 0;
	private String[] options= {"Новая Игра", "Продолжить", "Опции", "Выход"};
	

	public MenuR (LevelManager lm) {
		this.lm = lm;

		try {
			bg = new Background("/Backgrounds/menubg1.jpg");
			
			titleColor = new Color(128, 0, 128);
			titleFont = new Font("Utopia", Font.PLAIN, 72);
			font = new Font("FreeSans", Font.PLAIN, 40);
			
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
		 g.drawString("Ucieczka z Javy", 50, 70);
		 
		 //menu
		 g.setFont(font);
		 for(int i = 0; i < options.length; i++) {
				if(i == currentChoice) {
					g.setColor(Color.RED);
				}
				else {
					g.setColor(Color.BLACK);
				}
				g.drawString(options[i], 180, 350 + i * 35);
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
			lm.setState(LevelManager.LVL1ID);

		}
		if(currentChoice == 1) {
			lm.setLvl(LevelManager.DEBUGID);
		}
		if(currentChoice == 2) {
			lm.setState(LevelManager.SETTINGS_R);
		}
		if(currentChoice == 3) {
			System.exit(0);
		}

	}

	public void update() {}


}
