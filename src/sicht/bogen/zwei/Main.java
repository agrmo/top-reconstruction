package sicht.bogen.zwei;

import bogen.Bogen;
import javax.swing.JFrame;
import maler.Maler;
import sicht.Sicht;
import vektor.Zweivektor;
import welt.bogen.Zweibogenwelt;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.bogen.zwei.Main
*/

public class Main {

    public static void main(String[] args){
	
	// Mache die Welt.
	Bogen[] bl = new Bogen[] {
	    new Bogen(800,200,10,90),
	    new Bogen(400,200,10,90),
	    new Bogen(200,200,10,90),
	    new Bogen(100,200,10,90)};
	Zweivektor[] ol = new Zweivektor[] {
	    new Zweivektor(100, 100),
	    new Zweivektor(100, 100),
	    new Zweivektor(100, 100),
	    new Zweivektor(100, 100)};
	Zweibogenwelt zbw = new Zweibogenwelt(bl, ol);

	// Mache die Sicht.
	Zweibogensicht s = new Zweibogensicht(zbw);
	Maler m = new Maler(new Sicht[] {s});
	
	// Geh.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	frame.add(m);
	frame.setVisible(true);
    }
}
