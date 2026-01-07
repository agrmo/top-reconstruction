package graph.rechnen.kantedurchschnitt;

import graph.Nachbarschaftsliste;
import graph.Nachbarschaftsmatrix;
import graph.rechnen.kanteverteilung.Kanteverteilung;

public class Kantedurchschnitt {
    
    // Berechne die durchschnittliche Anzahl der Kanten eines Knoten
    // dieses Graphen.
    // z.B. die Verteilung
    // [[1, 1],[2, 1],[3, 4],[4, 2],[5, 1],[6, 1]]
    // ergibt die Kantedurchschnitt
    // (1*1+2*1+3*4+4*2+5*1+6*1)/(1+1+4+2+1+1) = 3.4
    public static double berechneKantedurchschnitt(Nachbarschaftsliste nl) {
	// Gedanke:
	// 1. Gegeben schon eine Kanteverteilung.
	// 2. Berechne die gewichtete Summe aller Kanten.
	// 3. Berechne 2 * die Anzahl von Knoten.
	// 4. Teilen sie durch.

	// Nehme die Kanteverteilung.
	int[][] kv = Kanteverteilung.kanteVerteilung(nl);

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
