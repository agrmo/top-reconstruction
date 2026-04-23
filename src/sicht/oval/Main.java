package sicht.oval;

import figur.oval.Oval;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import maler.Maler;
import sicht.Sicht;
import vektor.Zweivektor;
import welt.oval.Ovalwelt;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.oval.Main
*/

public class Main {

    public static void main(String[] args){
	
	// Mache die Welt.
	Oval[] ovale = new Oval[] {
	    new Oval(30,20),
	    new Oval(10,20)
	};
	Zweivektor[] orte = new Zweivektor[] {
	    new Zweivektor(100, 100),
	    new Zweivektor(50, 50)
	};
	Ovalwelt ow = new Ovalwelt(ovale, orte);

	// Mache die Sicht.
	Ovalsicht s = new Ovalsicht(ow);
	Maler m = new Maler(new Sicht[] {s});
	
	// Stellen die Daten dar.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	frame.add(m);
	frame.setVisible(true);
    }
}
