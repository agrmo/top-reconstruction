package welt.graph.gitter;

import java.util.Random;
import vektor.Zweivektor;
import graph.Nachbarschaftsliste;
import vektor.Zweivektor;
import welt.graph.Zweigraphwelt;
import druck.vektor.Vektordrucker;

/*
  Ein Gitter ist eine Art von Graphen, die wie ein Gitter aussieht.

  Wir sollen nicht nur den Graphen und seine Kanten bauen, sondern
  auch natürlich die Stelle der Knoten. Lassen wir zwei Funktionen
  dafür machen: eine für den Graphen und eine für die Stellen.

  Hier haben wir drei wichtige Funktionen:
  1. Eine Funktion, die den Graph baut.
  2. Eine Funktion, die die Orte des Graphen baut.
  3. Eine Funktion, die die Welt solches Gitter baut.
  
*/  
public class Zweigitter {

    // static int nehmeknotenanzahl()
    // ... Einfach nur xknoten * yknoten ...

    // Ein bißchen komplizierter,
    static int nehmekantenanzahl(int xknoten, int yknoten) {
	// Sobald wir die Anzahl der Knoten in die x-Richtung und die
	// Anzahl der Knoten in die y-Richtung kennen, kennen wir ganz
	// einfach, wie viele Kanten es in eines zweidimensionalen
	// Gitters geben würde.
	//
	// Beispiel
	//
	// k - k - k
	// |   |   |
	// k - k - k
	//
	// und so weiter.
	//
	//                 Kanten nach rechts        Kanten nach oben          
	int kantenanzahl = yknoten * (xknoten - 1) + xknoten * (yknoten - 1);

	return kantenanzahl;
    }

    // Mache einen zweidimensionalen Graphen für ein neues Gitter.
    static Nachbarschaftsliste machegraph(int xknoten, int yknoten) {

	// Der Platz an der x-Achse und y-Achse.
	int xindex = 0;
	int yindex = 0;

	int kantenanzahl = Zweigitter.nehmekantenanzahl(xknoten, yknoten);
	int inBetrag = xknoten * yknoten;
	int[][] paare = new int[kantenanzahl][2];
	int paareindex = 0;

	/*
	  Gedanke:
	  1. Baue die Kanten nach rechts

	     k k k    k-k-k
	     
	     k k k -> k-k-k
	     
	     k k k    k-k-k

	  2. Baue die Kanten nach oben

	     k-k-k    k-k-k
	     	      | | |   
	     k-k-k -> k-k-k 
	     	      | | |    
	     k-k-k    k-k-k

	  3. Fertig
	*/

	// 1.
	for (int i = 0; i < yknoten; i++) {
	    for (int j = 0; j < xknoten - 1; j++) {

		// Baue eine Kante nach rechts.
		int knotenvon = (xknoten * i) + j;
		int knotenbis = knotenvon + 1;

		/*
		  z.B. am Anfang
		  
		  k k k k    k k k k
		          ->        
		  k k k k    k-k k k
		  
		*/
		
		int[] paar = new int[] {knotenvon, knotenbis};
		paare[paareindex] = paar;
		paareindex += 1;
	    }
	}

	// 2.
	for (int i = 0; i < yknoten - 1; i++) {
	    for (int j = 0; j < xknoten; j++) {
		
		// Baue eine Kante nach oben.
		int knotenvon = (xknoten * i) + j;
		int knotenbis = knotenvon + xknoten;

		/*
		  z.B. am Anfang
		  
		  k k k k    k k k k
		          -> |       
		  k k k k    k k k k
		  
		*/
		
		int[] paar = new int[] {knotenvon, knotenbis};
		paare[paareindex] = paar;
		paareindex += 1;
	    }
	}

	Nachbarschaftsliste graph = new Nachbarschaftsliste(paare, inBetrag);

	return graph;
    }
    
    // Berechne die zweidimensionalen Orte jedes Knoten. Diese
    // Funktion baut die Stellen gleich wie der Graph in machegraph()
    // gebaut würde. D.h., orte[0] ist die Stelle des ersten Knoten 0.
    static Zweivektor[] macheorte(int xknoten, int yknoten, int weg) {

	Zweivektor[] orte = new Zweivektor[xknoten * yknoten];

	for (int i = 0; i < yknoten; i++) {
	    for (int j = 0; j < xknoten; j++) {

		int knotenindex = (i * xknoten) + j;
		orte[knotenindex] = new Zweivektor(j * weg, i * weg);
	    }
	}

	return orte;
    }

    /*
      Mache eine zweidimensionale Graphwelt, die ein Gitter enthält.
      
      xknoten: Die Anzahl von Knoten in der x-Richtung.
      yknoten: Die Anzahl von Knoten in der y-Richtung.
      weg: Der räumliche Entfernung zwischen zwei Knoten.
    */
    public static Zweigraphwelt machewelt(int xknoten, int yknoten, int weg) {

	// Der Graph kennt seine Stellen nicht. Wichtig.
	Nachbarschaftsliste graph = Zweigitter.machegraph(xknoten, yknoten);

	// Die Welt kennt die Stellen aller Knoten. Wichtig.
	Zweivektor[] orte = Zweigitter.macheorte(xknoten, yknoten, weg);

	// Nun baue die Welt.
	Zweigraphwelt zgw = new Zweigraphwelt(graph, orte);

	return zgw;
    }
}
