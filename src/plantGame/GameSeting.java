package plantGame;

import java.awt.event.KeyEvent;

public class GameSeting {
	private boolean live;

	public GameSeting(boolean live) {
		super();
		this.live = live;
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}
	public void addDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_ENTER:
			System.out.println("sa");
			live=true;
			break;
		}
	}
	
}
