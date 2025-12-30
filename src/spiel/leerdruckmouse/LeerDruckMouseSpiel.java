package spiel.leerdruckmouse;

import javax.swing.JFrame;
import handlung.DruckMouseHandlung;
import handlung.Handlung;

// Ein Spiel mit der Mouse ohne Darstellungen.
public class LeerDruckMouseSpiel {

    public LeerDruckMouseSpiel() {
	
    }

    public void spielen(DruckMouseHandlung h) {
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);

	frame.addMouseListener(h);

	frame.setVisible(true);	
    }
}
