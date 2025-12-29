package spiel.linearschief;

import java.util.ArrayList;
import koerper.kubus.Kubus;
import punkt.Dreipunkt;
import punktkoerper.Punktkoerper;
import punktkoerper.kubus.Punktkubus;
import welt.punktkoerper.Punktkoerperwelt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes spiel.linearschief.Main
*/

public class Main{
    public static void main(String[] args) {
	
	// Wir müssen nur eine Welt aufbauen und in das Spiel
	// eintragen. Das Spiel wird sich selbst die Handlung und
	// Sicht schaffen.
	
	// Mache eine Punktkörperwelt.
	Kubus k = new Kubus(50);
	Dreipunkt p = new Dreipunkt(100,100,100);
	Punktkubus pk = new Punktkubus(k, p);
	ArrayList<Punktkoerper> pkl = new ArrayList<Punktkoerper>();
	pkl.add(pk);
	Punktkoerperwelt pkw = new Punktkoerperwelt(pkl);

	// Wir müssen aber eine Anzahl von Eigenschaften nennen, um
	// die Linearschiefsicht aufzubauen. Am Anfang sind sie
	// einfach. Wir werden dieze Zahlen mit der Tastatur
	// verändern!
	double a = 1.0;
	double mx = 1.0;
	double bx = 0.0;
	double my = 1.0;
	double by = 0.0;

	// Geben die Welt in das Spiel ein.  Wir müssen die
	// Eigenschaften nicht im Spiel geben, nur in der
	// Funktion. Wir sind dankbar dafür...
	
	Linearschiefspiel s = new Linearschiefspiel();
	s.spielen(pkw, a, mx, bx, my, by);
    }
}
