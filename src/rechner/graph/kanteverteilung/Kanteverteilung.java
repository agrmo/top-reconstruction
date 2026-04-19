package rechner.graph.kanteverteilung;

import liste.Liste;
import graph.Nachbarschaftsliste;
import graph.Doppelnachbarschaftsliste;
import java.util.HashMap;
import java.util.ArrayList;

// Mache die Anzahlverteilung der Kanten im Graphen.
public class Kanteverteilung {

    // ein: Nachbarschaftsliste
    // aus: int[][]. Erstes Zeichen ist die Anzahl der Kante. Zweites zeichen
    // ist die Anzahl der Knoten.

    // Beispiel
    // [[0,0],[1,5],[2,10],[3,7],[4,3],[5,1]]
    // Keine Knote hat keine Kante. 5 Knoten besitzen eine Kante, usw. Kein
    // Knoten besitzt 6 Kanten.
    
    // Beispiel
    // [[0,1],[1,8],[2,5],[3,2],[4,1]]
    // Diese Liste zeigt, daß es keinen Knoten ohne Kante gibt.
    // Es gibt 8 Knoten, die eine Kante besitzen, usw.
    
    public static int[][] kanteVerteilung(Nachbarschaftsliste nl) {

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

	Doppelnachbarschaftsliste dnl = new Doppelnachbarschaftsliste(nl);
	
	// Eine Map der Abzählung der Kante.
	// z.B.
	// 0: 1
	// 2: 5
	// Es gibt 5 Knoten mit 2 Kanten. Fänden wir einen neuen Knoten
	// mit 2 Kanten, dann erhöhen das Zeichen von 2.
	// 0: 1
	// 2: 6
	// Es gibt 6 Knoten mit 2 Kanten.
	HashMap<Integer,Integer> kv = new HashMap<Integer,Integer>();

	// Jeder Knoten in der Nachbarschaftsliste hat schon alle
	// seine Kante gerade gezeigt. Also wir müssen nur den Betrag
	// der Liste aufzählen.

	for (int i = 0; i < dnl.n.size(); i++) {
	    ArrayList<Integer> knoten = dnl.n.get(i);
	    int betrag = knoten.size();

	    if (kv.containsKey(betrag)) {
		// Es gibt einen anderen Knoten mit die gleiche Anzahl
		// von Kante. Erhöhen die Zahl.
		int anzahl = kv.get(betrag);
		anzahl++;
		kv.put(betrag, anzahl);		
	    } else {
		// Dieser Knoten ist der erste Knoten mit betrag-Zahl
		// von Kanten.
		kv.put(betrag, 1);
	    }
	}

	// Schon fertig, aber wir wollen eine int[][] zeigen, nicht
	// eine Abbildung von int bis int.

	int[][] intkv = Liste.nehmeArrayArrayVonAbbildung(kv);

	return intkv;
    }
}
