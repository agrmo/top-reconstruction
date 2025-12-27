package sicht.graph;

import javax.swing.JFrame;
import graph.Nachbarschaftsliste;
import welt.graph.Graphwelt;
import welt.graph.macher.gitter.Gitter;

/*
  javac -d classes $(find src -name '*.java')
  java -cp classes sicht.graph.Main
*/

public class Main {

    public static void main(String[] args){
 	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);

	// Baue einen Graph auf. Wir benutzen eine Nachbarschaftsliste.
	int[][] paare = {{1,2},{2,0}};
	int betrag = 3;
	Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, 3);

	// Bereiten wir eine Gitter vor. Jede Zeile wird zwei Knoten
	// besitzen. Jeder Knoten wird 100 voneinander getrennt.
	Gitter gitter = new Gitter(2, 100);

	// Bauen wir die Gitter auf.
	int[][] orten = gitter.machen(nl);

	// Sammeln wir die Orten und den Graphen zusammen.
	Graphwelt gw = new Graphwelt(nl, orten);

	// Geben wir die Orten und den Graph zur Sicht.
	Graphsicht gs = new Graphsicht(gw);

	// Geben wir die Sicht zu Java, um darzustellen.
	frame.add(gs);
	
	frame.setVisible(true);
    }
}

