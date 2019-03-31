package levels;

import java.awt.*;

//import TileMap.Background;

public class Menu extends Level {
	
	//private background bg; zrób bg

	private Color titleColor;
	private Font titleFont;
	
	private Font font;
	private String[] options=
			{
					"New Game",//"Nowa Gra"
					"Load Game",//"Wczytaj Grę"
					"Options"//"Opcje"
			};
	

	Menu(LevelManager lm)
	{
		this.lm = lm;
		
	
		try {
			/*
			bg = new Background("/Backgrounds/menubg.gif", 1);
			bg.setVector(-0.1, 0);
			*/
			titleColor = new Color(256, 200, 100);
			titleFont = new Font(
					"Utopia",
					Font.PLAIN,
					42);
			
			font = new Font("FreeSans", Font.PLAIN, 24);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void start() {}

	
	public void update() {
		// bg.update

	}

	@Override
	public void draw(Graphics2D g) {
		// bg.draw

	}

	@Override
	public void keyPressed(int k) {
		//

	}

	@Override
	public void keyReleased(int k) {
		

	}
	private void choice(int ch)
	{
		switch(ch)
		{
			case 1:
				lm.loadLevel(1); //To będzie przycisk nowa gra
		}
	}

}
