package encode_scheme;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * 
 * @author Dr. Sunirmal Khatua
 *
 */
public  class EncoderFactory {
	
	public static void encode(Graphics2D g, String scheme, String data) {
		g.setBackground(Color.WHITE);
		g.clearRect(0, 0, 800, 1000);
		createEncoder(scheme).encode(g, data);
	}
	
	
	public static Encoder createEncoder(String scheme) {
		if(scheme.equals("Manchester")) {
			return new ManchesterEncoder(180);
		}else if(scheme.equals("Differential Manchester")) {
			return new DifferentialManchesterEncoder(180);
		} else if (scheme.equals("NRZ-L")) {
			return new NRZL(180);
		} else if (scheme.equals("NRZ-I")) {
			return new NRZI(180);
		} else if (scheme.equals("RZ")) {
			return new RZ(180);
		} else if (scheme.equals("AMI")) {
			return new AMI(180);
		} else if (scheme.equals("Pseudoternary")) {
			return new Pseudoternary(180);
		} else if (scheme.equals("All")) {
			return new ALL();
		} else {
			return null;//TO BE DONE for OTHER SCHEMES....
		}
	}
	
	

}
