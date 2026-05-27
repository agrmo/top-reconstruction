package sicht.vieleck;

import javax.swing.JFrame;
import maler.Maler;
import sicht.Sicht;
import vektor.Zweivektor;
import vieleck.Vieleck;
import vieleck.dreieck.Dreieck;
import welt.vieleck.Vieleckwelt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes sicht.vieleck.Main
*/

public class Main {

    public static void main(String[] args){
 	
	// Mache die Welt.
	Dreieck k = new Dreieck(50);
	Zweivektor p = new Zweivektor(100,100);
	Vieleck[] fl = new Vieleck[] {k};
	Zweivektor[] ol = new Zweivektor[] {p};
	Vieleckwelt fw = new Vieleckwelt(fl, ol);
	
	// Mache die Sicht.
	Vielecksicht fs = new Vielecksicht(fw);
	Maler m = new Maler(new Sicht[] {fs});

	// Darstellen.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	frame.add(m);
	frame.setVisible(true);
    }
}
