package spiel.graph;

import graph.Nachbarschaftsliste;
import handlung.spiel.SpielHandlung;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JFrame;
import maler.Maler;
import sicht.Sicht;
import sicht.graph.drei.Dreigraphbasissicht;
import vektor.Dreivektor;
import welt.graph.Dreigraphwelt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes spiel.graph.Main
*/

public class Main {
    
    static void beispielEins() {
	// Der Graph.
	int[][] paare = {{1,2},{2,0}};
        int betrag = 3;
        Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, 3);

	// Die Orten.
        Dreivektor[] orten = {
	    new Dreivektor(10,10,100),
	    new Dreivektor(50,50,120),
	    new Dreivektor(100,40,150)
	};

	// Mache die Welt.
	Dreigraphwelt dgw = new Dreigraphwelt(nl, orten);

	// Mache die Sicht.
	double breite = 1200;
	double hoehe = 600;
	double brennweite = 500;
	Dreivektor augepunkt = new Dreivektor(0,0,0);
	Dreigraphbasissicht ds = new Dreigraphbasissicht(dgw, augepunkt, brennweite,
							 breite, hoehe);
	Maler m = new Maler(new Sicht[] {ds});
	
	// Mache das Spiel.
	Graphspiel gs = new Graphspiel(m, ds, dgw);

	// Mache die Handlung.
	SpielHandlung sh = new SpielHandlung(gs);

	// Geh.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setBackground(Color.BLACK);
	frame.getContentPane().setForeground(Color.WHITE);
	frame.setSize((int) breite, (int) hoehe);
	frame.add(m);
	frame.addMouseListener(sh);
	frame.addMouseMotionListener(sh);
	frame.setVisible(true);
    }
    
    public static void main(String[] args) {
	beispielEins();
    }
}
