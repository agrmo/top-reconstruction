package welt.oval;

import oval.Oval;
import vektor.Zweivektor;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes welt.oval.Main
*/

public class Main {

    static void beispieleins() {

	Oval[] ovale = new Oval[] {
	    new Oval(5, 10)
	};
	Zweivektor[] orte = new Zweivektor[] {
	    new Zweivektor(5,5)
	};
	Ovalwelt ow = new Ovalwelt(ovale, orte);
    }

    public static void main(String[] args) {
	beispieleins();
    }    
}
