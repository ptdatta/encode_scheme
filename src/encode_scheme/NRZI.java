package encode_scheme;

import java.awt.Graphics2D;

public class NRZI extends Encoder {
    public NRZI(int position) {
        super("NRZ-I",position);
    }

    public void encode(Graphics2D g, String data) {
        super.encode(g, data);
        int x = 220;
        int y = this.position;
        int bitwidth = 460/data.length();
        boolean b = false;
        int grid = x;
        for(int i=0;i<data.length();i++) {
        	g.drawLine(grid, y-100, grid, y+100);
        	grid+=bitwidth;
        }
        g.drawLine(grid, y-100, grid, y+100);
        g.drawLine(150, this.position, 750, this.position);
        g.drawString(this.name, 30, this.position+30);
        for(char bit: data.toCharArray()) {
	        if(bit == '0') {
	        	g.drawLine(x, y-30, x, y+30);
		        if( b == true) {
		        	b = false;
		        }else {
		        	b = true;
		        }
	        }
	        if( b == false) {
	        	g.drawLine(x, y+30, x+bitwidth, y+30);
	        }else if( b == true ) {
	        	g.drawLine(x, y-30, x+bitwidth, y-30);
	        }
	        x += bitwidth;
        }

    }
}
