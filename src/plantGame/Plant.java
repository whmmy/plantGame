package plantGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

public class Plant extends GameObjact{
	
	boolean left,right,up,down;
	private boolean live=true;
	
	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public void drawSlef(Graphics g) {
		
		if(live) {			
			g.drawImage(this.getImg(), (int)this.getX(), (int)this.getY(), null);
			if(left && this.getX()>10) {
				this.setX(this.getX()-this.getSpeed());
			}
			if(right && this.getX()<Constart.GAME_WIDTH-this.getWidth()) {
				this.setX(this.getX()+this.getSpeed());
			}
			if(up && this.getY()>10) {
				this.setY(this.getY()-this.getSpeed());
			}
			if(down && this.getY()<Constart.GAME_HEIGHT-this.getHeight()) {
				this.setY(this.getY()+this.getSpeed());
			}
		}
	}
	
	public Plant(Image img,double x,double y) {
		this.setImg(img);
		this.setX(x);
		this.setY(y);
		this.setSpeed(8);
		this.setWidth(img.getWidth(null));
		this.setHeight(img.getHeight(null));
		
	}
	
	
	public void addDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left=true;
			break;
		case KeyEvent.VK_RIGHT:
			right=true;
			break;
		case KeyEvent.VK_UP:
			up=true;
			break;
		case KeyEvent.VK_DOWN:
			down=true;
			break;
		}
	}
	
	public void minDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left=false;
			break;
		case KeyEvent.VK_RIGHT:
			right=false;
			break;
		case KeyEvent.VK_UP:
			up=false;
			break;
		case KeyEvent.VK_DOWN:
			down=false;
			break;
		}
	}
}
