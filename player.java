import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

import javafx.scene.shape.Circle;

public class player {
	private movementOptions moveSetOptions = movementOptions.DEFAULT; // decides how the player will move (w,a,s,d or <-,->,^, etc
	private Color color;
	private int x, y, radius, velX, velY;
	public static int max = 3;
	
	public player(movementOptions i, Color startingColor, int x, int y, int radius) {
		this.moveSetOptions = i;
		this.color = startingColor;
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	
	public void setVelX(int x) {
		velX = x;
	}
	
	public int getVelX() {
		return velX;
	}
	
	public void setVelY(int y) {
		velY = y; /// Erik was here :)
		//I will keep it, because you're a good friend...
		//Courtesy of Deep...
	}
	
	public int getVelY() {
		return velY;
	}
	
	public void colorSet(Color colorSetTo) {
		color = colorSetTo;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, radius, radius);
	}
	
	public Circle mesh() {
		return new Circle(x, y, radius);
	}
	
	public void update() {
		x += velX;
		y += velY;
	}

	public movementOptions getMovement() {
		return moveSetOptions;
	}

	public boolean overlap(player sec) {
		Circle P1 = this.mesh();
		Circle P2 = sec.mesh();
		
		double d = Math.hypot(P2.getCenterX() - P1.getCenterX(), P2.getCenterY() - P2.getCenterY());
		
		if(d <= P2.getRadius() + P1.getRadius()) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean intersect(player sec) {
		double distanceX = (this.mesh().getCenterX() - this.mesh().getRadius()) - (sec.mesh().getCenterX() + sec.mesh().getRadius());
		double distanceY = (this.mesh().getCenterY() - this.mesh().getRadius()) - (sec.mesh().getCenterY() + sec.mesh().getRadius());
		double radiusSum = this.mesh().getRadius() + sec.mesh().getRadius();
		System.out.println(distanceX + "\n" + distanceY + "\n" + radiusSum);
		return distanceX * distanceX + distanceY * distanceY <= radiusSum * radiusSum;
	}
}
