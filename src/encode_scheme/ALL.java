package encode_scheme;

import java.awt.Graphics2D;

public class ALL extends Encoder {
    public ALL() {
        super("ALL");
    }

    public void encode(Graphics2D g, String data) {
        super.encode(g, data);
        int x = 220;
        int y = 180;
        int bitWidth = 460/data.length();
        boolean up = true;
        int grid = x;
        for(int i=0;i<data.length();i++) {
        	g.drawLine(grid, y-100, grid, y+100);
        	grid+=bitWidth;
        }
        g.drawLine(grid, y-100, grid, y+100);
        
        NRZI nrzi = new NRZI(180);
        nrzi.encode(g, data);
        
        NRZL nrzl = new NRZL(280);
        nrzl.encode(g, data);
        
        RZ rz = new RZ(380);
        rz.encode(g, data);
        
        ManchesterEncoder me = new ManchesterEncoder(480);
        me.encode(g, data);
        
        DifferentialManchesterEncoder dme = new DifferentialManchesterEncoder(580);
        dme.encode(g, data);
        
        AMI ami = new AMI(680);
        ami.encode(g,data);
        
        Pseudoternary pt = new Pseudoternary(780);
        pt.encode(g, data);
        
        
    }
}
