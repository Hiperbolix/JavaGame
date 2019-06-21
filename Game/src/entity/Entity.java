package entity;

import java.awt.*;
import sprites.*;
import Game.Window;


public abstract class Entity {
	//position
	protected double x;
	protected double y;
	protected double dx;
	protected double dy;
	protected double xdest;
	protected double ydest;
	protected double xtemp;
	protected double ytemp;
	
	protected int width;
	protected int height;
	
	// collision
	protected int cwidth;
	protected int cheight;
	protected int currCol;
	protected int currRow;
	protected boolean topLeft;
	protected boolean topRight;
	protected boolean bottomLeft;
	protected boolean bottomRight;
	
	
	//movement
	protected double acceleration;
	protected double deceleration;
	protected double vX;
	protected double vMax;
	protected double currentG;
	protected double maxFall;
	// movement logic
	protected boolean facingright;
	protected boolean left;
	protected boolean right;
	protected boolean up;
	protected boolean down;
	protected boolean jumping;
	protected boolean falling;
	//sprite
	protected SpriteMap spriteMap;
	protected int spriteSize;
	protected double xmap;
	protected double ymap;
	
	
	//animation
	protected int currentAction;
	protected Animation animation;
	
	
	
	public Entity(SpriteMap sm) {
		spriteMap = sm;
		spriteSize = sm.getTileSize(); 
	}
	
	public boolean intersects(Entity en) {
		Rectangle r1 = getRectangle();
		Rectangle r2 = en.getRectangle();
		return r1.intersects(r2);
	}
	
	public Rectangle getRectangle() {
		return new Rectangle((int)x - cwidth,(int)y - cheight,cwidth,cheight);
	}
	
	public void calculateCorners(double x, double y) {
		
		int leftTile = (int)(x - cwidth / 2) / spriteSize;
		int rightTile = (int)(x + cwidth / 2 - 1) / spriteSize;
		int topTile = (int)(y - cheight / 2) / spriteSize;
		int bottomTile = (int)(y + cheight / 2 - 1) / spriteSize;
		
		int tl = spriteMap.getType(topTile, leftTile);
		int tr = spriteMap.getType(topTile, rightTile);
		int bl = spriteMap.getType(bottomTile, leftTile);
		int br = spriteMap.getType(bottomTile, rightTile);
		
		topLeft = tl == Sprite.BLOCKED;
		topRight = tr == Sprite.BLOCKED;
		bottomLeft = bl == Sprite.BLOCKED;
		bottomRight = br == Sprite.BLOCKED;
		
	}
	
	public void checkTileMapCollision() {
		
		currCol = (int)x / spriteSize;
		currRow = (int)y / spriteSize;
		
		xdest = x + dx;
		ydest = y + dy;
		
		xtemp = x;
		ytemp = y;
		
		calculateCorners(x, ydest);
		if(dy < 0) {
			if(topLeft || topRight) {
				dy = 0;
				ytemp = currRow * spriteSize + cheight / 2;
			}
			else {
				ytemp += dy;
			}
		}
		if(dy > 0) {
			if(bottomLeft || bottomRight) {
				dy = 0;
				falling = false;
				ytemp = (currRow + 1) * spriteSize - cheight / 2;
			}
			else {
				ytemp += dy;
			}
		}
		
		calculateCorners(xdest, y);
		if(dx < 0) {
			if(topLeft || bottomLeft) {
				dx = 0;
				xtemp = currCol * spriteSize + cwidth / 2;
			}
			else {
				xtemp += dx;
			}
		}
		if(dx > 0) {
			if(topRight || bottomRight) {
				dx = 0;
				xtemp = (currCol + 1) * spriteSize - cwidth / 2;
			}
			else {
				xtemp += dx;
			}
		}
		
		if(!falling) {
			calculateCorners(x, ydest + 1);
			if(!bottomLeft && !bottomRight) {
				falling = true;
			}
		}
		
	}
	
	public int getx() { return (int)x; }
	public int gety() { return (int)y; }
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	public int getCWidth() { return cwidth; }
	public int getCHeight() { return cheight; }
	
	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public void setVector(double dx, double dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	public void setMapPosition() {
		xmap = spriteMap.getx();
		ymap = spriteMap.gety();
	}
	

	public void setLeft(boolean b) { left = b; }
	public void setRight(boolean b) { right = b; }
	public void setUp(boolean b) { up = b; }
	public void setDown(boolean b) { down = b; }
	public void setJumping(boolean b) { jumping = b; }
	
	public boolean notOnScreen() {
		return x + xmap + width < 0 ||
			x + xmap - width > Window.WIDTH ||
			y + ymap + height < 0 ||
			y + ymap - height > Window.HEIGHT;
	}
	// animacja
	public void draw(java.awt.Graphics2D g) {
		g.drawImage(
			animation.getImage(),
			(int)(x + xmap - width / 2),
			(int)(y + ymap - height / 2),
			null
		);
		/*
		System.out.println("x= "+ (x + xmap - width / 2));
		System.out.println("y= "+ (y + ymap - height / 2));
		

		System.out.println("xmap= "+ (xmap));
		System.out.println("ymap= "+ (ymap));
		*/
	}
	

}

