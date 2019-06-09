package levels;

public class LevelManager {

	
	protected Level[] lvl;
	protected int currentLvl;
	
<<<<<<< HEAD
	public static final int LVLAMMOUNT = 3;
	public static final int MENUID =0;
	public static final int LVL1ID=1;
	public static final int DEBUGID=2;
=======
	public static final int LVLAMMOUNT = 2;
	public static final int MENU = 0;
	public static final int LEVEL1 = 1;
>>>>>>> branch 'master' of https://github.com/Hiperbolix/JavaGame.git
	
	public LevelManager()
	{
		lvl =new Level[LVLAMMOUNT];
<<<<<<< HEAD
		currentLvl = MENUID;
		//currentLvl = DEBUGID;
=======
		currentLvl = MENU;
>>>>>>> branch 'master' of https://github.com/Hiperbolix/JavaGame.git
		loadLevel(currentLvl);
	}

<<<<<<< HEAD
	protected void loadLevel(int lvlN) {
=======
	
	protected void loadLevel (int i) {
		if(i == MENU)
			lvl[i] = new Menu(this);
		if(i == LEVEL1)
			lvl[i] = new Level1(this);
>>>>>>> branch 'master' of https://github.com/Hiperbolix/JavaGame.git
		
		if(lvlN == MENUID) lvl[lvlN] = new Menu(this);
		if(lvlN == LVL1ID) lvl[lvlN] = new Level1(this);
		if(lvlN == DEBUGID) lvl[lvlN] = new Debug(this);
		
	}
	
	private void unloadLevel(int state) {
		lvl[state] = null;
	}
	
	public void setLvl(int lvl) {
		unloadLevel(currentLvl);
		currentLvl = lvl;
		loadLevel(currentLvl);
		//gameStates[currentState].init();
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
