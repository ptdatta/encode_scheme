package encode_scheme;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * 
 * @author Dr. Sunirmal Khatua
 *
 */
public abstract class Encoder {
	
	String name;
	int position;
	
	public Encoder(String name) {
		this.name = name;
	}
	
	public Encoder(String name,int position) {
		this.name = name;
		this.position = position;
	}
	

	public void encode(Graphics2D g, String data) {
		Image i = new ImageIcon("computer.jpg").getImage();
		g.drawImage(i,40,100,100,100,null);
		g.drawImage(i,760,100,100,100,null);
		int bitWidth = 460/data.length();
		int grid = 220;
		for(int z=0;z<data.length();z++) {
			g.drawString(data.charAt(z)+"", grid+(bitWidth/2)-3, 80);
			grid += bitWidth;
		}
	}

}
