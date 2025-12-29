package spiel.parallel;

import javax.swing.JFrame;
import sicht.parallel.Parallelsicht;
import handlung.Paralleltastaturhandlung;
import welt.punktkoerper.Punktkoerperwelt;

// Ein Spiel mit einer Parallelsicht einer Punktkörperwelt mit der
// Tastatur.  Ein paralleles Spiel enthält eine parallele Handlung,
// eine Punktkörperwelt und eine Parallelsicht. Beide die Handlung und
// Spiel enthalten die Sicht, weil sie beiden sie wiederdarstellen
// sollen.
//
public class Parallelspiel {

    public Parallelspiel() {
	
    }

    public void spielen(Punktkoerperwelt pkw) {
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);

	Parallelsicht ps = new Parallelsicht(pkw);
	Paralleltastaturhandlung h = new Paralleltastaturhandlung(ps);

	frame.add(ps);
	frame.addKeyListener(h);
	frame.setVisible(true);	
    }
}
