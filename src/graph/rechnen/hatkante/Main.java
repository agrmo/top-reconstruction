package graph.rechnen.hatkante;

import graph.Nachbarschaftsliste;
import graph.Nachbarschaftsmatrix;

/*
  javac -d classes $(find src -type f) && java -cp classes graph.rechnen.hatkante.Main
*/

public class Main {

    public static void beispielEins() {
	int[][] paare = {{1,2},{2,0}};
	int betrag = 3;
	Nachbarschaftsmatrix nm = new Nachbarschaftsmatrix(paare, betrag);
	System.out.println(HatKante.hatKante(nm,1,2));
	System.out.println(HatKante.hatKante(nm,2,1));
	
	Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, betrag);
	System.out.println(HatKante.hatKante(nl,1,2));
	System.out.println(HatKante.hatKante(nl,2,1));
    }

    public static void main(String[] args) {
	beispielEins();
    }
}
