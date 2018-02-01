import java.awt.Color;
import java.awt.Graphics2D;

public class player {
	private int moveSetOptions = 0; // decides how the player will move (w,a,s,d or <-,->,^, etc
	Color color = Color.BLACK;
	private int x,y, radius;
	
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
		Graphics2D gd2 = (Graphics2D)g;
		gd2.setColor(color);
		gd2.fillOval(x, y, radius, radius);
	}
}
