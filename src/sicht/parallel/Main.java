package sicht.parallel;

import java.util.ArrayList;
import javax.swing.JFrame;
import koerper.kubus.Kubus;
import punkt.Dreipunkt;
import punktkoerper.Punktkoerper;
import punktkoerper.kubus.Punktkubus;
import welt.punktkoerper.Punktkoerperwelt;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes sicht.parallel.Main
*/

public class Main {

    public static void main(String[] args){
 	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);

	// Mache eine Punktkörperwelt.
	Kubus k = new Kubus(50);
	Dreipunkt p = new Dreipunkt(100,100,100);
	Punktkubus pk = new Punktkubus(k, p);
	ArrayList<Punktkoerper> pkl = new ArrayList<Punktkoerper>();
	pkl.add(pk);
	Punktkoerperwelt pkw = new Punktkoerperwelt(pkl);
	
	// Mache eine Parallelsicht.
	Parallelsicht ps = new Parallelsicht(pkw);

	// Geben wir die Sicht zu Java, um darzustellen.
	frame.add(ps);
	frame.setVisible(true);
    }
}

