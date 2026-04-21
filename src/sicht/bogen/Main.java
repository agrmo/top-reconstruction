package sicht.bogen;

import java.util.ArrayList;
import javax.swing.JFrame;
import bogen.Bogen;
import vektor.Zweivektor;
import maler.Maler;
import sicht.Sicht;
import welt.bogen.Zweibogenwelt;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.bogen.Main
*/

public class Main {

    public static void main(String[] args){
	
	// Mache die Welt.
	Bogen[] bl = new Bogen[] {
	    new Bogen(60,40,0,-90),
	    new Bogen(50,30,0,90)};
	
	Zweivektor[] ol = new Zweivektor[] {
	    new Zweivektor(200, 200),
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
