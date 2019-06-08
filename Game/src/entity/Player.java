package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;

import sprites.SpriteMap;


public class Player extends Entity {

	// player stuff
		private int health;
		private int maxHealth;
		private boolean dead;
		
		
		private static final int IDLE = 0;
		private static final int WALKING = 1;
		private static final int JUMPING = 2;
		private static final int FALLING = 3;
		

		private ArrayList<BufferedImage[]> sprites;
		
		public Player(SpriteMap sm) {
			
			super(sm);
			
			width = 60;
			height = 80;
			cwidth = 60;
			cheight = 60;
			
			acceleration=0.8;
			//vX = 0.5;
			vMax= 2.5;
			deceleration = 0.4;
			currentG = 0.1;
			maxFall = 4.0;
			
			//facingRight = true;
			
			health = maxHealth = 5;
			
			// load sprites
			try {
				
				BufferedImage spritesheet = ImageIO.read(
					getClass().getResourceAsStream(
						"/Sprites/player.gif"
					)
				);
				BufferedImage[] bi =new BufferedImage[1];
				bi[0]=spritesheet;
				
				sprites = new ArrayList<BufferedImage[]>();
				
				sprites.add(bi);
					
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			animation = new Animation();
			currentAction = IDLE;
			animation.setFrames(sprites.get(0));
			animation.setDelay(400);
			
		}
		
		public int getHealth() { return health; }
		public int getMaxHealth() { return maxHealth; }
		
		
		private void getNextPosition() {
			
			// movement
			if(left) {
				dx -= acceleration;
				if(dx < -vMax) {
					dx = -acceleration;
				}
			}
			else if(right) {
				dx += acceleration;
				if(dx > vMax) {
					dx = acceleration;
				}
			}
			else {
				if(dx > 0) {
					dx -= deceleration;
					if(dx < 0) {
						dx = 0;
					}
				}
				else if(dx < 0) {
					dx += deceleration;
					if(dx > 0) {
						dx = 0;
					}
				}
			}
		}
		
		public void update() {
			
			// update position
			getNextPosition();
			checkTileMapCollision();
			setPosition(xtemp, ytemp);
			
			animation.setFrames(sprites.get(0));
			animation.setDelay(400);
			width = 30;
			
			animation.update();
		}
		
		public void draw(Graphics2D g) {
			
			setMapPosition();
			
			super.draw(g);
			
		}
		
}
