package levels;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import Game.Window;
import audio.AudioPlayer;
import entity.*;
import sprites.*;

public class Level1 extends Level {
	

	private SpriteMap spriteMap;
	private Background bg;
	
	private Player player;

	private AudioPlayer bgMusic;

	public Level1(LevelManager lm) {
		this.lm = lm;
		start();
	}
	
	public void start() {
		
		spriteMap = new SpriteMap(75);
		spriteMap.loadTiles("/Tilesets/tileset1.png");
		spriteMap.loadMap("/Maps/level1.map");
		spriteMap.setPosition(0, 0);
		spriteMap.setTween(1);
		
		bg = new Background("/Backgrounds/clouds.jpg");
		
		player = new Player(spriteMap);
		player.setPosition(100, 200);

		bgMusic = new AudioPlayer("/Music/Quick.mp3");
		bgMusic.play();
		
		

	}

	@Override
	public void update() {
		player.update();
		spriteMap.setPosition(
			Window.WIDTH_P / 2 - player.getx(),
			Window.HEIGHT_P / 2 - player.gety()
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

	public void keyPressed(int k) {
		if(k == KeyEvent.VK_A) player.setLeft(true);
		if(k == KeyEvent.VK_D) player.setRight(true);
		if(k == KeyEvent.VK_UP) player.setUp(true);
		if(k == KeyEvent.VK_S) player.setDown(true);
		if(k == KeyEvent.VK_W) player.setJumping(true);
		if(k == KeyEvent.VK_ESCAPE) System.exit(0);
		if(k == KeyEvent.VK_ENTER) lm.setState(LevelManager.MENUID);
	}
	
	public void keyReleased(int k) {
		if(k == KeyEvent.VK_A) player.setLeft(false);
		if(k == KeyEvent.VK_D) player.setRight(false);
		if(k == KeyEvent.VK_UP) player.setUp(false);
		if(k == KeyEvent.VK_S) player.setDown(false);
		if(k == KeyEvent.VK_W) player.setJumping(false);
		
		
	}

}

