package graph.graphlaeufer;

import graph.Nachbarschaftsliste;
import graph.Nachbarschaftsmatrix;

public class Graphlaeufer {

    public Graphlaeufer() {
	
    }

    // Ist die Kante von v bis b (oder umgekehrt) im Graph?
    public boolean hatKante(Nachbarschaftsliste n, int v, int b) {
	return n.n.get(v).contains(b) || n.n.get(b).contains(v);
    }

    // Ist die Kante von v bis b (oder umgekehrt) im Graph?
    public boolean hatKante(Nachbarschaftsmatrix n, int v, int b) {
	return n.n[v][b] || n.n[b][v];
    }    
}
