package handlung.vieleck;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import maler.Maler;
import sicht.Sicht;
import sicht.vieleck.Vielecksicht;
import vektor.Zweivektor;
import vieleck.Vieleck;
import vieleck.dreieck.Dreieck;
import welt.vieleck.Vieleckwelt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes handlung.vieleck.Main
*/

public class Main {
    public static void main(String[] args) {
	
	// Mache die Welt.
	Dreieck d = new Dreieck(50);
	ArrayList<Vieleck> fl = new ArrayList<Vieleck>();
	fl.add(d);
	Zweivektor p = new Zweivektor(100,100);
	ArrayList<Zweivektor> ol = new ArrayList<Zweivektor>();
	ol.add(p);
	Vieleckwelt welt = new Vieleckwelt(fl, ol);
	
	// Mache die Sicht.
	Vielecksicht sicht = new Vielecksicht(welt);
	Maler m = new Maler(new Sicht[] {sicht});
	
	// Mache die Handlung.
	Vieleckhandlung h = new Vieleckhandlung(m, welt);

	// Stelle die Daten dar.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	frame.getContentPane().setBackground(Color.BLACK);
	frame.getContentPane().setForeground(Color.WHITE);
	frame.add(m);
	frame.addKeyListener(h);
	frame.addMouseListener(h);
	frame.addMouseMotionListener(h);
	frame.setVisible(true);	
    }
}
