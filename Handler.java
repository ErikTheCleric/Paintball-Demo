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
		if(code == KeyEvent.VK_W) {
			//System.out.println("W");
			for(player i : players) {
				if(i.getMovement() == movementOptions.WASD) {
					i.changeVelY(false);
				}
			}
		}
		if(code == KeyEvent.VK_S) {
			//System.out.println("S");
			for(player i : players) {
				if(i.getMovement() == movementOptions.WASD) {
					i.changeVelY(true);
				}
			}
		}
		if(code == KeyEvent.VK_D) {
			//System.out.println("D");
			for(player i : players) {
				if(i.getMovement() == movementOptions.WASD) {
					i.changeVelX(true);
				}
			}
		}
		if(code == KeyEvent.VK_A) {
			//System.out.println("A");
			for(player i : players) {
				if(i.getMovement() == movementOptions.WASD) {
					i.changeVelX(false);
				}
			}
		}
		if(code == KeyEvent.VK_UP) {
			//System.out.println("UP");
			for(player i : players) {
				if(i.getMovement() == movementOptions.ARROWS) {
					i.changeVelY(false);
				}
			}
		}
		if(code == KeyEvent.VK_DOWN) {
			//System.out.println("DOWN");
			for(player i : players) {
				if(i.getMovement() == movementOptions.ARROWS) {
					i.changeVelY(true);
				}
			}
		}
		if(code == KeyEvent.VK_RIGHT) {
			//System.out.println("RIGHT");
			for(player i : players) {
				if(i.getMovement() == movementOptions.ARROWS) {
					i.changeVelX(true);
				}
			}
		}
		if(code == KeyEvent.VK_LEFT) {
			//System.out.println("LEFT");
			for(player i : players) {
				if(i.getMovement() == movementOptions.ARROWS) {
					i.changeVelX(false);
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		for(player i : players) {
			while(i.getVelX() < 0) {
				i.changeVelX(true);
			}
			while(i.getVelX() > 0) {
				i.changeVelX(false);
			}
			while(i.getVelY() < 0) {
				i.changeVelY(true);
			}
			while(i.getVelY() > 0) {
				i.changeVelY(false);
			}
		}
	}
}
