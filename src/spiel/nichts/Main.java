package spiel.nichts;

import handlung.spiel.Spielhandlung;
import javax.swing.JFrame;
import spiel.Spiel;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes spiel.nichts.Main
*/

public class Main {

    public static void main(String[] args) {
	// Das Spiel nimmt Ereignissen von der Handlung ein.
	Nichtsspiel s = new Nichtsspiel();

	// Die Handlungen werden das Spiel anrufen.
	Spielhandlung sh = new Spielhandlung(s);

	// Fangen die Handlung an.
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	frame.addMouseListener(sh);
	frame.addMouseMotionListener(sh);
	frame.addKeyListener(sh);
	frame.setVisible(true);
    }
}
