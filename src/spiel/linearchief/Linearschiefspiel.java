package spiel.linearschief;

import javax.swing.JFrame;
import sicht.linearschief.Linearschiefsicht;
import handlung.Linearschieftastaturhandlung;
import welt.punktkoerper.Punktkoerperwelt;
import java.awt.Color;

// Ein Spiel mit einer Linearschiefsicht einer Punktkörperwelt mit der
// Tastatur.  Ein linearschiefes Spiel enthält eine Handlung, eine
// Punktkörperwelt und eine Sicht. Die Handlung enthält auch die
// Sicht, weil sie beiden sie wiederdarstellen sollen.
//
public class Linearschiefspiel {

    public Linearschiefspiel() {
    }

    public void spielen(Punktkoerperwelt pkw,
			double a,
			double mx, double bx, double my, double by) {
	
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	frame.getContentPane().setBackground(Color.BLACK);
	frame.getContentPane().setForeground(Color.WHITE);

	Linearschiefsicht ps = new Linearschiefsicht(pkw,
						     a,
						     mx, bx, my, by);
	
	Linearschieftastaturhandlung h = new Linearschieftastaturhandlung(ps);

	frame.add(ps);
	frame.addKeyListener(h);
	frame.setVisible(true);	
    }
}
