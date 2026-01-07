package sicht.bogen;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import bogen.Bogen;
import punkt.Zweipunkt;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.bogen.Main
*/

public class Main {

    public static void main(String[] args){
	
	// Mache die Daten.
	Bogen[] bl = new Bogen[2];
	Zweipunkt[] ol = new Zweipunkt[2];
	bl[0] = new Bogen(60,40,0,-90);
	bl[1] = new Bogen(50,30,0,90);
	ol[0] = new Zweipunkt(200, 200);
	ol[1] = new Zweipunkt(100, 100);

	// Mache die Sicht.
	Bogensicht os = new Bogensicht(bl, ol);
	
	// Stellen die Daten dar.
	JFrame frame = new JFrame();
	frame.getContentPane().setBackground(Color.BLACK);
        frame.getContentPane().setForeground(Color.WHITE);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	frame.add(os);
	frame.setVisible(true);
    }
}
