package welt.kreis;

import kreis.Kreis;
import vektor.Zweivektor;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes welt.kreis.Main
*/

public class Main {

    static void beispieleins() {

	Kreis[] kl = new Kreis[] {
	    new Kreis(5)
	};

	Zweivektor[] ol = new Zweivektor[] {
	    new Zweivektor(5,5)
	};

	Kreiswelt pw = new Kreiswelt(kl, ol);
    }

    public static void main(String[] args) {
	beispieleins();
    }    
}
