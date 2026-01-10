package sicht.text;

import java.awt.Color;
import javax.swing.JFrame;
import punkt.Zweipunkt;
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
	    "Hallo",
	    "Wie gehts?",
	    "Ich brauche Zeit.",
	    "Ich verstehe nur, was zu mir passiert ist."
	};
	
	Zweipunkt[] ol = new Zweipunkt[] {
	    new Zweipunkt(0,12),
	    new Zweipunkt(0,24),
	    new Zweipunkt(0,36),
	    new Zweipunkt(0,48)
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
