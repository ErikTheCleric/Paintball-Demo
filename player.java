import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

public class player {
	private movementOptions moveSetOptions = movementOptions.DEFAULT; // decides how the player will move (w,a,s,d or <-,->,^, etc
	Color color = Color.RED;
	private int x, y, radius, velX, velY;
	private int maxX = 3, maxY = 3;
	
	public player(movementOptions i, Color startingColor, int x, int y, int radius) {
		this.moveSetOptions = i;
		this.color = startingColor;
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	public void changeVelX(boolean inc) {
		if(inc && velX + 1 <= maxX) {
			velX++;
		}
		if(!inc && velX - 1 >= maxX * -1){
			velX--;
		}
	}
	
	public int getVelX() {
		return velX;
	}
	
	public void changeVelY(boolean inc) {
		if(inc && velX + 1 <= maxY) {
			velY++;
		}
		if(!inc && velY - 1 >= maxY * -1){
			velY--;
		}
	}
	
	public int getVelY() {
		return velY;
	}
	
	public void colorSet(Color colorSetTo) {
		color = colorSetTo;
	}
	
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, radius, radius);
	}
	
	public void update() {
		x += velX;
		y += velY;
	}

	public movementOptions getMovement() {
		return moveSetOptions;
	}
}
