package sprites;


import java.awt.*;
import java.awt.image.*;

import java.io.*;
import javax.imageio.ImageIO;

import game.Window;
import sprites.Sprite;

public class SpriteMap {
	
	// position
	private double x;
	private double y;
	
	// bounds
	private int xmin;
	private int ymin;
	private int xmax;
	private int ymax;
	
	private double tween;
	
	// map
	private int[][] map;
	private int spriteSize;
	private int numRows;
	private int numCols;
	private int width;
	private int height;
	
	// tileset
	private BufferedImage tileset;
	private int numTilesAcross;
	private Sprite[][] sprites;
	
	// drawing
	private int rowOffset;
	private int colOffset;
	private int numRowsToDraw;
	private int numColsToDraw;
	
	public SpriteMap(int tileSize) {
		this.spriteSize = tileSize;
		numRowsToDraw = Window.HEIGHT_P / tileSize + 2;
		numColsToDraw = Window.WIDTH_P / tileSize + 2;
	
	}
public void loadTiles(String s) {
		
		try {

			tileset = ImageIO.read(
				getClass().getResourceAsStream(s)
			);
			numTilesAcross = tileset.getWidth() / spriteSize;
			sprites = new Sprite[2][numTilesAcross];
			
			BufferedImage subimage;
			for(int col = 0; col < numTilesAcross; col++) {
				subimage = tileset.getSubimage(col * spriteSize,0,spriteSize,spriteSize);
				sprites[0][col] = new Sprite(subimage, Sprite.NORMAL);
				
				subimage = tileset.getSubimage(col * spriteSize,spriteSize,spriteSize,spriteSize);
				sprites[1][col] = new Sprite(subimage, Sprite.BLOCKED);
			}
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadMap(String s) {
		
		try {
			
			InputStream in = getClass().getResourceAsStream(s);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			numCols = Integer.parseInt(br.readLine());
			numRows = Integer.parseInt(br.readLine());
			map = new int[numRows][numCols];
			width = numCols * spriteSize;
			height = numRows * spriteSize;
			
			xmin = Window.WIDTH_P - width;
			xmax = 0;
			ymin = Window.HEIGHT_P - height;
			ymax = 0;
			
			String delims = "\\s+";
			for(int row = 0; row < numRows; row++) {
				String line = br.readLine();
				String[] tokens = line.split(delims);
				for(int col = 0; col < numCols; col++) {
					map[row][col] = Integer.parseInt(tokens[col]);
				}
			}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	public int getTileSize() { return spriteSize; }
	public int getx() { return (int)x; }
	public int gety() { return (int)y; }
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	
	public int getType(int row, int col) {
		int rc = map[row][col];
		
		if (rc < 2) return Sprite.NORMAL;
		else return Sprite.BLOCKED;
	}
	
	public void setTween(double d) { tween = d; }
	
	public void setPosition(double x, double y) {
		
		this.x += (x - this.x) * tween;
		this.y += (y - this.y) * tween;
		
		fixBounds();
		
		colOffset = (int)-this.x / spriteSize;
		rowOffset = (int)-this.y / spriteSize;
		
	}
	
	private void fixBounds() {
		if(x < xmin) x = xmin;
		if(y < ymin) y = ymin;
		if(x > xmax) x = xmax;
		if(y > ymax) y = ymax;
	}
	
	public void draw(Graphics2D g) {

		for(int row = rowOffset;row < rowOffset + numRowsToDraw;row++) {
				
			if(row >= numRows) break;
			
			for(int col = colOffset;col < colOffset + numColsToDraw;col++) {
				
				if(col >= numCols) break;
				
				if(map[row][col] == 0) continue;
				
				int rc = map[row][col];
				int r = rc / numTilesAcross;
				int c = rc % numTilesAcross;
				
				g.drawImage(sprites[r][c].getImage(),(int)x + col * spriteSize,(int)y + row * spriteSize,null);
				
			}
		}	
	}

}