package graph.druck;

import graph.Nachbarschaftsliste;
import graph.Nachbarschaftsmatrix;

public class Main {
    public static void main(String[] args) {
	GraphText gd = new GraphText();
	
	int[][] paare = {{1,2},{2,0}};
	int groese = 3;
	Nachbarschaftsmatrix nm = new Nachbarschaftsmatrix(paare, groese);
	System.out.println(gd.drucke(nm));
	
	Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, 3);
	System.out.println(gd.drucke(nl));

    }
}
