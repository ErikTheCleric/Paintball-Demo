import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Handler extends KeyAdapter{
	public ArrayList <player> Userplayers;
	
	public Handler() {
		Userplayers = new ArrayList<player>();
	}
	
	public void paint(Graphics g) {
		for(player i : Userplayers) {
			i.paint(g);
		}
	}
	
	public void update() {
		if(Userplayers.get(0).circlesTouching(Userplayers.get(0).getX(), Userplayers.get(0).getY(), Userplayers.get(0).getDiameter() / 2, Userplayers.get(1).getX(), Userplayers.get(1).getY(), Userplayers.get(1).getDiameter() / 2)) {
			Color temp = Userplayers.get(0).getColor();
			Userplayers.get(0).colorSet(Userplayers.get(1).getColor());
			Userplayers.get(1).colorSet(temp);

			Userplayers.get(0).oppVelX();
			Userplayers.get(0).oppVelY();
			Userplayers.get(1).oppVelX();
			Userplayers.get(1).oppVelY();
			
			//Userplayers.get(0).setVelX(0);
			//Userplayers.get(1).setVelX(0);
		}
		for(player i : Userplayers) {
			i.update();
			//i.setVelX(0);
		}
	}
	
	public void add(player i) {
		Userplayers.add(i);
	}
	
	public void remove(player i) {
		Userplayers.remove(i);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		int code = e.getKeyCode();
		for(player i : Userplayers) {
			if(i.getMovement() == movementOptions.WASD) {
				if(code == KeyEvent.VK_W) {
					//System.out.println("W");
					i.setVelY(player.max * -1);
				}
				if(code == KeyEvent.VK_S) {
					//System.out.println("S");
					i.setVelY(player.max);
				}
				if(code == KeyEvent.VK_D) {
					//System.out.println("D");
					i.setVelX(player.max);
				}
				if(code == KeyEvent.VK_A) {
					//System.out.println("A");
					i.setVelX(player.max * -1);
				}
			}
			if(i.getMovement() == movementOptions.ARROWS) {
				if(code == KeyEvent.VK_UP) {
					//System.out.println("UP");
					i.setVelY(player.max * -1);
				}
				if(code == KeyEvent.VK_DOWN) {
					//System.out.println("DOWN");
					i.setVelY(player.max);
				}
				if(code == KeyEvent.VK_RIGHT) {
					//System.out.println("RIGHT");
					i.setVelX(player.max);
				}
				if(code == KeyEvent.VK_LEFT) {
					//System.out.println("LEFT");
					i.setVelX(player.max * -1);
				}
			}
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		for(player i : Userplayers) {
			i.setVelX(0);
			i.setVelX(0);
			i.setVelY(0);
			i.setVelY(0);
		}
	}
}
