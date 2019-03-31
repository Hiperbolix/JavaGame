package Game;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JFrame;


public class Window extends JPanel implements Runnable, KeyListener{

	public final String title ="Nie wiem";
	public final int WIDTH_P =1920;
	public final int HEIGHT_P =1080;
	
	// Wątki
	private Thread thread;
	private boolean running;
	private int FPS = 60;
	private long targetTime = 1000 / FPS;
		
	public Window()
	{
		super();
		setPreferredSize(new Dimension(WIDTH_P,HEIGHT_P)); //Dodaj możliwość zmiany rozdzielczości
		requestFocus();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
