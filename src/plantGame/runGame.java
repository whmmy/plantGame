package plantGame;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.awt.Frame;

public class runGame extends Frame{
	Image plantImg=LoadImg.getImage("Img/plant.png");
	Plant plant=new Plant(plantImg,200,490);
	Shell[] shells=new Shell[70];
	PlaneBoom pb;
	Date startTime=new Date();
	Date runTime;
	Date endTime;
	double runingT,endingT;
	GameSeting gs=new GameSeting(true);
	
	public void reStart() {
		plant=new Plant(plantImg,200,490);
		shells=new Shell[70];
		startTime=new Date();
		for(int i=0;i<shells.length;i++) {
			shells[i]=new Shell();			
		}
	}

	@Override
	public void paint(Graphics g) {
		g.setFont(new Font("宋体", Font.BOLD, 30));
		
		plant.drawSlef(g);
		if(gs.isLive()) {
			g.drawString("time:"+runingT, 10, 80);
		}else {
			
			g.drawString("time:"+endingT, 10, 80);
			g.setFont(new Font("宋体", Font.BOLD, 40));
			g.drawString("GAMEOVER ", 140, 280);
			g.drawString("TIME:"+endingT, 130, 330);
		}
		for(int i=0;i<shells.length;i++) {
			shells[i].draw(g);
			//shells[i].speedup(runingT);
			boolean hit=shells[i].getRect().intersects(plant.getRect());
			if(hit) {
				gs.setLive(false);
				System.out.println("sasa");
				if(pb==null) {
					pb=new PlaneBoom(plant.getX(), plant.getY());
				}
				endTime=new Date();
				endingT=(endTime.getTime()-startTime.getTime())/1000.00;
				pb.draw(g);
				for(int j=0;j<shells.length;j++) {	//StopShells				
					shells[j].setSpeed(0);
				}
			}
		}
		
		//g.fillOval(100,100,100,100);
		
	}
	
	//�߳�
	class PrintThread extends Thread{

		@Override
		public void run() {
			while(true) {
				repaint();
				runTime=new Date();
				runingT=(runTime.getTime()-startTime.getTime())/1000.00;
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if(!gs.isLive()) {					
					reStart();
				}
			}
		}
		
	}
	
	class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			plant.addDirection(e);
			gs.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			plant.minDirection(e);
		}
		
	}

	public void rungame() {
		this.setSize(Constart.GAME_WIDTH,Constart.GAME_HEIGHT);
		this.setLocation(50, 50);
		this.setTitle("whGame");
		
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
		new PrintThread().start();//�߳�����
		addKeyListener(new KeyMonitor());//���̼���
		
		for(int i=0;i<shells.length;i++) {
			shells[i]=new Shell();			
		}
	}
	
	public static void main(String[] args) {
		runGame rg=new runGame();
		
		rg.rungame();
		
	}
	
	private Image offScreenImage = null;
/**
 * ���˫����
 * 
 * 
 */
//	public void update(Graphics g) {
//		if(offScreenImage==null) {
//			offScreenImage=this.createImage(Constart.GAME_WIDTH,Constart.GAME_HEIGHT);
//		}
//		
//		Graphics gOff=offScreenImage.getGraphics();
//		print(gOff);
//		g.drawImage(offScreenImage, 0, 0, null);
//	}
}
