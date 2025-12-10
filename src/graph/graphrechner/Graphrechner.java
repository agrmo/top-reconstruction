package graph.graphrechner;

import graph.Nachbarschaftsliste;
import graph.Nachbarschaftsmatrix;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import liste.Liste;

// Berechne verschiedene Eigenschaften des Graphen.
// Bearbeiten den Graph nicht.
public class Graphrechner {

    public Graphrechner() {
	
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

	for (int i = 0; i < nl.n.size(); i++) {
	    ArrayList<Integer> knoten = nl.n.get(i);
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

	Liste l = new Liste();
	int[][] intkv = l.nehmeArrayArrayVonAbbildung(kv);

	return intkv;
    }

    // Mache einen Kurve, der die Wahrscheinlichkeitsverteilung der
    // Kanten im Graphen zeigt.
    // public int[][] kanteVerteilung(Nachbarschaftsmatrix nl) {	
    //    }        

    // Berechne die durchschnittliche Anzahl der Kanten eines Knoten
    // dieses Graphen.
    // z.B. die Verteilung
    // [[1, 1],[2, 1],[3, 4],[4, 2],[5, 1],[6, 1]]
    // ergibt die Kantedurchschnitt
    // (1*1+2*1+3*4+4*2+5*1+6*1)/(1+1+4+2+1+1) = 3.4
    public double berechneKantedurchschnitt(Nachbarschaftsliste nl) {
	// Gedanke:
	// 1. Gegeben schon eine Kanteverteilung.
	// 2. Berechne die gewichtete Summe aller Kanten.
	// 3. Berechne 2 * die Anzahl von Knoten.
	// 4. Teilen sie durch.

	// Nehme die Kanteverteilung.
	int[][] kv = kanteVerteilung(nl);

	// Wir haben alle die Daten, den Durschnitt zu rechnen.
	// Nennen wir den Zähler "gewichteteSumme." Der Nenner ist die
	// gesamte Anzahl von Knoten, einschließlich die Knoten, die
	// keine Kante besitzen!
	
	double gewichteteSumme = 0;
	for (int i = 0; i < kv.length; i++) {
	    gewichteteSumme += (kv[i][0] * kv[i][1]);
	}

	int anzahlVonKnoten = nl.betrag;

	double durchschnitt = gewichteteSumme / (anzahlVonKnoten);
	
	return durchschnitt;
    }
}
