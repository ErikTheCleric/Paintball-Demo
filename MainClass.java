import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

// circle making project

public class MainClass extends JFrame {

	JPanel contentPane = new JPanel();
	
	public MainClass(DrawingPanel window) {
		this.setTitle("PAINTBALL");
		this.setResizable(true);
		this.setSize(DrawingPanel.defDim);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		contentPane.add(window);
		this.setContentPane(contentPane);
		this.setVisible(true);
		window.start();
	}
	
	public static void main(String[] args) {
		DrawingPanel win = new DrawingPanel();
		new MainClass(win);
	}

}
