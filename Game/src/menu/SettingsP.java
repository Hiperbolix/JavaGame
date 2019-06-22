package menu;

import java.awt.*;
import java.awt.event.*;

import Game.*;
import levels.Level;
import levels.LevelManager;

public class SettingsP extends Level{
	
	private Background bg;

	private Color titleColor;
	private Font titleFont;
	private Font menuFont;
	
	private Font font;
	
	private int currentChoice = 0;
	private String[] options= {"Język", "Dźwięk", "Wróć"};
	
	private String choice = "Wybierz język:";
	private String[] languages= {"1-Polski", "2-English", "3-Русский"};
	

	
	public SettingsP (LevelManager lm) {
		this.lm = lm;

		try {
			bg = new Background("/Backgrounds/menubg1.jpg");
			
			titleColor = new Color(128, 0, 128);
			titleFont = new Font("Utopia", Font.PLAIN, 72);
			menuFont = new Font("Utopia", Font.PLAIN, 50);
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
		 
		 g.setColor(Color.cyan);
		 g.setFont(menuFont);
		 
		 
		 //menu
		 g.setFont(font);
		 for(int i = 0; i < options.length; i++) {
				if(i == currentChoice) {
					g.setFont(font);
					g.setColor(Color.RED);
				}
				else {
					g.setColor(Color.BLACK);
				}
				g.drawString(options[i], 180, 350 + i * 35);	
			}
		
		 for(int i = 0; i < languages.length; i++) {
			 if(0 == currentChoice) {
				 g.setColor(Color.BLUE);
				 g.drawString(choice, 320, 220);
				 
				 g.setColor(Color.BLACK);
				 g.drawString(languages[i], 320, 260 + i * 30);
			}
		}
		 

	}

	public void keyPressed(int k) {
		if(k == KeyEvent.VK_ENTER){	
					
			if(currentChoice == 1) {
				
				
			}
			if(currentChoice == 2) {
				lm.setState(LevelManager.MENUID);
			}			
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
		
		if(k == KeyEvent.VK_1) {
			lm.setState(LevelManager.SETTINGS_P);
		}
		
		if(k == KeyEvent.VK_2) {
			lm.setState(LevelManager.SETTINGS_E);
		}
		
		if(k == KeyEvent.VK_3) {
			lm.setState(LevelManager.SETTINGS_R);
		}
		
	}

	public void keyReleased(int k) {}
	
	public void update() {}
}


