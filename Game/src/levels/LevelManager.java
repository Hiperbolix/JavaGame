package levels;

public class LevelManager {

	protected Level[] lvl;
	protected int currentLvl;
	
	protected final int LVLAMMOUNT = 1;
	protected final int MENUID =0;
	
	LevelManager()
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
	
	
}
