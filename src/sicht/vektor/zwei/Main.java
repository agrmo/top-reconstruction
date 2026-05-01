package sicht.vektor.zwei;

import java.awt.Color;
import javax.swing.JFrame;
import maler.Maler;
import sicht.Sicht;
import vektor.Zweivektor;
import welt.vektor.Zweivektorwelt;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.vektor.zwei.Main
*/

public class Main {

    static void beispieleins() {
	// Mache die Welt.
	Zweivektor[] vektore = new Zweivektor[] {
	    new Zweivektor(30,50),
	    new Zweivektor(10,50)
	};
	Zweivektor[] orte = new Zweivektor[] {
	    new Zweivektor(100, 100),
	    new Zweivektor(200, 100)
	};
	Zweivektorwelt ow = new Zweivektorwelt(vektore, orte);

	// Mache die Sicht.
	Zweivektorsicht s = new Zweivektorsicht(ow);
	Maler m = new Maler(new Sicht[] {s});
	
	// Stellen die Daten dar.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	frame.add(m);
	frame.setVisible(true);
    }

    public static void main(String[] args){
	beispieleins();
    }
}
