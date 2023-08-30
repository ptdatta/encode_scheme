package encode_scheme;

import java.awt.Graphics2D;

public class NRZL extends Encoder{
	public NRZL(int position) {
		super("NRZ-L",position);
	}

	public void encode(Graphics2D g, String data) {
		super.encode(g, data);
		int x = 220; 
	    int y = this.position; 
	    int bitWidth = 460/data.length(); 
	    char prevbit = ' ';
	    int grid = x;
        for(int i=0;i<data.length();i++) {
        	g.drawLine(grid, y-100, grid, y+100);
        	grid+=bitWidth;
        }
        g.drawLine(grid, y-100, grid, y+100);
        g.drawString(this.name, 30, this.position+0);
	    g.drawLine(150, this.position, 750, this.position);
        for(char bit: data.toCharArray()) {
        	if(prevbit!=' ' &&  prevbit != bit) {
        		g.drawLine(x, y-30, x, y+30);
        	}
        	if (prevbit==' ' &&  bit=='1') {
        		g.drawLine(x, y-30, x, y+30);
        	}
        	if(bit=='0') {
        		g.drawLine(x, y+30, x+bitWidth, y+30);
        	}else if(bit == '1') {
        		g.drawLine(x, y-30, x+bitWidth, y-30);
        	}
        	g.drawLine(x, y, x+bitWidth, y);
        	x+=bitWidth;
        	prevbit = bit;
        }
	}
}
