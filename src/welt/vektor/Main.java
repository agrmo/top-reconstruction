package welt.vektor;

import vektor.Dreivektor;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes welt.vektor.Main
*/

public class Main {

    static void beispieleins() {
	Dreivektor[] o = new Dreivektor[] {
	    new Dreivektor(0,0,0),
	    new Dreivektor(10,0,0)
	};

	Dreivektor[] v = new Dreivektor[] {
	    new Dreivektor(1,0,0),
	    new Dreivektor(0,1,0)
	};

	Dreivektorwelt dvw = new Dreivektorwelt(o, v);
    }

    public static void main(String[] args) {
	beispieleins();
    }    
}
