package graph;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
  Ein Knoten ist eine ganze Zahl.
  Eine Kantenliste ist eine Liste von Knoten.
  Ein Graph ist eine Liste von Kantenliste.
 */

// Eine ungerichtete Nachbarschaftsliste.
public class Nachbarschaftsliste {
    public ArrayList<ArrayList<Integer>> n;
    public int betrag;

    // paare: Liste von Liste von Integer
    // List von Paare, die die Knoten einer Kante zeigen.
    
    // Die Knoten sind genau die Kennzeichen der Listen.
    // z.B. [[1,2],[0,1],[2,0]] eine Schleife.

    // Nehmen wir an, daß jede Kante is nur einmal in paare gegeben,
    // z.B. nur [1,2] und nicht beide [1,2] und [2,1].

    // "paare" konnte trotzdem Verdopplungen besitzen. Daß wäre ein
    // Fehler des Benutzers. (Ich sollte um diesen Fall kümmern. Wie
    // konnte ich bestätigen, daß der Graph keine Verdopplung trägt,
    // ohne Zweifel?)
    
    // inBetrag: ganze Zahl
    // Die Anzahl der Knoten in diesem Graph.
    public Nachbarschaftsliste(int[][] paare, int inBetrag) {
	betrag = inBetrag;
	
	// Am Anfang gibt es keine Kante.  Erzeugen die
	// Nachbarschaftsliste mit Größe "inBetrag" und erzeugen eine
	// leere Liste dahin.
	n = new ArrayList<ArrayList<Integer>>();

	// Für jede Knote, mach eine leere Liste für die Kanten.
	for (int i = 0; i < inBetrag; i++) {
	    n.add(new ArrayList<Integer>());
	}
	
 	// Setzen die Kanten ein.
	for (int i = 0; i < paare.length; i++) {
	    // Kante von Knoten bis Knoten
	    int[] paar = paare[i];
	    n.get(paar[0]).add(paar[1]);
	}
    }

    // Am Anfang ist jede Nachbarschaftsliste nicht verdoppelt. z.B.,
    // 0: [1]
    // 1: []
    // Dieser Graph besitzt eine Kante, und diese Kante ist nur einmal
    // in der Liste bezeichnet. Doch hat der Knoten 1 eine Kante. Manchmal
    // wollen wir alle die Kante unmittelbar in der Liste gezeigt zu sein.
    // z.B. ein:
    // 0: [1]
    // 1: []
    // aus:
    // 0: [1]
    // 1: [0]
    // Tun wir das.
    public void verdoppeln() {
	for (int i = 0; i < n.size(); i++) {
	    ArrayList<Integer> knoten = n.get(i);

	    // Für keden Knoten, setzen seine Kanten in den anderen
	    // Knoten ein. 
	    for (int j = 0; j < knoten.size(); j++) {
		// Wir kennen nicht, ob diese Kante die ursprüngliche
		// Kante ist, also prüfe ob die Kante schon im Knoten
		// steht.
		if (!n.get(knoten.get(j)).contains(i)) {
		    n.get(knoten.get(j)).add(i);
		}
	    }
	}
    }
}
