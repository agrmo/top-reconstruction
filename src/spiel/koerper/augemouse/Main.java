package spiel.koerper.augemouse;

import handlung.spiel.SpielHandlung;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JFrame;
import koerper.Koerper;
import koerper.kubus.Kubus;
import maler.Maler;
import punkt.Dreipunkt;
import punkt.Zweipunkt;
import sicht.Sicht;
import sicht.auge.Augesicht;
import sicht.text.Textsicht;
import sicht.text.augetext.Augetextsicht;
import welt.koerper.Koerperwelt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes spiel.koerper.augemouse.Main
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

	Augetextsicht ats = new Augetextsicht(as);
	Maler m = new Maler(new Sicht[] {as, ats});
	
	// Mache das Spiel.
	Augemousespiel s = new Augemousespiel(m, as, kw);

	// Mache die Handlung.
	SpielHandlung sh = new SpielHandlung(s);

	// Geh.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setBackground(Color.BLACK);
	frame.getContentPane().setForeground(Color.WHITE);
	frame.setSize(breite, hoehe);
	frame.add(m);
	frame.addMouseListener(sh);
	frame.addMouseMotionListener(sh);
	frame.setVisible(true);	
    }
}
