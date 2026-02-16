package welt.zweistrecke;

import strecke.Zweistrecke;
import vektor.Zweivektor;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes welt.zweistrecke.Main
*/

public class Main {
    public static void main(String[] args) {
	Zweistrecke zsa = new Zweistrecke(new Zweivektor(30,30),
					  new Zweivektor(500,500));

	Zweistrecke zsb = new Zweistrecke(new Zweivektor(200,20),
					  new Zweivektor(500,100));
	
	Zweistrecke[] zsl = new Zweistrecke[] {zsa, zsb};

	// Mache die zweidimensionale Streckenwelt.
	Zweistreckewelt zsw = new Zweistreckewelt(zsl);
    }
}
