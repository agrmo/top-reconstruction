package straffer;

import strecke.Zweistrecke;
import vektor.Zweivektor;
import welt.strecke.Zweistreckewelt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes straffer.Main
*/

public class Main {
    public static void main(String[] args) {

	// Mache eine einfache Welt mit zwei Strecken.
	Zweistrecke zsa = new Zweistrecke(new Zweivektor(30,30),
				      new Zweivektor(500,500));

	Zweistrecke zsb = new Zweistrecke(new Zweivektor(200,20),
				      new Zweivektor(500,100));
	
	Zweistrecke[] zsl = new Zweistrecke[] {zsa, zsb};

	// Mache die zweidimensionale Streckenwelt.
	Zweistreckewelt welt = new Zweistreckewelt(zsl);

	Straffer.straffenWelt(welt, 2.0, 2.0);
    }
}
