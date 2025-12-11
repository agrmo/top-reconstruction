package graph.rechnen.tiefensuche;

import graph.Nachbarschaftsliste;
import java.util.ArrayList;
import java.util.HashSet;
import liste.Liste;

public class Tiefensuche  {
    public Tiefensuche() {
	
    }

    // Die Nachbarschaftsliste muss verdoppelt sein.
    public int[] tiefensuche(Nachbarschaftsliste nl, int anfangsKnoten) {

	HashSet<Integer> gesehen = new HashSet<Integer>();

	ArrayList<Integer> nichtGesehen = new ArrayList<Integer>();

	// Anfang
	nichtGesehen.add(anfangsKnoten);

	while (nichtGesehen.size() > 0) {
	    int naechste = nichtGesehen.remove(0);
	    gesehen.add(naechste);
	    ArrayList<Integer> nachbarn = nl.n.get(naechste);
	    for (int nachbar : nachbarn) {
		if (!gesehen.contains(nachbar)) {
		    nichtGesehen.add(nachbar);
		}
	    }
	}

	Liste l = new Liste();
	return l.nehmeArrayVonMenge(gesehen);
    }
}
