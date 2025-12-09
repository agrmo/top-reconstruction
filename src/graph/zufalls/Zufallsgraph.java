package graph.zufalls;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

// Ein Zuafallsgraph ist eine Art Graph mit n Knoten, bei denen die
// Kanten zufällig erzeugt werden. Gegeben die Anzahl von Knoten und
// die Wahrscheinlichkeit p, jedes Paar von Knoten eine Kante zu
// tragen.
public class Zufallsgraph {

    // n: Anzahl von Knoten
    // Nehme alle Paare von Knoten.  Ein ungerichteter Graph besitzt
    // am höchstens (1/2)n(n-1)-mal Kante, die zwei Knoten verbinden
    // werden. Komplexität: (1/2)*n*(n-1).
    // Es wäre schneller, wenn wir nur die Paare nehmen, die ja ein
    // Paar gewürfelt sind. Trotzdem nehmen wir alle Paare und nun
    // danach würfeln die Wahrscheinlichkeit, weil es ein bißchen
    // einfacher zu verstehen ist.
    // z.B.
    // Die Zahl n ergibt die liste von Paaren:
    // [[0,1],[0,2],[1,2]]
    private ArrayList<int[]> nehmeAllePaare(int n) {

	// Wir kennen schon die Größe eines Paars: 2.  Aber wir kennen
	// nicht schon die Anzahl der Paare, also wir brauchen ein
	// ArrayList der Paare.
	ArrayList<int[]> paare = new ArrayList<int[]>(n);
	
	for (int i = 0; i < n; i++) {
	    for (int j = i; j < n; j++) {
		if (i != j) {
		    paare.add(new int[] {i,j});
		}
	    }
	}
	
	return paare;
    }

    // n: ganze Zahl
    // p: double
    // n ist die Anzahl von Knoten.
    
    // p ist die Wahrscheinlichkeit, daß je ein Paar von Knoten eine
    // Kante trägt. Sobald das Object erzeugt wird, bauen den Graph
    // auf.

    public Zufallsgraph(int n, double p) {
	ArrayList<int[]> paare = nehmeAllePaare(n);
    }
}
