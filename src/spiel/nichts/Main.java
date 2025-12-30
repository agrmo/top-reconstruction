package spiel.nichts;

import handlung.spiel.SpielMouseHandlung;
import handlung.spiel.SpielTastaturHandlung;
import java.util.ArrayList;
import javax.swing.JFrame;
import koerper.kubus.Kubus;
import punkt.Dreipunkt;
import punktkoerper.Punktkoerper;
import punktkoerper.kubus.Punktkubus;
import sicht.parallel.Parallelsicht;
import spiel.Spiel;
import welt.punktkoerper.Punktkoerperwelt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes spiel.nichts.Main
*/

public class Main {

    static void beispielEins() {
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);

	// Das Spiel nimmt Ereignissen von der Handlung ein.
	Nichtsspiel s = new Nichtsspiel();

	// Die Handlungen werden das Spiel anrufen.
	SpielMouseHandlung mh = new SpielMouseHandlung(s);
	SpielTastaturHandlung th = new SpielTastaturHandlung(s);

	frame.addMouseListener(mh);
	frame.addKeyListener(th);
	
	frame.setVisible(true);
    }

    static void beispielZwei() {
	// Mache die Welt.
	Kubus k = new Kubus(50);
	Dreipunkt p = new Dreipunkt(100, 100, 100);
	Punktkubus pk = new Punktkubus(k, p);
	ArrayList<Punktkoerper> pkl = new ArrayList<Punktkoerper>();
	pkl.add(pk);
	Punktkoerperwelt pkw = new Punktkoerperwelt(pkl);

	// Mache die Sicht.
	Parallelsicht ps = new Parallelsicht(pkw);

	// Mache das Spiel.
	Spiel s = new Nichtsspiel();

	// Mache die Handlungen.
	SpielMouseHandlung mh = new SpielMouseHandlung(s);
	SpielTastaturHandlung th = new SpielTastaturHandlung(s);

	// Geh.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	frame.add(ps);
	frame.addMouseListener(mh);
	frame.addKeyListener(th);
	frame.setVisible(true);	
    }
    
    public static void main(String[] args) {
	beispielZwei();
    }
}
