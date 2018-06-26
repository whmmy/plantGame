package plantGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class GameObjact {
	private Image img;
	private double x,y;
	private double speed=1;
	private int width,height;
	
	
	private void drawSlef(Graphics g) {
		g.drawImage(img, (int)x, (int)y, null);		
	}
	
	public GameObjact(Image img, double x, double y, int speed, int width, int height) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.width = width;
		this.height = height;
	}

	public GameObjact(Image img, double x, double y, int speed) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
		this.speed = speed;
	}
	
	public GameObjact() {
		
	}
	
	public Rectangle getRect() {
		return new Rectangle((int)x,(int) y, width, height);
	}

	public Image getImg() {
		return img;
	}
	public void setImg(Image img) {
		this.img = img;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}
