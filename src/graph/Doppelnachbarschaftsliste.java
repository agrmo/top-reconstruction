package graph;

import java.util.ArrayList;

// Am Anfang ist jede Kante nicht verdoppelt. z.B.,
// 0: [1]
// 1: []
//
// Dieser Graph besitzt eine Kante, und diese Kante ist nur einmal in
// der Liste bezeichnet. Doch besitzt der Knoten 1 eine
// Kante. Manchmal wollen wir alle Kanten unmittelbar in ihrer Liste
// gezeigt zu sein.
//
// z.B. ein:
// 0: [1]
// 1: []
// aus:
// 0: [1]
// 1: [0]
// Bauen wir solchen Graphen auf.
public class Doppelnachbarschaftsliste extends Nachbarschaftsliste {

    public Doppelnachbarschaftsliste(Nachbarschaftsliste nEin) {
	this.betrag = nEin.betrag;

	// Achtung: Wir addieren einen Zeiger! Wir nehmen an, daß
	// der ursprüngliche Graph nEin nicht mehr bearbeitet
	// wird.
	this.n = nEin.n;

	// this.n ist genau gleich wie der eingehende Graph. Nun
	// verdoppeln jede Kante. 
	
	for (int i = 0; i < n.size(); i++) {
	    ArrayList<Integer> knoten = n.get(i);

	    // Für keden Knoten, setzen seine Kanten in den anderen
	    // Knoten ein. 
	    for (int j = 0; j < knoten.size(); j++) {
		if (!n.get(knoten.get(j)).contains(i)) {
		    n.get(knoten.get(j)).add(i);
		} else {
		    System.out.println("???");
		}
	    }
	}
    }
}
