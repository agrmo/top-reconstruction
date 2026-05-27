package druck.graph;

import graph.Nachbarschaftsliste;
import graph.Doppelnachbarschaftsliste;
import graph.Nachbarschaftsmatrix;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes druck.graph.Main
*/

public class Main {

    static void beispieleins() {
	Graphtext gd = new Graphtext();
	
	int[][] paare = {{1,2},{2,0}};
	int groese = 3;
	Nachbarschaftsmatrix nm = new Nachbarschaftsmatrix(paare, groese);
	System.out.println(gd.drucke(nm));
	
	Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, 3);
	System.out.println(gd.drucke(nl));
    }

    static void beispielzwei() {
	Graphtext gd = new Graphtext();
	int[][] paare = {{1,2},{2,0}};
	int groese = 3;
	Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, 3);
	System.out.println(gd.drucke(nl));
	Doppelnachbarschaftsliste dnl = new Doppelnachbarschaftsliste(nl);
	System.out.println(gd.drucke(dnl));
    }
    
    public static void main(String[] args) {
	beispielzwei();
    }
}
