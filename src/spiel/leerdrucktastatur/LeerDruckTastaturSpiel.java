package spiel.leerdrucktastatur;

import javax.swing.JFrame;
import handlung.DruckTastaturHandlung;

// Ein Spiel mit der Tastatur ohne Darstellungen.
public class LeerDruckTastaturSpiel {

    public LeerDruckTastaturSpiel() {
    }

    public void spielen(DruckTastaturHandlung h) {
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);

	frame.addKeyListener(h);

	frame.setVisible(true);	
    }
}
