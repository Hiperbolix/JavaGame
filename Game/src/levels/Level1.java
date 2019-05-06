package levels;

import java.awt.*;
import java.awt.event.KeyEvent;

import Game.BackgroundMove;


public class Level1 extends Level {
	
	private BackgroundMove back;
	
	public Level1(LevelManager lm) {
		this.lm = lm;
		start();
	}

	@Override
	public void start() {
			try {
				back = new BackgroundMove("Image/tile1.png",20);
				
				back.setPosition(0);	
				back.setVector(-2);
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	@Override
	public void update() {
			back.update();
			
		}
	
	@Override
	public void draw(Graphics2D g) {
			back.draw(g);
			
		}
	
	@Override
	public void keyPressed(int k) {
			if(k == KeyEvent.VK_ENTER) lm.setState(LevelManager.MENU);
		}
	
	@Override
	public void keyReleased(int k) {
			// TODO Auto-generated method stub
			
		}

}
