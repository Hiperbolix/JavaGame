package sprites;

import java.awt.image.BufferedImage;

public class Sprite {
	
	private BufferedImage image;
	private int type;
	
	public static final int NORMAL = 0;
	public static final int BLOCKED = 1;
	
	public Sprite(BufferedImage image, int type) {
		this.image = image;
		this.type = type;
	}
	
	public BufferedImage getImage() { return image; }
	public int getType() { return type; }	
}
