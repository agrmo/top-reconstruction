package graph.druck.tgf;

import graph.Nachbarschaftsliste;
import graph.Nachbarschaftsmatrix;
import graph.zufalls.Zufallsgraph;

/*
  javac -d classes $(find src -name '*.java') && java -cp classes graph.druck.tgf.Main
*/

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
