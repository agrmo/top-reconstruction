package sicht.kante;

import java.util.ArrayList;
import javax.swing.JFrame;
import welt.kante.Zweikantewelt;
import punkt.Zweipunkt;
import kante.Zweikante;

/*
  javac -d classes $(find src -type f)	\
  && java -cp classes sicht.kante.Main
*/

public class Main {
    
    public static void main(String[] args){
	
	// Mache die zweidimensionale Kantenwelt.
	Zweikante zka = new Zweikante(new Zweipunkt(30,30),
				      new Zweipunkt(500,500));

	Zweikante zkb = new Zweikante(new Zweipunkt(200,20),
				      new Zweipunkt(500,100));
	
	ArrayList<Zweikante> zkl = new ArrayList<Zweikante>();
	zkl.add(zka);
	zkl.add(zkb);
	Zweikantewelt zkw = new Zweikantewelt(zkl);
	
	// Mache eine Kantesicht.
	Kantesicht ks = new Kantesicht(zkw);

	// Geh.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	frame.add(ks);
	frame.setVisible(true);
    }
}

