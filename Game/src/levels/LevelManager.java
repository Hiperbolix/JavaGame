package levels;

public class LevelManager {

	protected Level[] lvl;
	protected int currentLvl;
	
	protected final int LVLAMMOUNT = 1;
	protected final int MENUID =0;
	
	public LevelManager()
	{
		lvl =new Level[LVLAMMOUNT];
		currentLvl = MENUID;
		loadLevel(currentLvl);
	}

	protected void loadLevel(int i) {
		switch(i)
		{
			case 1/* Level1ID? */:
				//Jak zrobisz pierwszy poziom to tu wstaw
				break;
			default:
				lvl[i]= new Menu(this);
				break;
		}
		
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
	
	
}
