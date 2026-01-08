package straffer;

import strecke.Zweistrecke;
import punkt.Zweipunkt;
import welt.zweistrecke.Zweistreckewelt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes straffer.Main
*/

public class Main {
    public static void main(String[] args) {

	// Mache eine einfache Welt mit zwei Strecken.
	Zweistrecke zka = new Zweistrecke(new Zweipunkt(30,30),
				      new Zweipunkt(500,500));

	Zweistrecke zkb = new Zweistrecke(new Zweipunkt(200,20),
				      new Zweipunkt(500,100));
	
	Zweistrecke[] zsl = new Zweistrecke[] {zka, zkb};

	// Mache die zweidimensionale Streckenwelt.
	Zweistreckewelt welt = new Zweistreckewelt(zsl);

	Straffer.straffenWelt(welt, 2.0, 2.0);
    }
}
