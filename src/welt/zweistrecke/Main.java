package welt.zweistrecke;

import java.util.ArrayList;
import strecke.Zweistrecke;
import punkt.Zweipunkt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes welt.zweistrecke.Main
*/

public class Main {
    public static void main(String[] args) {
	Zweistrecke zka = new Zweistrecke(new Zweipunkt(30,30),
					  new Zweipunkt(500,500));

	Zweistrecke zkb = new Zweistrecke(new Zweipunkt(200,20),
					  new Zweipunkt(500,100));
	
	Zweistrecke[] zsl = new Zweistrecke[] {zka, zkb};

	// Mache die zweidimensionale Streckenwelt.
	Zweistreckewelt zkw = new Zweistreckewelt(zsl);
    }
}
