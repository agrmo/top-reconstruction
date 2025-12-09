package graph.druck.tgf;

import graph.Nachbarschaftsliste;
import graph.Nachbarschaftsmatrix;

public class Main {
    public static void main(String[] args) {

	GraphTGF gtgf = new GraphTGF();
	
	int[][] paare = {{1,2},{2,0}};
	int groese = 3;
	Nachbarschaftsmatrix nm = new Nachbarschaftsmatrix(paare, groese);
	System.out.println(gtgf.macheGepheiTGF(nm));

	Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, groese);
	System.out.println(gtgf.macheGepheiTGF(nl));
    }
}
