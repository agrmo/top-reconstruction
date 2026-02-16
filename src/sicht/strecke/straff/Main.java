package sicht.strecke.straff;

import javax.swing.JFrame;
import java.awt.Color;
import vektor.Zweivektor;
import strecke.Zweistrecke;
import welt.zweistrecke.Zweistreckewelt;
import maler.Maler;
import sicht.Sicht;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.strecke.straff.Main
*/

public class Main {

    static void beispielEins() {
	// Mache die Welt.
	Zweistrecke zsa = new Zweistrecke(new Zweivektor(0,100),
					  new Zweivektor(100,100));
	
	Zweistrecke zsb = new Zweistrecke(new Zweivektor(100,200),
					  new Zweivektor(200,200));
	
	Zweistrecke[] zsl = new Zweistrecke[] {zsa, zsb};
	Zweistreckewelt zsw = new Zweistreckewelt(zsl);

	// Der Verleger vergrößert die Stellen der Strecken. Nicht nur
	// wird den Abstand zwischen den Vektoren vergrößert, sondern
	// auch den Abstand zum Ursprung. Zum Beispiel,
	//
	// (0,0) --- (10,0) --- (20,0)
	// werden nach
	// (0,0) ------ (20,0) ------ (40,0)
	// verschoben.
	//
	// 2.0 1.0: Die Zahlen, die der straffe Verleger benutzt
	//   2.0: Multipliziere alle x Stellen mit 2.0
	//   1.0: Multipliziere alle y Stellen mit 1.0
	//
	Straffsicht s = new Straffsicht(zsw, 2.0, 1.0);
	Maler m = new Maler(new Sicht[] {s});
	
	// Stellen die Daten dar.
	JFrame frame = new JFrame();
	frame.getContentPane().setBackground(Color.BLACK);
        frame.getContentPane().setForeground(Color.WHITE);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	frame.add(m);
	frame.setVisible(true);
    }
    
    public static void main(String[] args){
	beispielEins();
    }
}

