import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Handler extends KeyAdapter{
	public ArrayList <player> players;
	
	public Handler() {
		players = new ArrayList<player>();
	}
	
	public void paint(Graphics g) {
		for(player i : players) {
			i.paint(g);
		}
	}
	
	public void update() {
		for(player i : players) {
			i.update();
		}
		for(int i = 0; i < players.size() / 2; i++) {
			for(int j = (players.size() / 2) - 1; j < players.size(); j++) {
				if(i != j) {
					if(players.get(i).intersect(players.get(j))) {
						System.out.println("intersecting");
						Color pre = players.get(i).getColor();
						players.get(i).colorSet(players.get(j).getColor());
						players.get(j).colorSet(pre);
						
						players.get(i).setVelX(0);
						players.get(i).setVelX(0);
						players.get(j).setVelY(0);
						players.get(j).setVelY(0);	
					}
				}
			}
		}
	}
	
	public void add(player i) {
		players.add(i);
	}
	
	public void remove(player i) {
		players.remove(i);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		int code = e.getKeyCode();
		for(player i : players) {
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
		for(player i : players) {
			i.setVelX(0);
			i.setVelX(0);
			i.setVelY(0);
			i.setVelY(0);
		}
	}
}
