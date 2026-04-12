package handlung.graph;

import graph.Nachbarschaftsliste;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JFrame;
import maler.Maler;
import sicht.Sicht;
import sicht.graph.drei.Dreigraphaugesicht;
import vektor.Dreivektor;
import welt.graph.Dreigraphwelt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes handlung.graph.Main
*/

public class Main {
    static void beispieleins() {
	// Der Graph.
	int[][] paare = {{1,2},{2,0}};
        int betrag = 3;
        Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, 3);

	// Die Orten.
        Dreivektor[] orten = {
	    new Dreivektor(-10,20,10),
	    new Dreivektor(-20,-20,-10),
	    new Dreivektor(20,-10,10)
	};

	// Mache die Welt.
	Dreigraphwelt dgw = new Dreigraphwelt(nl, orten);

	// Mache die Sicht.
	double breite = 1200;
	double hoehe = 600;
	double brennweite = 500;
	Dreivektor augevektor = new Dreivektor(0,0,100);
	Dreigraphaugesicht ds = new Dreigraphaugesicht(dgw, augevektor, brennweite,
						       breite, hoehe);
	Maler m = new Maler(new Sicht[] {ds});
	
	// Mache die Handlung.
	Graphhandlung handlung = new Graphhandlung(m, ds, dgw);

	// Fangen die Handlung an.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setBackground(Color.BLACK);
	frame.getContentPane().setForeground(Color.WHITE);
	frame.setSize((int) breite, (int) hoehe);
	frame.add(m);
	frame.addMouseListener(handlung);
	frame.addMouseMotionListener(handlung);
	frame.setVisible(true);
    }

    public static void main(String[] args) {
	beispieleins();
    }
}
