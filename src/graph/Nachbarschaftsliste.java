package graph;

import java.util.List;
import java.util.ArrayList;

// Ein ungerichteter ungewichteter Graph. 
//
// Der Graph besitzt n Knoten und am höchstens (1/2)N(N-1) Kanten.
//
// Wichtige Regel: Die Knoten sind immer als eine ganze Zahl. Die
// Kennzeichen der Knoten sind 0 bis Größe - 1. Deshalb jede Liste von
// Nachbarn ist immer eine Liste von ganzen Zahlen von 0 bis Größe -
// 1.
//
// Die Durchführung dieses Graphen ist eine Nachbarschaftsliste.
//
// Ein Knoten ist eine ganze Zahl.
// Eine Kantenliste ist eine Liste von Knoten.
// Ein Graph ist eine Liste von Kantenliste.
// 
// Eine ungerichtete Nachbarschaftsliste.
public class Nachbarschaftsliste {

    /*
      Die Daten der Nachbarschaftsliste. 

      Beispiel:
      paare: [[1,2],[0,2],[0,1]]

      Bildet die Nachbarschaftsliste:
      0: [1]
      1: [2]
      2: [0]

      in Form von

      [[1],[2],[0]]

      d.h., der Index der Liste zeigt den Namen des Knoten.
    */
    public ArrayList<ArrayList<Integer>> n;

    // Die Anzahl der Knoten.
    public int betrag;

    /*
      paare: Liste von Liste von Integer
      
      List von Paare, die die Knoten einer Kante zeigen.Die Knoten
      sind genau die Kennzeichen der Listen.  z.B. [[1,2],[0,1],[2,0]]
      ist eine Schleife.
      
      Nehmen wir an, daß jede Kante is nur einmal in Paare gegeben,
      z.B. nur [1,2] und nicht beide [1,2] und [2,1].
      
      paare konnte trotzdem Verdopplungen besitzen. Daß wäre ein
      Fehler des Benutzers. (Ich sollte um diesen Fall kümmern. Wie
      konnte ich bestätigen, daß der Graph keine Verdopplung trägt,
      ohne Zweifel?)
      
      inBetrag: ganze Zahl

      Die Anzahl der Knoten in diesem Graph. Wir müssen den Betrag
      bestimmt einnehmen, weil es Knoten ohne Kanten geben konnte.
    */
    
    public Nachbarschaftsliste() {
	// Nur benutzt, um Kinder zu machen.
    }
    
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
}
