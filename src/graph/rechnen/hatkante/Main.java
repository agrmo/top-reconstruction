package graph.rechnen.hatkante;

import graph.Nachbarschaftsliste;
import graph.Nachbarschaftsmatrix;

public class Main {

    public static void beispielEins() {
	HatKante hk = new HatKante();
	
	int[][] paare = {{1,2},{2,0}};
	int betrag = 3;
	Nachbarschaftsmatrix nm = new Nachbarschaftsmatrix(paare, betrag);
	System.out.println(hk.hatKante(nm,1,2));
	System.out.println(hk.hatKante(nm,2,1));
	
	Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, betrag);
	System.out.println(hk.hatKante(nl,1,2));
	System.out.println(hk.hatKante(nl,2,1));
    }

    public static void main(String[] args) {
	beispielEins();
    }
}
