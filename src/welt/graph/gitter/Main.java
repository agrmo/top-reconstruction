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
	Zweivektor[] orte = Zweigitterorte.macheorte(1, 1, 5);
	System.out.println(Vektordrucker.drucke(orte));
	// Nur ein Ort, [0,0].
    }

    static void beispielzwei() {
	Zweivektor[] orte = Zweigitterorte.macheorte(2, 1, 5);
	System.out.println(Vektordrucker.drucke(orte));
	// Zwei Orte, [0,0] und [5,0].
    }

    static void beispieldrei() {
	Zweivektor[] orte = Zweigitterorte.macheorte(3, 1, 5);
	System.out.println(Vektordrucker.drucke(orte));
	// Drei Orte, [0,0], [5,0], [10,0]
    }

    static void beispielvier() {
	Zweivektor[] orte = Zweigitterorte.macheorte(3, 2, 5);
	System.out.println(Vektordrucker.drucke(orte));
	/*

	  Sechs Orte

	  [0,5] [5,5] [10,5]
	  [0,0] [5,0] [10,0]

	*/
    }

    static void beispielfuenf() {
	Zweigraphwelt zgw = Zweigitterwelt.machewelt(2, 3, 5);
	// Ok das passt...
    }
    
    public static void main(String[] args) {
	beispielfuenf();
    }    
}
