package sicht.kreis;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import figur.kreis.Kreis;
import vektor.Zweivektor;
import maler.Maler;
import sicht.Sicht;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.kreis.Main
*/

public class Main {

    public static void main(String[] args){
	
	// Mache die Daten.
	Kreis[] kl = new Kreis[2];
	Zweivektor[] ol = new Zweivektor[2];
	kl[0] = new Kreis(5);
	kl[1] = new Kreis(10);
	ol[0] = new Zweivektor(100, 100);
	ol[1] = new Zweivektor(50, 50);

	// Mache die Sicht.
	Kreissicht s = new Kreissicht(kl, ol);
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
