package spiel.leer;

import javax.swing.JFrame;
import handlung.spiel.SpielMouseHandlung;
import handlung.spiel.SpielTastaturHandlung;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes spiel.leer.Main
*/

public class Main {
    public static void main(String[] args) {
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);

	// Das Spiel nimmt Ereignissen von der Handlung ein.
	Leerspiel s = new Leerspiel();

	// Die Handlungen werden das Spiel anrufen.
	SpielMouseHandlung mh = new SpielMouseHandlung(s);
	SpielTastaturHandlung th = new SpielTastaturHandlung(s);

	frame.addMouseListener(mh);
	frame.addKeyListener(th);
	
	frame.setVisible(true);	
    }
}
