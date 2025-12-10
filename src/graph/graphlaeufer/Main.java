package graph.graphlaeufer;

import graph.Nachbarschaftsliste;
import graph.Nachbarschaftsmatrix;
import liste.Liste;

public class Main {
    public static void main(String[] args) {

	Graphlaeufer gl = new Graphlaeufer();
	
	int[][] paare = {{1,2},{2,0}};
	int betrag = 3;
	Nachbarschaftsmatrix nm = new Nachbarschaftsmatrix(paare, betrag);
	System.out.println(gl.hatKante(nm,1,2));
	System.out.println(gl.hatKante(nm,2,1));
	
	Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, betrag);
	System.out.println(gl.hatKante(nl,1,2));
	System.out.println(gl.hatKante(nl,2,1));

	int[][] verteilung = gl.kanteVerteilung(nl);
	Liste l = new Liste();
	String verteilungString = l.nehmeStringVonArrayArray(verteilung);
	System.out.println(verteilungString);
    }
}
