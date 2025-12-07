package graph;

// Eine ungeordnete Nachbarschaftsmatrix
public class Nachbarschaftsmatrix implements Graph {
    private boolean[][] n;

    // paare: Liste von Liste von Integer
    // groese: Gröse der Matrix
    // List von Paare, die die Knoten einer Kante zeigen.
    // Die Knoten sind genau die Kennzeichen der Listen.
    // z.B. [[1,2],[0,1],[2,0]] eine Schleife
    public Nachbarschaftsmatrix(int[][] paare, int groese) {
	n = new boolean[groese][groese];

	// Am Anfang ist die Matrix leer.
	for (int i = 0; i < groese; i++) {
	    for (int j = 0; j < groese; j++) {
		n[i][j] = false;
	    }
	}
	
 	// Erzeugen die Nachbarschaftsmatrix
	// und setzen die Kanten ein.
	for (int i = 0; i < paare.length; i++) {
	    int[] paar = paare[i];

	    // Pflege die Kanten in der Matrix ein.
	    n[paar[0]][paar[1]] = true;
	    n[paar[1]][paar[0]] = true;
	}
    }

    // Ist die Kante von v bis b (oder umgekehrt) im Graph?
    public boolean hatKante(int v, int b) {
	return n[v][b] || n[b][v];
    }

    public String drucken() {
	StringBuilder ns = new StringBuilder();
	for (int i = 0; i < n.length; i++) {
	    for (int j = 0; j < n.length; j++) {
		if (n[i][j] == true) {
		    ns.append("1");
		} else {
		    ns.append("0");
		}
		ns.append(" ");
	    }
	    ns.append("\n");
	}
	return ns.toString();
    }
}
