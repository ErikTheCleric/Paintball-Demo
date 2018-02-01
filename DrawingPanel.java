import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class drawingPanel extends JPanel{
	
	player p1 = new player(1, Color.RED, 100, 100, 100);
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		p1.draw(g2d);
		this.repaint();
	}
	
	
}

