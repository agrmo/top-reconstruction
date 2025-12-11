package graph.rechnen.kanteverteilung;

import graph.Nachbarschaftsliste;
import graph.druck.tgf.GraphTGF;
import graph.zufalls.Zufallsgraph;
import liste.Liste;

public class Main {

    // Kanteverteilung eines bestimmten Graphen
    public static void beispielEins() {
	int[][] paare = {{1,2},{2,0}};
	int betrag = 3;
	Nachbarschaftsliste nl = new Nachbarschaftsliste(paare, betrag);

	Kanteverteilung kv = new Kanteverteilung();
	int[][] verteilung = kv.kanteVerteilung(nl);
	Liste l = new Liste();
	String verteilungString = l.nehmeStringVonArrayArray(verteilung);
	System.out.println(verteilungString);	
    }

    // Kanteverteilung eines Zufallsgraphen
    public static void beispielZwei() {
	Zufallsgraph zg = new Zufallsgraph(5, 0.3);
    	GraphTGF gtgf = new GraphTGF();
	System.out.println(gtgf.macheGepheiTGF(zg.nachbarschaftsliste));

	Kanteverteilung kv = new Kanteverteilung();
	int[][] verteilung = kv.kanteVerteilung(zg.nachbarschaftsliste);
	Liste l = new Liste();
	String verteilungString = l.nehmeStringVonArrayArray(verteilung);
	System.out.println(verteilungString);	
    }    

    public static void main(String[] args) {
	beispielZwei();
    }
}

