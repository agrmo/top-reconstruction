package welt.zweigraph;

import graph.Nachbarschaftsliste;
import graph.Nachbarschaftsliste;
import java.util.ArrayList;
import javax.swing.JFrame;
import punkt.Zweipunkt;
import java.awt.Color;
import sicht.strecke.Streckesicht;
import sicht.zweipunkt.Punktsicht;
import strecke.Zweistrecke;
import welt.zweigraph.Zweigraphwelt;
import welt.zweigraph.gitter.Zweigitter;
import welt.zweistrecke.Zweistreckewelt;
import maler.Maler;
import sicht.Sicht;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes welt.zweigraph.Main
*/

public class Main {

    static void beispielZwei() {
	int[][] paare = {{1,2},{2,0}};
        int betrag = 3;
        Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, 3);
  
        // Bauen wir die Gitter auf.  Jede Zeile wird zwei Knoten
        // besitzen. Jeder Knoten wird 100 voneinander getrennt.
        Zweipunkt[] orten = Zweigitter.machen(nl, 2, 100);
  
        // Sammeln wir die Orten und den Graphen zusammen.
        Zweigraphwelt gw = new Zweigraphwelt(nl, orten);
  
        // Nehme die Kanten.
	Zweistrecke[] kanten = gw.nehmeKanten();
	Zweistreckewelt sw = new Zweistreckewelt(kanten);

	// Nehme die Knoten.
	int radius = 10;
	Zweipunkt[] knoten = gw.nehmeKnoten(radius);

	// // Mache den Maler.
	// Streckesicht ss = new Streckesicht(sw);
	// Punktsicht ps = new Punktsicht(knoten, radius);
	// Maler m = new Maler(new Sicht[] {ss, ps});
  
        // // Stellen die Daten dar.
        // JFrame frame = new JFrame();
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setSize(1200, 600);
        // frame.add(m);
        // frame.setVisible(true);
    }
    
    public static void main(String[] args) {
	beispielZwei();
    }    
}
