package graph.graphlaeufer;

import graph.Nachbarschaftsliste;
import graph.Nachbarschaftsmatrix;
import graph.zufalls.Zufallsgraph;
import graph.druck.tgf.GraphTGF;
import liste.Liste;

public class Main {

    public static void beispielEins() {
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

    public static void beispielZwei() {
	Zufallsgraph zg = new Zufallsgraph(10, 0.3);
    	GraphTGF gtgf = new GraphTGF();
	System.out.println(gtgf.macheGepheiTGF(zg.nachbarschaftsliste));

	Graphlaeufer gl = new Graphlaeufer();
	int[][] verteilung = gl.kanteVerteilung(zg.nachbarschaftsliste);
	Liste l = new Liste();
	String verteilungString = l.nehmeStringVonArrayArray(verteilung);
	System.out.println(verteilungString);	
    }
    
    public static void main(String[] args) {
	beispielZwei();
    }
}
