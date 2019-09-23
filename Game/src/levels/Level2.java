package levels;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import audio.AudioPlayer;
import entity.*;
import game.*;
import sprites.*;

public class Level2 extends Level {
	
	private SpriteMap spriteMap;
	private Background bg;
	
	private Player player;
	
	private AudioPlayer bgMusic;

	public Level2(LevelManager lm) {
		this.lm = lm;
		start();
	}
	
	public void start() {
		
		spriteMap = new SpriteMap(75);
		spriteMap.loadTiles("/Tilesets/tileset2.png");
		spriteMap.loadMap("/Maps/level2.map");
		spriteMap.setPosition(0, 0);
		spriteMap.setTween(1);
		
		bg = new Background("/Backgrounds/night.png");
		
		player = new Player(spriteMap);
		player.setPosition(100, 490);
		
		bgMusic = new AudioPlayer("/Music/Quick.mp3");
		
	}

	public void update() {
		player.update();
		spriteMap.setPosition(
			Window.WIDTH_P / 2 - player.getx(),
			Window.HEIGHT_P / 2 - player.gety()
		);
		
		// set background
		bg.setPosition(spriteMap.getx(), spriteMap.gety());

	}

	public void draw(Graphics2D g) {
		
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
		if(k == KeyEvent.VK_0) bgMusic.play();
		if(k == KeyEvent.VK_MINUS) bgMusic.stop();
	}
	
	public void keyReleased(int k) {
		if(k == KeyEvent.VK_A) player.setLeft(false);
		if(k == KeyEvent.VK_D) player.setRight(false);
		if(k == KeyEvent.VK_UP) player.setUp(false);
		if(k == KeyEvent.VK_S) player.setDown(false);
		if(k == KeyEvent.VK_W) player.setJumping(false);
	}

}


