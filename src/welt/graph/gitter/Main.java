package welt.graph.gitter;

import vektor.Dreivektor;
import vektor.Zweivektor;
import graph.Nachbarschaftsliste;
import welt.graph.Zweigraphwelt;
import welt.graph.Dreigraphwelt;
import druck.graph.Graphtext;
import druck.vektor.Vektordrucker;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes welt.graph.gitter.Main
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

    static void beispielacht() {
	Zweivektor[] orte = Zweigitter.macheorte(1, 1, 5);
	System.out.println(Vektordrucker.drucke(orte));
	// Nur ein Ort, [0,0].
    }

    static void beispielneun() {
	Zweivektor[] orte = Zweigitter.macheorte(2, 1, 5);
	System.out.println(Vektordrucker.drucke(orte));
	// Zwei Orte, [0,0] und [5,0].
    }

    static void beispielzehn() {
	Zweivektor[] orte = Zweigitter.macheorte(3, 1, 5);
	System.out.println(Vektordrucker.drucke(orte));
	// Drei Orte, [0,0], [5,0], [10,0]
    }

    static void beispielelf() {
	Zweivektor[] orte = Zweigitter.macheorte(3, 2, 5);
	System.out.println(Vektordrucker.drucke(orte));
	/*

	  Sechs Orte

	  [0,5] [5,5] [10,5]
	  [0,0] [5,0] [10,0]

	*/
    }

    static void beispielzwoelf() {
	Zweigraphwelt zgw = Zweigitter.machewelt(2, 3, 5);
	// Ok das passt...
    }
    
    public static void main(String[] args) {
	beispielzwoelf();
    }    
}
