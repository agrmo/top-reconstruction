package spiel.leerdrucktastatur;

import javax.swing.JFrame;
import handlung.DruckTastaturHandlung;

// Ein Spiel mit der Tastatur ohne Darstellungen.
public class LeerDruckTastaturSpiel {
    DruckTastaturHandlung handlung;

    public LeerDruckTastaturSpiel(DruckTastaturHandlung h) {
	this.handlung = h;
    }

    public void spielen() {
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);

	frame.addKeyListener(this.handlung);

	frame.setVisible(true);	
    }
}
