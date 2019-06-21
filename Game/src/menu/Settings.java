package menu;

import java.awt.*;
import java.awt.event.*;

import Game.*;
import levels.Level;
import levels.LevelManager;

public class Settings extends Level{
	
	private Background bg;

	private Color titleColor;
	private Font titleFont;
	private Font menuFont;
	
	private Font font;
	
	private int currentChoice = 0;
	private String[] options= {"Język", "Dzwięk", "Wróć"};
	
	private String choice = "Wybierz język:";
	private String[] languages= {"1-Polski", "2-English", "3-Русский"};
	private String[] voice= {"Włączyć", "Wyłączyć"};

	
	public Settings (LevelManager lm) {
		this.lm = lm;

		try {
			bg = new Background("/menubg1.jpg");
			
			titleColor = new Color(128, 0, 128);
			titleFont = new Font("Utopia", Font.PLAIN, 42);
			menuFont = new Font("Utopia", Font.PLAIN, 26);
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
				g.drawString(options[i], 120, 185 + i * 25);	
			}
		
		 for(int i = 0; i < languages.length; i++) {
			 if(0 == currentChoice) {
				 g.setColor(Color.BLUE);
				 g.drawString(choice, 200, 70);
				 
				 g.setColor(Color.BLACK);
				 g.drawString(languages[i], 200, 100 + i * 20);
			}
		}
		 
		 for(int i = 0; i < voice.length; i++) {		
			 if(1 == currentChoice) {
				g.drawString(voice[i], 200, 145 + i * 20);
			}
		}

	}

	public void keyPressed(int k) {
		if(k == KeyEvent.VK_ENTER){	
					
			if(currentChoice == 1) {
				System.out.println("choice voice");
				
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
	
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}



}

