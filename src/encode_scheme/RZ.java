package encode_scheme;

import java.awt.Graphics2D;

public class RZ extends Encoder {
    public RZ(int position) {
        super("RZ",position);
    }

    public void encode(Graphics2D g, String data) {
        super.encode(g, data);
        int x = 220;
        int y = this.position;
        int bitWidth = 460/data.length();
        int grid = x;
        for(int i=0;i<data.length();i++) {
        	g.drawLine(grid, y-100, grid, y+100);
        	grid+=bitWidth;
        }
        g.drawLine(grid, y-100, grid, y+100);
        g.drawString(this.name, 30, this.position+30);
        g.drawLine(150, this.position, 750, this.position);
        for (char bit : data.toCharArray()){
           if(bit == '0'){
               g.drawLine(x, y, x, y+30);
               g.drawLine(x, y+30, x+(bitWidth/2), y+30);
               g.drawLine(x+(bitWidth/2), y+30, x+(bitWidth/2), y);
               x+=bitWidth;
           } else if (bit == '1'){
               g.drawLine(x, y, x, y-30);
               g.drawLine(x, y-30, x+(bitWidth/2), y-30);
               g.drawLine(x+(bitWidth/2), y-30, x+(bitWidth/2), y);
               x+=bitWidth;
           }
        }

    }
}
