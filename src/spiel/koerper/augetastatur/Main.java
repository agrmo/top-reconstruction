package spiel.koerper.augetastatur;

import handlung.spiel.SpielHandlung;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import koerper.Koerper;
import koerper.kubus.Kubus;
import punkt.Dreipunkt;
import sicht.auge.Augesicht;
import welt.koerper.Koerperwelt;
import java.awt.Toolkit;
import java.awt.Dimension;
import sicht.Sicht;
import maler.Maler;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes spiel.koerper.augetastatur.Main
*/

public class Main {
    public static void main(String[] args) {
	
	// Mache die Welt.
	ArrayList<Koerper> kl = new ArrayList<Koerper>();
	kl.add(new Kubus(60));
	ArrayList<Dreipunkt> ol = new ArrayList<Dreipunkt>();
	ol.add(new Dreipunkt(-30,-30,-30));
	Koerperwelt kw = new Koerperwelt(kl, ol);
	
	// Mache die Sicht.
	Dimension bildschirm = Toolkit.getDefaultToolkit().getScreenSize();
	int breite = (int) bildschirm.getWidth();
	int hoehe = (int) bildschirm.getHeight();
	Dreipunkt ap = new Dreipunkt(0, 0, 100);
	Augesicht as = new Augesicht(kw, ap, 500, breite, hoehe, 0.0, 0.0, 0.0);
	Maler m = new Maler(new Sicht[] {as});
	
	// Mache das Spiel.
	Augetastaturspiel s = new Augetastaturspiel(m, as, kw);

	// Mache die Handlung.
	SpielHandlung sh = new SpielHandlung(s);

	// Geh.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setBackground(Color.BLACK);
	frame.getContentPane().setForeground(Color.WHITE);
	frame.setSize(breite, hoehe);
	frame.add(m);
	frame.addKeyListener(sh);
	frame.setVisible(true);	
    }
}
