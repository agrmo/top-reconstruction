package welt.punkt;

import vektor.Dreivektor;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes welt.punkt.Main
*/

public class Main {

    static void beispieleins() {
	Dreivektor[] pl = new Dreivektor[] {
	    new Dreivektor(0,0,0),
	    new Dreivektor(10,0,0),
	    new Dreivektor(0,10,0),
	    new Dreivektor(0,0,10)
	};

	Dreipunktwelt pw = new Dreipunktwelt(pl);
    }

    public static void main(String[] args) {
	beispieleins();
    }    
}
