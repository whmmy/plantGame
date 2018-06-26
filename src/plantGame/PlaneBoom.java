package plantGame;

import java.awt.Graphics;
import java.awt.Image;

public class PlaneBoom {
	double x,y;
	
	static Image[] imgs=new Image[9];
	
	static {
		for(int i=0;i<9;i++) {
			imgs[i]=LoadImg.getImage("imgList/bao"+(i+1)+".png");
			imgs[i].getWidth(null);
		}
	}
	
	int count;
	
	public void draw(Graphics g) {
		if(count <=8) {
			g.drawImage(imgs[count], (int)x,(int) y, null);
			count++;
		}
	}
	
	public PlaneBoom(double x,double y) {
		this.x=x;
		this.y=y;
	}
}
