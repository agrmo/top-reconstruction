package welt.strecke.drei;

import strecke.Dreistrecke;
import vektor.Dreivektor;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes welt.strecke.drei.Main
*/

public class Main {
    public static void main(String[] args) {

	Dreistrecke[] dsl = new Dreistrecke[] {
	    new Dreistrecke(new Dreivektor(30,30,30),
			    new Dreivektor(500,500,500)),
	    new Dreistrecke(new Dreivektor(200,20,10),
			    new Dreivektor(500,100,200))
	};

	// Mache die dreidimensionale Welt.
	Dreistreckewelt dsw = new Dreistreckewelt(dsl);
    }
}
