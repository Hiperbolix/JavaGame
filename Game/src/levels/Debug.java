package levels;

import java.awt.Color;
import java.awt.Graphics2D;

import Game.Window;
import entity.Player;
import sprites.Background;
import sprites.SpriteMap;

public class Debug extends Level {
	

	private SpriteMap spriteMap;
	private Background bg;
	
	private Player player;

	public Debug(LevelManager lm) {
		this.lm = lm;
		start();
	}
	
	public void start() {
		
		spriteMap = new SpriteMap(80);
		spriteMap.loadTiles("/Sprites/placeholderset.gif");
		spriteMap.loadMap("/Maps/level1.map");
		spriteMap.setPosition(0, 0);
		
		player = new Player(spriteMap);
		player.setPosition(300, 100);
		
		bg = new Background("/Sprites/placeholderbg.gif");
		

	}

	@Override
	public void update() {
		player.update();
		spriteMap.setPosition(
			Window.WIDTH / 2 - player.getx(),
			Window.HEIGHT / 2 - player.gety()
		);
		
		// set background
		bg.setPosition(spriteMap.getx(), spriteMap.gety());

	}

	@Override
	public void draw(Graphics2D g) {
		/*
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, Window.WIDTH_P, Window.HEIGHT_P);
		g.setColor(Color.RED);
		g.fillRect(1,1,10,10);
		//System.out.println("Jestem tu");
		// draw tilemap
		 */
		bg.draw(g);
		
		spriteMap.draw(g);
		
		player.draw(g);

	}

	@Override
	public void keyPressed(int k) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub

	}

}
