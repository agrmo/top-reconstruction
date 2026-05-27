package graph.gitter;

import graph.Nachbarschaftsliste;
import druck.graph.Graphtext;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes graph.gitter.Main
*/

public class Main {

    static void beispieleins() {
	int ka = Zweigitter.nehmekantenanzahl(1,1);
	System.out.println(ka);
	// 0
    }

    static void beispielzwei() {
	int ka = Zweigitter.nehmekantenanzahl(1,2);
	System.out.println(ka);
	// 1
    }

    static void beispieldrei() {
	int ka = Zweigitter.nehmekantenanzahl(1,3);
	System.out.println(ka);
	// 2
    }

    static void beispielvier() {
	int ka = Zweigitter.nehmekantenanzahl(2,3);
	System.out.println(ka);
	// 7
    }

    static void beispielfuenf() {
	Nachbarschaftsliste nl = Zweigitter.machegraph(1, 1);
	Graphtext gd = new Graphtext();
	System.out.println(gd.drucke(nl));
	
	// Nur ein Knoten, ohne Kanten.
	// 0: []
    }

    static void beispielsechs() {
	Nachbarschaftsliste nl = Zweigitter.machegraph(1, 3);
	Graphtext gd = new Graphtext();
	System.out.println(gd.drucke(nl));
	
	// Drei Knoten, zwei Kanten.
    }

    static void beispielsieben() {
	Nachbarschaftsliste nl = Zweigitter.machegraph(3, 2);
	Graphtext gd = new Graphtext();
	System.out.println(gd.drucke(nl));
	
	// Sechs Knoten, sieben Kanten.
    }

    public static void main(String[] args) {
	beispielsieben();
    }    
}
