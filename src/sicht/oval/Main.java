package sicht.oval;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import figur.oval.Oval;
import punkt.Zweipunkt;
import maler.Maler;
import sicht.Sicht;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.oval.Main
*/

public class Main {

    public static void main(String[] args){
	
	// Mache die Daten.
	Oval[] kl = new Oval[2];
	Zweipunkt[] ol = new Zweipunkt[2];
	kl[0] = new Oval(30,20);
	kl[1] = new Oval(10,20);
	ol[0] = new Zweipunkt(100, 100);
	ol[1] = new Zweipunkt(50, 50);

	// Mache die Sicht.
	Ovalsicht s = new Ovalsicht(kl, ol);
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
