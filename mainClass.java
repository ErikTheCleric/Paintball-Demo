import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JFrame;

// circle making project

public class MainClass extends JFrame {

	public static void main(String[] args) {
		JFrame gameWindow = new JFrame("PAINTBALL");
		drawingPanel window = new drawingPanel();
		window.setFocusable(true);
		gameWindow.setVisible(true);
		gameWindow.setSize(1000, 700);
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameWindow.setBackground(Color.GRAY);
		
		
		
	}

}
