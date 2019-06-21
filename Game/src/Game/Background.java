package Game;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;

import java.awt.*;

import java.awt.image.*;
import javax.imageio.ImageIO;

import Game.Window;


public class Background {
	
private BufferedImage image;
	
	private double x;
	private double y;
	private double dx;
	private double dy;
	
	private double scale;

	
	public Background(String s) {
		
			try {
				image = ImageIO.read(getClass().getResourceAsStream(s));
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	
	
	public void draw(Graphics2D g) {

		g.drawImage(image, (int)x, (int)y, null);
		if(x < 0) {
			g.drawImage(
				image,
				(int)x + Window.WIDTH,
				(int)y,
				null
			);
		}
		if(x > 0) {
			g.drawImage(
				image,
				(int)x - Window.WIDTH,
				(int)y,
				null
			);
		}
		
	}
	
	
	public void setPosition(double x, double y) {
		this.x = (x * scale) % Window.WIDTH;
		this.y = (y * scale) % Window.HEIGHT;
	}
	
	public void setVector(double dx, double dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	public void update() {
		x += dx;
		y += dy;
	}

}
