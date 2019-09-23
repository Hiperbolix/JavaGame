package levels;

import menu.*;

public class LevelManager {

	
	protected Level[] lvl;
	protected int currentLvl;
	
	public static final int LVLAMMOUNT = 9;
	
	public static final int MENUID = 0;
	public static final int LVL1ID = 1;
	public static final int MENU_E = 2;	
	public static final int SETTINGS_E = 3;
	public static final int MENU_R = 4;	
	public static final int SETTINGS_R = 5;
	public static final int SETTINGS_P = 6;
	public static final int LVL2 = 7;
	public static final int LVL3 = 8;

	
	public LevelManager()
	{
		lvl =new Level[LVLAMMOUNT];
		currentLvl = MENUID;
		loadLevel(currentLvl);
	}

	protected void loadLevel(int lvlN) {
		
		if(lvlN == MENUID) lvl[lvlN] = new MenuP(this);
		if(lvlN == LVL1ID) lvl[lvlN] = new Level1(this);
		if(lvlN == SETTINGS_P) lvl[lvlN] = new SettingsP(this);
		if(lvlN == MENU_E) lvl[lvlN] = new MenuE(this);
		if(lvlN == SETTINGS_E) lvl[lvlN] = new SettingsE(this);
		if(lvlN == MENU_R) lvl[lvlN] = new MenuR(this);
		if(lvlN == SETTINGS_R) lvl[lvlN] = new SettingsR(this);
		if(lvlN == LVL2) lvl[lvlN] = new Level2(this);
		if(lvlN == LVL3) lvl[lvlN] = new Level3(this);	
	}
	
	
	private void unloadLevel(int state) {
		lvl[state] = null;
	}
	
	public void setLvl(int lvl) {
		unloadLevel(currentLvl);
		currentLvl = lvl;
		loadLevel(currentLvl);
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