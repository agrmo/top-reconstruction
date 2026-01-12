package sicht.vielflach.basis;

import java.util.ArrayList;
import javax.swing.JFrame;
import maler.Maler;
import sicht.Sicht;
import vektor.Dreivektor;
import vielflach.Vielflach;
import vielflach.kubus.Kubus;
import welt.vielflach.Vielflachwelt;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.vielflach.basis.Main
*/

public class Main {

    public static void main(String[] args){

	// Hier ist die Lösung des Problems, das wir im Giernickspiel
	// gefunden hatten. Eine Drehung mit der Mouse fällt uns
	// unrichtig, nach einem Kopfstehen des Kubus. Die Lösung ist
	// die Bearbeitung zweier Matrizen. Die erste Matrix is die
	// vorherige Matrix. Die zweite Matrix is die jetzige
	// Matrix. Die Mouse dreht die zweite Matrix. Nach die Lösung
	// der Mouse multiplizieren wir die zwei Matrizen, speichern
	// diese Matrix als vorherige, und erneuen die zweite Matrix.
	
	// Mache die Welt.
	ArrayList<Vielflach> kl = new ArrayList<Vielflach>();
	kl.add(new Kubus(30));
	ArrayList<Dreivektor> ol = new ArrayList<Dreivektor>();
	ol.add(new Dreivektor(0,0,100));
	
	Vielflachwelt kw = new Vielflachwelt(kl, ol);

	// Mache die Sicht.
	double breite = 1200;
	double hoehe = 600;
	double brennweite = 500;
	Dreivektor ap = new Dreivektor(0,0,0);
	Basissicht bs = new Basissicht(kw, ap, brennweite, breite, hoehe);
	Maler m = new Maler(new Sicht[] {bs});
	
	// Stellen die Daten dar.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize((int) breite, (int) hoehe);
	frame.add(m);
	frame.setVisible(true);
    }
}
