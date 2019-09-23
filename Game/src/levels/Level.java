package levels;

public abstract class Level { 
	//Klasa Abstrakcynja, ktora mniej wiecej mowi czym jest poziom
	
	protected LevelManager lm;
	
	public abstract void start();
	public abstract void update();
	public abstract void draw(java.awt.Graphics2D g);
	public abstract void keyPressed(int k);
	public abstract void keyReleased(int k);
}
