package sicht.graph.drei;

import java.awt.Color;
import javax.swing.JFrame;
import vektor.Zweivektor;
import vektor.Dreivektor;
import graph.Nachbarschaftsliste;
import welt.graph.Dreigraphwelt;
import sicht.graph.zwei.Zweigraphsicht;
import maler.Maler;
import sicht.Sicht;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.graph.drei.Main
*/

public class Main {

    static void beispielEins() {
	// Der Graph.
	int[][] paare = {{1,2},{2,0}};
        int betrag = 3;
        Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, betrag);

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
	Dreivektor augevektor = new Dreivektor(0,0,0);
	Dreigraphaugesicht s = new Dreigraphaugesicht(dgw, augevektor, brennweite,
						      breite, hoehe);
	Maler m = new Maler(new Sicht[] {s});
  
        // Stellen die Daten dar.
        JFrame frame = new JFrame();
	frame.getContentPane().setBackground(Color.BLACK);
        frame.getContentPane().setForeground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 600);
        frame.add(m);
        frame.setVisible(true);
    }

    public static void main(String[] args){
	beispielEins();
    }
}
