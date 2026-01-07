package sicht.zweigraph;

import javax.swing.JFrame;
import graph.Nachbarschaftsliste;
import welt.zweigraph.Zweigraphwelt;
import welt.zweigraph.gitter.Zweigitter;
import punkt.Zweipunkt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes sicht.zweigraph.Main
*/

public class Main {

    public static void main(String[] args){

	// Baue einen Graph auf. Wir benutzen eine Nachbarschaftsliste.
	int[][] paare = {{1,2},{2,0}};
	int betrag = 3;
	Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, 3);

	// Bauen wir die Gitter auf.  Jede Zeile wird zwei Knoten
	// besitzen. Jeder Knoten wird 100 voneinander getrennt.
	Zweipunkt[] orten = Zweigitter.machen(nl, 2, 100);

	// Sammeln wir die Orten und den Graphen zusammen.
	Zweigraphwelt gw = new Zweigraphwelt(nl, orten);

	// Geben wir die Orten und den Graph zur Sicht.
	Zweigraphsicht gs = new Zweigraphsicht(gw);

	// Stellen die Daten dar.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	frame.add(gs);
	frame.setVisible(true);
    }
}

