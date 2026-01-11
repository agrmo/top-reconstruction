package welt.zweistrecke;

import java.util.ArrayList;
import strecke.Zweistrecke;
import vektor.Zweivektor;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes welt.zweistrecke.Main
*/

public class Main {
    public static void main(String[] args) {
	Zweistrecke zka = new Zweistrecke(new Zweivektor(30,30),
					  new Zweivektor(500,500));

	Zweistrecke zkb = new Zweistrecke(new Zweivektor(200,20),
					  new Zweivektor(500,100));
	
	Zweistrecke[] zsl = new Zweistrecke[] {zka, zkb};

	// Mache die zweidimensionale Streckenwelt.
	Zweistreckewelt zkw = new Zweistreckewelt(zsl);
    }
}
