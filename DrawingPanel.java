import java.awt.Color;
import java.awt.Graphics;
import java.awt.RenderingHints;
import java.util.LinkedList;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
	
	private LinkedList<DotCharacteristics> dots = new LinkedList<DotCharacteristics>();
	private boolean turnOnLines = false, zFormation = false;
	
	private int[][] arrayPoints = new int[LineCharacteristics.limitOfPoints][2];
	
	public void addDots(DotCharacteristics newDots) {
		dots.add(newDots);
		this.repaint();
		
	}
	
	public void savePoints(int[][] holdingArray) {
		arrayPoints = holdingArray;
	}
	
	public void connectLinesZ() {
		zFormation = true;
		this.repaint();
	}
	
	public void connectLines() {
		System.out.println("DRAWING LINES");
		turnOnLines = true;
		this.setBackground(Color.RED);
		this.repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		
		LineCharacteristics df = new LineCharacteristics(arrayPoints);
		if(turnOnLines == true) {
			df.drawAllLines(g);
			turnOnLines =! turnOnLines;
		}
		if(zFormation == true) {
			zFormation = false;
			df.drawPointToNetNumPoint(g);
		}
		for(DotCharacteristics r : dots) {
			r.draw(g);
		}
	}
}
