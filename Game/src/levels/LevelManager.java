package levels;

public class LevelManager {

	
	protected Level[] lvl;
	protected int currentLvl;
	
	public static final int LVLAMMOUNT = 2;
	public static final int MENU = 0;
	public static final int LEVEL1 = 1;
	
	public LevelManager()
	{
		lvl =new Level[LVLAMMOUNT];
		currentLvl = MENU;
		loadLevel(currentLvl);
	}

	
	protected void loadLevel (int i) {
		if(i == MENU)
			lvl[i] = new Menu(this);
		if(i == LEVEL1)
			lvl[i] = new Level1(this);
		
	}
	
	public void draw(java.awt.Graphics2D g) {
		try {
			lvl[currentLvl].draw(g);
		} catch(Exception e) {}
	}
	
	public void keyPressed(int k) {
		lvl[currentLvl].keyPressed(k);
	}
	
	public void keyReleased(int k) {
		lvl[currentLvl].keyReleased(k);
	}
	
	public void update() {
		try {
			lvl[currentLvl].update();
		} catch(Exception e) {}
	}

	public void setState(int i) {
		lvl[currentLvl] = null;
		currentLvl = i;
		loadLevel(currentLvl);
		
	}	
	
	
}
