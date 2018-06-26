package plantGame;

import java.awt.Graphics;
import java.sql.Date;

public class Shell extends GameObjact {
	double degree;
	
	public Shell() {
		this.setX(200);
		this.setY(200);
		this.setWidth(10);
		this.setHeight(10);
		this.setSpeed(3);
		
		degree=Math.random()*Math.PI*2;
	}
	public void speedup(double runingT) {
		
		if((int)runingT%5==0 && (int)runingT!=0) {
			System.out.println("UPSPEED!!");
			this.setSpeed((this.getSpeed()+0.1));
		}
	}
	
	public void draw(Graphics g) {
		g.fillOval((int)this.getX(), (int)this.getY(), this.getHeight(), this.getWidth());
		//用弧度算XY轴的数值
		this.setX(this.getX()+this.getSpeed()*Math.cos(degree));
		this.setY(this.getY()+this.getSpeed()*Math.sin(degree));
		
		if(this.getX()<10||this.getX()>Constart.GAME_WIDTH-this.getWidth()) {
			degree=Math.PI-degree;
		}
		
		if(this.getY()<30||this.getY()>Constart.GAME_HEIGHT-this.getHeight()) {
			
			degree=-degree;
		}
		
	}
}
