package sicht.schief;

import java.util.ArrayList;
import javax.swing.JFrame;
import koerper.kubus.Kubus;
import punkt.Dreipunkt;
import punktkoerper.Punktkoerper;
import punktkoerper.kubus.Punktkubus;
import welt.punktkoerper.Punktkoerperwelt;

/*
  javac -d classes $(find src -name '*.java')	\
  && java -cp classes sicht.schief.Main
*/

public class Main {
    
    public static void main(String[] args){
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	
	// Mache die Welt.
	Kubus k = new Kubus(10);
	Dreipunkt p = new Dreipunkt(20,20,20);
	Punktkubus pk = new Punktkubus(k, p);
	ArrayList<Punktkoerper> pkl = new ArrayList<Punktkoerper>();
	pkl.add(pk);
	Punktkoerperwelt pkw = new Punktkoerperwelt(pkl);

	// Wir müssen die Welt in die Sicht einsetzen, weil Java sie
	// irgendwann anrufen wird, die Welt darzustellen.
	Schiefsicht ss = new Schiefsicht(pkw, -0.5);
	
	// Geben wir die Sicht zu Java, um darzustellen.
	frame.add(ss);
	frame.setVisible(true);
    }
}

