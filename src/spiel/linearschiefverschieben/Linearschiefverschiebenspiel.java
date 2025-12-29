package spiel.linearschiefverschieben;

import javax.swing.JFrame;
import sicht.linearschiefverschieben.Linearschiefverschiebensicht;
import handlung.Linearschiefverschiebentastaturhandlung;
import welt.punktkoerper.Punktkoerperwelt;
import punkt.Dreipunkt;

// Ein Spiel mit einer Linearschiefsicht einer Punktkörperwelt mit der
// Tastatur.  Ein linearschiefes Spiel enthält eine Handlung, eine
// Punktkörperwelt und eine Sicht. Die Handlung enthält auch die
// Sicht, weil sie beiden sie wiederdarstellen sollen.
public class Linearschiefverschiebenspiel {

    public Linearschiefverschiebenspiel() {
    }

    public void spielen(Punktkoerperwelt pkw,
			double a,
			double mx, double bx, double my, double by,
			Dreipunkt vp) {

	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);

	Linearschiefverschiebensicht ps = new Linearschiefverschiebensicht(pkw,
								   a,
								   mx, bx, my, by,
								   vp);
	
	Linearschiefverschiebentastaturhandlung h = new Linearschiefverschiebentastaturhandlung(ps);

	frame.add(ps);
	frame.addKeyListener(h);
	frame.setVisible(true);	
    }
}
