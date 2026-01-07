package graph.rechnen.hatkante;

import graph.Nachbarschaftsliste;
import graph.Nachbarschaftsmatrix;

public class HatKante {
    public HatKante() {
	
    }

    // Ist die Kante von v bis b (oder umgekehrt) im Graph?
    public static boolean hatKante(Nachbarschaftsliste n, int v, int b) {
	return n.n.get(v).contains(b) || n.n.get(b).contains(v);
    }

    // Ist die Kante von v bis b (oder umgekehrt) im Graph?
    public static boolean hatKante(Nachbarschaftsmatrix n, int v, int b) {
	return n.n[v][b] || n.n[b][v];
    }    
}
