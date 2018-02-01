import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawingPanel extends Canvas implements Runnable{
	
	public player p1 = new player(movementOptions.WASD, Color.RED, defDim.width / 4, defDim.height / 2, 10);
	public player p2 = new player(movementOptions.ARROWS, Color.BLUE, 3 * defDim.width / 4, defDim.height / 2, 10);
	public static int FPStrace = 20;
	
	public static Dimension defDim = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getSize();
	private Thread thread;
	private boolean running = false;
	
	private Handler defHandler;
	
	public DrawingPanel() {
		this.setPreferredSize(defDim);
		defHandler = new Handler();
		this.addKeyListener(defHandler);
		
		defHandler.add(p1);
		defHandler.add(p2);
	}
	
	public void paint() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, defDim.width, defDim.height);
		defHandler.paint(g);
		g.dispose();
		bs.show();
	}
	

	public void update() {
		defHandler.update();
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				update();
				delta--;
			}
			if(running) {
				this.paint();
			}
			frames++;
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
			try {
				Thread.sleep(FPStrace);
			}catch(Exception e){
				e.printStackTrace();
			}
		}	
	}
}
