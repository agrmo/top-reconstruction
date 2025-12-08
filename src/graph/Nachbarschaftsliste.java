package graph;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
  Ein Knoten ist eine ganze Zahl.
  Eine Kantenliste ist eine Liste von Knoten.
  Ein Graph ist eine Liste von Kantenliste.
 */

// Eine ungerichtete Nachbarschaftsliste.  Nehmen wir an, daß jede
// Kante ist nur einmal im Graph angegeben, also nicht zweimal. Also
// wir müssen zweimal prüfen - einmal auf einem Knoten und einmal auf
// dem anderen - ob eine Kante im Graph gibt.
public class Nachbarschaftsliste implements Graph {
    public ArrayList<ArrayList<Integer>> n;

    // paare: Liste von Liste von Integer
    // List von Paare, die die Knoten einer Kante zeigen.
    
    // Die Knoten sind genau die Kennzeichen der Listen.
    // z.B. [[1,2],[0,1],[2,0]] eine Schleife.

    // Nehmen wir an, daß jede Kante is nur einmal in paare gegeben,
    // z.B. nur [1,2] und nicht beide [1,2] und [2,1].
    
    // groese: ganze Zahl
    // Die Anzahl der Knoten in diesem Graph.
    public Nachbarschaftsliste(int[][] paare, int groese) {
	
	// Am Anfang gibt es keine Kante.  Erzeugen die
	// Nachbarschaftsliste mit Größe "groese" und erzeugen eine
	// leere Liste dahin.
	n = new ArrayList<ArrayList<Integer>>();

	// Für jede Knote, mach eine leere Liste für die Kanten.
	for (int i = 0; i < groese; i++) {
	    n.add(new ArrayList<Integer>());
	}
	
 	// Setzen die Kanten ein.
	for (int i = 0; i < paare.length; i++) {
	    // Kante von Knoten bis Knoten
	    int[] paar = paare[i];
	    n.get(paar[0]).add(paar[1]);
	}
    }

    // Ist die Kante von v bis b (oder umgekehrt) im Graph?
    public boolean hatKante(int v, int b) {
	return n.get(v).contains(b) || n.get(b).contains(v);
    }
}
