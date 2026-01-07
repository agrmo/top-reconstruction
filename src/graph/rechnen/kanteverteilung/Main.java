package graph.rechnen.kanteverteilung;

import graph.Nachbarschaftsliste;
import druck.graph.tgf.GraphTGF;
import graph.zufalls.Zufallsgraph;
import liste.Liste;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes graph.rechnen.kanteverteilung.Main
*/

public class Main {

    // Kanteverteilung eines bestimmten Graphen
    public static void beispielEins() {
	int[][] paare = {{1,2},{2,0}};
	int betrag = 3;
	Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, betrag);

	int[][] verteilung = Kanteverteilung.kanteVerteilung(nl);
	String verteilungString = Liste.nehmeStringVonArrayArray(verteilung);
	System.out.println(verteilungString);	
    }

    // Kanteverteilung eines Zufallsgraphen
    public static void beispielZwei() {
	Zufallsgraph zg = new Zufallsgraph(5, 0.3);
    	GraphTGF gtgf = new GraphTGF();
	System.out.println(gtgf.macheGepheiTGF(zg.nachbarschaftsliste));

	int[][] verteilung = Kanteverteilung.kanteVerteilung(zg.nachbarschaftsliste);
	String verteilungString = Liste.nehmeStringVonArrayArray(verteilung);
	System.out.println(verteilungString);	
    }    

    public static void main(String[] args) {
	beispielZwei();
    }
}

