package graph;

// Eine ungeordnete Nachbarschaftsmatrix.  Dieser Aufbau einer
// Nachbarschaftsmatrix macht keine Verdopplungen. Es gibt nur einmal
// eine einzelne Kante in der Matrix.
public class Nachbarschaftsmatrix {
    public boolean[][] n;

    // paare: Liste von Liste von Integer
    // betrag: Gröse der Matrix
    // List von Paare, die die Knoten einer Kante zeigen.
    // Die Knoten sind genau die Kennzeichen der Listen.
    // z.B. [[1,2],[0,1],[2,0]] eine Schleife
    public Nachbarschaftsmatrix(int[][] paare, int betrag) {
	n = new boolean[betrag][betrag];

	// Am Anfang ist die Matrix leer.
	for (int i = 0; i < betrag; i++) {
	    for (int j = 0; j < betrag; j++) {
		n[i][j] = false;
	    }
	}
	
 	// Erzeugen die Nachbarschaftsmatrix
	// und setzen die Kanten ein.
	for (int i = 0; i < paare.length; i++) {
	    int[] paar = paare[i];

	    // Pflege die Kanten in der Matrix ein.
	    n[paar[0]][paar[1]] = true;
	}
    }
}
