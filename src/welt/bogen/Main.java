package welt.bogen;

import bogen.Bogen;
import vektor.Zweivektor;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes welt.bogen.Main
*/

public class Main {

    static void beispieleins() {
	// Mache die Welt.
	Bogen[] bl = new Bogen[] {
	    new Bogen(60,40,0,-90),
	    new Bogen(50,30,0,90)};
	
	Zweivektor[] ol = new Zweivektor[] {
	    new Zweivektor(200, 200),
	    new Zweivektor(100, 100)};
	
	Zweibogenwelt zbw = new Zweibogenwelt(bl, ol);
    }

    public static void main(String[] args) {
	beispieleins();
    }    
}
