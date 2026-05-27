package sicht.kreis.zwei;

import kreis.Kreis;
import java.awt.Color;
import javax.swing.JFrame;
import maler.Maler;
import sicht.Sicht;
import vektor.Zweivektor;
import welt.kreis.zwei.Zweikreiswelt;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.kreis.zwei.Main
*/

public class Main {

    public static void main(String[] args){
	
	// Mache die Welt.
	Kreis[] kreise = new Kreis[] {
	    new Kreis(5),
	    new Kreis(10)
	};
	Zweivektor[] orte = new Zweivektor[] {
	    new Zweivektor(100, 100),
	    new Zweivektor(50, 50)
	};
	Zweikreiswelt kw = new Zweikreiswelt(kreise, orte);

	// Mache die Sicht.
	Zweikreissicht s = new Zweikreissicht(kw);
	Maler m = new Maler(new Sicht[] {s});
	
	// Stelle die Daten dar.
	JFrame frame = new JFrame();
	frame.getContentPane().setBackground(Color.BLACK);
        frame.getContentPane().setForeground(Color.WHITE);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	frame.add(m);
	frame.setVisible(true);
    }
}
