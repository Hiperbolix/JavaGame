package game;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;


public class BackgroundMove {
	
	private BufferedImage image;
		
	private double x;
	private double dx;
		
	private double speed;
	
	public BackgroundMove (String s, double sp) {
			
			try {
				image = ImageIO.read(getClass().getResourceAsStream(s));
				speed = sp;
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	
	public void setPosition(double x) { this.x = x * speed;}
	
	public void setVector(double dx) {this.dx = dx;}
	
	public void update() {x += dx;}
	
	public void draw(Graphics2D g) {
		
		g.drawImage(image, (int)x, 0, null);
			if(x < 0) { 
				g.drawImage(image, (int)x + Window.WIDTH_P, 0, null);
			}
			
			if(x > 0) {
				g.drawImage(image, (int)x - Window.WIDTH_P, 0, null);
			}
		}	
}

