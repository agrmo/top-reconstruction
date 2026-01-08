package spiel.figur;

import figur.dreieck.Dreieck;
import handlung.spiel.SpielHandlung;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import figur.Figur;
import punkt.Zweipunkt;
import sicht.figur.Figursicht;
import welt.figur.Figurwelt;
import sicht.Sicht;
import maler.Maler;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes spiel.figur.Main
*/

public class Main {
    public static void main(String[] args) {
	
	// Mache die Welt.
	Dreieck d = new Dreieck(50);
	ArrayList<Figur> fl = new ArrayList<Figur>();
	fl.add(d);
	Zweipunkt p = new Zweipunkt(100,100);
	ArrayList<Zweipunkt> ol = new ArrayList<Zweipunkt>();
	ol.add(p);
	Figurwelt fw = new Figurwelt(fl, ol);
	
	// Mache die Sicht.
	Figursicht fs = new Figursicht(fw);
	Maler m = new Maler(new Sicht[] {fs});
	
	// Mache das Spiel.
	Figurspiel s = new Figurspiel(m, fw);

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
