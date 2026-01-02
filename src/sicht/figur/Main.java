package sicht.figur;

import figur.Figur;
import figur.dreieck.Dreieck;
import java.util.ArrayList;
import javax.swing.JFrame;
import punkt.Zweipunkt;
import welt.figur.Figurwelt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes sicht.figur.Main
*/

public class Main {

    public static void main(String[] args){
 	
	// Mache die Welt.
	Dreieck k = new Dreieck(50);
	Zweipunkt p = new Zweipunkt(100,100);
	ArrayList<Figur> fl = new ArrayList<Figur>();
	fl.add(k);
	ArrayList<Zweipunkt> ol = new ArrayList<Zweipunkt>();
	ol.add(p);
	Figurwelt fw = new Figurwelt(fl, ol);
	
	// Mache die Sicht.
	Figursicht fs = new Figursicht(fw);

	// Darstellen.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	frame.add(fs);
	frame.setVisible(true);
    }
}
