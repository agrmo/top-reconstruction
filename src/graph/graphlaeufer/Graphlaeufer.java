package graph.graphlaeufer;

import java.util.ArrayList;
import java.util.Arrays;
import graph.Nachbarschaftsliste;
import graph.Nachbarschaftsmatrix;
import liste.Liste;

public class Graphlaeufer {

    public Graphlaeufer() {
	
    }

    // Ist die Kante von v bis b (oder umgekehrt) im Graph?
    public boolean hatKante(Nachbarschaftsliste n, int v, int b) {
	return n.n.get(v).contains(b) || n.n.get(b).contains(v);
    }

    // Ist die Kante von v bis b (oder umgekehrt) im Graph?
    public boolean hatKante(Nachbarschaftsmatrix n, int v, int b) {
	return n.n[v][b] || n.n[b][v];
    }

    // Mache einen Kurve, der die Anzahlverteilung der Kanten
    // im Graphen zeigt.
    // ein: Nachbarschaftsliste
    // aus: int[][]. Erstes Zeichen ist die Anzahl der Kante. Zweites zeichen
    // ist die Anzahl der Knoten.
    // z.B.
    // [[0,0],[1,5],[2,10],[3,7],[4,3],[5,1]]
    // Keine Knote hat keine Kante. 5 Knoten besitzen eine Kante, usw. Kein
    // Knoten besitzt 6 Kanten.
    // z.B.
    // [[0,1],[1,8],[2,5],[3,2],[4,1]]
    // Diese Liste zeigt, daß es keinen Knoten ohne Kante gibt.
    // Es gibt 8 Knoten, die eine Kante besitzen, usw.    
    public int[][] kanteVerteilung(Nachbarschaftsliste nl) {

	// Gedanke:
	// 1. Zähle die Anzahl von Knoten aus, die keine Kante besitzen.
	// 2. Zähle die Anzahl von Knoten aus, die eine Kante besitzen.
	// 3. ...bis die Knoten, die die meisten Kante besitzen.

	// Nehmen wir an, daß die Nachbarschaftsliste ist ohne
	// Verdopplung aufgebaut. Ein Knoten kann Kante besitzen, die
	// in der Nachbarschaftsliste unmittelbar bezeichnet sind. z.B.
	// 0: [1]
	// 1: []
	
	// Der Knoten 1 besitzt eine Kante, aber sie ist nicht in der
	// Nachbarschaftsliste unmittelbar bezeichnet.  Die einfachste
	// Lösung dafür ist genau die Nachbarschaftsliste ja zu
	// verdoppeln, sodaß jeder Knoten zeigt unmittelbar alle seine
	// Kante.

	nl.verdoppeln();

	// Eine Liste der Abzählung der Kante.
	ArrayList<int[]> kanteVerteilung = new ArrayList<int[]>();

	Liste l = new Liste();
	
	return l.nehmeArrayListArrayInteger(kanteVerteilung);
    }

    // Mache einen Kurve, der die Wahrscheinlichkeitsverteilung der
    // Kanten im Graphen zeigt.
    // public int[][] kanteVerteilung(Nachbarschaftsmatrix nl) {
	
    //    }    
}
