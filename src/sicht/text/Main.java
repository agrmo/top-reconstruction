package sicht.text;

import java.awt.Color;
import javax.swing.JFrame;
import vektor.Zweivektor;
import maler.Maler;
import sicht.Sicht;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.text.Main
*/

public class Main {

    public static void main(String[] args){
	
	// Mache die Daten.
	String[] tl = new String[] {
	    "Ich bin nun blind, Andrea.",
	    "Ich sehe nicht mehr.",
	    "Ich glotze nur noch in die Dunkelheit.",
	    "Geh jetzt."
	};
	
	Zweivektor[] ol = new Zweivektor[] {
	    new Zweivektor(0,12),
	    new Zweivektor(0,24),
	    new Zweivektor(0,36),
	    new Zweivektor(0,48)
	};
	
	// Mache die Sicht.
	Textsicht s = new Textsicht(tl, ol);
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
}
