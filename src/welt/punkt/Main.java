package welt.punkt;

import vektor.Dreivektor;
import vektor.Zweivektor;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes welt.punkt.Main
*/

public class Main {

    static void beispieleins() {
	Dreivektor[] orte = new Dreivektor[] {
	    new Dreivektor(0,0,0),
	    new Dreivektor(10,0,0),
	    new Dreivektor(0,10,0),
	    new Dreivektor(0,0,10)
	};

	Punktwelt pw = new Punktwelt(orte);
    }

    public static void main(String[] args) {
	beispieleins();
    }    
}
