<<<<<<< HEAD
package levels;

import java.awt.Graphics2D;
//import java.awt.Point;
import java.awt.event.KeyEvent;
//import java.util.ArrayList;

//import entity.Animation;
import Game.Window;
import sprites.Background;
import sprites.SpriteMap;
import entity.Player;


public class Level1 extends Level {

	private SpriteMap spriteMap;
	private Background bg;
	
	private Player player;
	
	//private ArrayList<Enemy> enemies;
	
	//private HUD hud;
	
	//private AudioPlayer bgMusic;
	
	public Level1(LevelManager lm) {
		this.lm = lm;
		start();
	}
	
	public void start() {
		
		spriteMap = new SpriteMap(40);
		spriteMap.loadTiles("/Sprites/grasstileset.gif");
		spriteMap.loadMap("/Maps/level1.map");
		spriteMap.setPosition(0, 0);
		spriteMap.setTween(1);
		
		bg = new Background("/Sprites/placeholderbg.gif");
		
		player = new Player(spriteMap);
		player.setPosition(100, 100);
		/*
		populateEnemies();
		
		hud = new HUD(player);
		
		bgMusic = new AudioPlayer("/Music/level1-1.mp3");
		bgMusic.play();
		*/
		
	}
	/*
	private void populateEnemies() {
		
		enemies = new ArrayList<Enemy>();
		
	}
	*/
	
	public void update() {
		
		// update player
		player.update();
		spriteMap.setPosition(
			Window.WIDTH / 2 - player.getx(),
			Window.HEIGHT / 2 - player.gety()
		);
		
		// set background
		bg.setPosition(spriteMap.getx(), spriteMap.gety());
		
		// attack enemies
		//player.checkAttack(enemies);
		
		// update all enemies
		/*
		for(int i = 0; i < enemies.size(); i++) {
			Enemy e = enemies.get(i);
			e.update();
			if(e.isDead()) {
				enemies.remove(i);
				i--;
			}
		}
		
		*/
		
	}
	
	public void draw(Graphics2D g) {
		
		// draw bg
		bg.draw(g);
		
		// draw spriteMap
		spriteMap.draw(g);
		
		// draw player
		player.draw(g);
		
		// draw enemies
		/*
		for(int i = 0; i < enemies.size(); i++) {
			enemies.get(i).draw(g);
		}
		
		// draw explosions
		for(int i = 0; i < explosions.size(); i++) {
			explosions.get(i).setMapPosition(
				(int)spriteMap.getx(), (int)spriteMap.gety());
			explosions.get(i).draw(g);
		}
		
		// draw hud
		hud.draw(g);
		*/
		
	}
	
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_LEFT) player.setLeft(true);
		if(k == KeyEvent.VK_RIGHT) player.setRight(true);
		if(k == KeyEvent.VK_UP) player.setUp(true);
		if(k == KeyEvent.VK_DOWN) player.setDown(true);
		if(k == KeyEvent.VK_W) player.setJumping(true);
	}
	
	public void keyReleased(int k) {
		if(k == KeyEvent.VK_LEFT) player.setLeft(false);
		if(k == KeyEvent.VK_RIGHT) player.setRight(false);
		if(k == KeyEvent.VK_UP) player.setUp(false);
		if(k == KeyEvent.VK_DOWN) player.setDown(false);
		if(k == KeyEvent.VK_W) player.setJumping(false);
	}

}
=======
package levels;

import java.awt.*;
import java.awt.event.KeyEvent;

import Game.BackgroundMove;


public class Level1 extends Level {
	
	private BackgroundMove back;
	
	public Level1(LevelManager lm) {
		this.lm = lm;
		start();
	}

	@Override
	public void start() {
			try {
				back = new BackgroundMove("Image/tile1.png",20);
				
				back.setPosition(0);	
				back.setVector(-2);
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	@Override
	public void update() {
			back.update();
			
		}
	
	@Override
	public void draw(Graphics2D g) {
			back.draw(g);
			
		}
	
	@Override
	public void keyPressed(int k) {
			if(k == KeyEvent.VK_ENTER) lm.setState(LevelManager.MENU);
		}
	
	@Override
	public void keyReleased(int k) {
			// TODO Auto-generated method stub
			
		}

}
>>>>>>> branch 'master' of https://github.com/Hiperbolix/JavaGame.git
