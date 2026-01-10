package spiel.vieleck;

import handlung.spiel.SpielHandlung;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import maler.Maler;
import punkt.Zweipunkt;
import sicht.Sicht;
import sicht.vieleck.Vielecksicht;
import vieleck.Vieleck;
import vieleck.dreieck.Dreieck;
import welt.vieleck.Vieleckwelt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes spiel.vieleck.Main
*/

public class Main {
    public static void main(String[] args) {
	
	// Mache die Welt.
	Dreieck d = new Dreieck(50);
	ArrayList<Vieleck> fl = new ArrayList<Vieleck>();
	fl.add(d);
	Zweipunkt p = new Zweipunkt(100,100);
	ArrayList<Zweipunkt> ol = new ArrayList<Zweipunkt>();
	ol.add(p);
	Vieleckwelt fw = new Vieleckwelt(fl, ol);
	
	// Mache die Sicht.
	Vielecksicht fs = new Vielecksicht(fw);
	Maler m = new Maler(new Sicht[] {fs});
	
	// Mache das Spiel.
	Vieleckspiel s = new Vieleckspiel(m, fw);

	// Mache die Handlungen.
	SpielHandlung sh = new SpielHandlung(s);

	// Geh.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	frame.getContentPane().setBackground(Color.BLACK);
	frame.getContentPane().setForeground(Color.WHITE);
	frame.add(m);
	frame.addKeyListener(sh);
	frame.addMouseListener(sh);
	frame.addMouseMotionListener(sh);
	frame.setVisible(true);	
    }
}
