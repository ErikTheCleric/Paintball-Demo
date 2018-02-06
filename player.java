import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

// circle making project

public class MainClass extends JFrame {

	JPanel contentPane = new JPanel();
	
	public MainClass(drawingPanel window) {
		this.setTitle("PAINTBALL");
		this.setResizable(false);
		this.setSize(drawingPanel.defDim);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		contentPane.add(window);
		this.setContentPane(contentPane);
		this.setVisible(true);
		window.start();
	}
	
	public static void main(String[] args) {
		drawingPanel win = new drawingPanel();
		new MainClass(win);
	}

}

