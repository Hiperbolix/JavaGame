package entity;

import java.awt.*;
import java.awt.image.*;
import java.util.*;

import javax.imageio.*;

import sprites.*;



public class Player extends Entity {

	// player stuff
		private int health;
		private int maxHealth;
		private boolean dead;
		
		
		private static final int IDLE = 0;
		private static final int WALKING = 1;
		private static final int JUMPING = 2;
		private static final int FALLING = 3;
		
		BufferedImage cat1, cat2, cat3;
		BufferedImage[] bi;
		

		private ArrayList<BufferedImage[]> sprites;
		
		
		public Player(SpriteMap sm) {
			
			super(sm);
			
			width = 60;
			height = 180;
			cwidth = 70;
			cheight = 70;
			
			acceleration=0.5;
			//vX = 0.5;
			vMax= 2.5;
			deceleration = 0.4;
			currentG = 0.1;
			maxFall = 4.0;
			JumpStart=-4;
			
			//facingRight = true;
			
			health = maxHealth = 5;
			
			// load sprites
			try {
				
				cat1 = ImageIO.read(getClass().getResourceAsStream("/Player/catpraw.png"));
				cat2 = ImageIO.read(getClass().getResourceAsStream("/Player/catlew.png"));
				cat3 = ImageIO.read(getClass().getResourceAsStream("/Player/catsie.png"));
				
				bi =new BufferedImage[2];
				bi[0]=cat1;
				bi[1]=cat2;
				
				
				sprites = new ArrayList<BufferedImage[]>();
				
				sprites.add(bi);
				
					
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			animation = new Animation();
			currentAction = IDLE;
			animation.setFrames(sprites.get(IDLE));
			animation.setDelay(400);
			
		}
		
		//public int getHealth() { return health; }
		//public int getMaxHealth() { return maxHealth; }
		
		
		private void getNextPosition() {
			
			// x movement
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
			// y movement
			/*
			if(flying)
			{
				dy=flySpeed;
				falling = true;
			}
			else {
				if(jumping&& !falling)
					{
						System.out.println("Skok");
						dy=JumpStart;
						falling = true;
					}
				}
			*/
			if(jumping&& !falling)
			{
				System.out.println("Skok");
				dy=JumpStart;
				falling = true;
			}
			if(falling)
			{
				dy+=currentG;
				if(dy>0) jumping=false;
				if(dy>maxFall) dy=maxFall;
			}
		}
		
		public void update() {
			
			// update position
			getNextPosition();
			checkTileMapCollision();
			setPosition(xtemp, ytemp);
			
			animation.setFrames(sprites.get(0));
			animation.setDelay(400);
			//width = 30;
			
			animation.update();
		}
		
		public void draw(Graphics2D g) {
			
			setMapPosition();
			
			//super.draw(g);
			if(dx<0) g.drawImage(cat2, (int)( x + xmap - width / 2), (int)(y + ymap - height / 2), null);
			if(dx==0) g.drawImage(cat3, (int)( x + xmap - width / 2), (int)(y + ymap - height / 2), null);
			if(dx>0) g.drawImage(cat1, (int)( x + xmap - width / 2), (int)(y + ymap - height / 2), null);
			
		}
		
}


