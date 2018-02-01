import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

public class player extends KeyAdapter {
	private int moveSetOptions = 0; // decides how the player will move (w,a,s,d or <-,->,^, etc
	Color color = Color.RED;
	private int x,y, radius;
	public enum movementOptions{WASD, ArrowKeys}
	
	public player(int moveSetOptions, Color startingColor, int x, int y, int radius) {
		this.moveSetOptions = moveSetOptions;
		this.color = startingColor;
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	public int setAndGetX(int movement) {
		x += movement;
		return x;
	}
	
	public int setAndGet(int movement) {
		y += movement;
		return y;
	}
	
	public void colorSet(int colorSetTo) {
		switch(colorSetTo) {
		case 0: color = Color.RED; break;
		case 1: color = Color.BLUE; break;
		}
	}
	
	public void draw(Graphics2D g) {
		g.setColor(color);
		g.fillOval(x, y, radius, radius);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_W) {
			System.out.println("W");
			y++;
		}
		if(code == KeyEvent.VK_S) {
			System.out.println("S");
			y--;
		}
		if(code == KeyEvent.VK_D) {
			System.out.println("D");
			x++;
			
		}
		if(code == KeyEvent.VK_A) {
			System.out.println("A");
			x--;
		}
	}
}
