package spiel.leerdruckmouse;

import javax.swing.JFrame;
import handlung.DruckMouseHandlung;
import handlung.Handlung;

// Ein Spiel mit der Mouse ohne Darstellungen.
public class LeerDruckMouseSpiel {
    DruckMouseHandlung handlung;

    public LeerDruckMouseSpiel(DruckMouseHandlung h) {
	this.handlung = h;
    }

    public void spielen() {
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);

	frame.addMouseListener(this.handlung);

	frame.setVisible(true);	
    }
}
