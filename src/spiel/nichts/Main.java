package spiel.nichts;

import handlung.spiel.SpielHandlung;
import java.util.ArrayList;
import javax.swing.JFrame;
import koerper.kubus.Kubus;
import punkt.Dreipunkt;
import koerper.Koerper;
import sicht.koerper.parallel.Parallelsicht;
import spiel.Spiel;
import welt.koerper.Koerperwelt;
import maler.Maler;
import sicht.Sicht;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes spiel.nichts.Main
*/

public class Main {

    static void beispielEins() {
	// Das Spiel nimmt Ereignissen von der Handlung ein.
	Nichtsspiel s = new Nichtsspiel();

	// Die Handlungen werden das Spiel anrufen.
	SpielHandlung sh = new SpielHandlung(s);

	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	frame.addMouseListener(sh);
	frame.addMouseMotionListener(sh);
	frame.addKeyListener(sh);
	frame.setVisible(true);
    }

    static void beispielZwei() {
	// Mache die Welt.
	Kubus k = new Kubus(50);
	Dreipunkt p = new Dreipunkt(100, 100, 100);
	ArrayList<Koerper> kl = new ArrayList<Koerper>();
	kl.add(k);
	ArrayList<Dreipunkt> ol = new ArrayList<Dreipunkt>();
	ol.add(p);
	Koerperwelt kw = new Koerperwelt(kl, ol);

	// Mache die Sicht.
	Parallelsicht ps = new Parallelsicht(kw);
	Maler m = new Maler(new Sicht[] {ps});

	// Mache das Spiel.
	Spiel s = new Nichtsspiel();

	// Mache die Handlungen.
	SpielHandlung sh = new SpielHandlung(s);

	// Stelle die Daten dar.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	frame.add(m);
	frame.addMouseListener(sh);
	frame.addMouseMotionListener(sh);
	frame.addKeyListener(sh);
	frame.setVisible(true);	
    }
    
    public static void main(String[] args) {
	beispielEins();
    }
}
