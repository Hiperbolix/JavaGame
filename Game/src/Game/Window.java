package Game;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import javax.swing.JPanel;

import levels.LevelManager;


public class Window extends JPanel implements Runnable, KeyListener{

	private static final long serialVersionUID = 1L;
	
	public final String title ="...";
	public static final int WIDTH_P = 800;
	public static final int HEIGHT_P = 640;

	
	// Watki
	private Thread thread;
	private boolean running;
	private int FPS = 60;
	private long targetTime = 1000 / FPS;
	
	private BufferedImage image;
	private Graphics2D g;
	
	private LevelManager lm;
		
	public Window() {
		super();
		setPreferredSize(new Dimension(WIDTH_P,HEIGHT_P));
		setFocusable(true);
		requestFocus();
		
		thread = new Thread(this);
		addKeyListener(this);
		thread.start();
		
	}
	
	
	private void start() {
		
			
			image = new BufferedImage(WIDTH_P, HEIGHT_P, BufferedImage.TYPE_INT_RGB);
			g = (Graphics2D) image.getGraphics();
			
			running = true;
			
			lm = new LevelManager();
			
	}

	public void run() {
		
		start();
		
		long start;
		long elapsed;
		long wait;
		
		// game loop
		while(running) {
			
			start = System.nanoTime();
			
			update();
			draw();
			drawToScreen();
			
			elapsed = System.nanoTime() - start;
			
			wait = targetTime - elapsed / 1000000;
			if(wait < 0) wait = 5;
			
			try {
				Thread.sleep(wait);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}


	private void update() {
		lm.update();
		
	}

	public void keyPressed(KeyEvent key) {
		lm.keyPressed(key.getKeyCode());
		
	}

	
	public void keyReleased(KeyEvent key) {
		lm.keyReleased(key.getKeyCode());
		
	}
	
	public void keyTyped(KeyEvent key) {}

	
	private void draw() {
		lm.draw(g);
	}
	private void drawToScreen() {
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, WIDTH_P, HEIGHT_P, null);
		g2.dispose();
	}
}