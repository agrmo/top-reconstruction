package sicht.vielflach.schief;

import java.util.ArrayList;
import javax.swing.JFrame;
import vielflach.kubus.Kubus;
import vektor.Dreivektor;
import vielflach.Vielflach;
import welt.vielflach.Vielflachwelt;
import maler.Maler;
import sicht.Sicht;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.vielflach.schief.Main
*/

public class Main {
    
    public static void main(String[] args){
	
	// Mache die Welt.
	Kubus k = new Kubus(50);
	Dreivektor p = new Dreivektor(100,100,100);
	ArrayList<Vielflach> kl = new ArrayList<Vielflach>();
	kl.add(k);
	ArrayList<Dreivektor> ol = new ArrayList<Dreivektor>();
	ol.add(p);
	Vielflachwelt kw = new Vielflachwelt(kl, ol);

	// Mache die Sicht.
	Schiefsicht s = new Schiefsicht(kw, 0.1);
	Maler m = new Maler(new Sicht[] {s});
	
	// Stellen die Welt dar.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	frame.add(m);
	frame.setVisible(true);
    }
}

