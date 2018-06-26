package plantGame;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class LoadImg {
	//构造器私有化
	private LoadImg() {
		
	}
	
	public static Image getImage(String path) {
		BufferedImage bi=null;		
		try {
			URL u=LoadImg.class.getClassLoader().getResource(path);
			bi=ImageIO.read(u);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bi;
	}
}
