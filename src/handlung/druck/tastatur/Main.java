package handlung.druck.tastatur;

import javax.swing.JFrame;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes handlung.druck.tastatur.Main
*/

public class Main {
    public static void main(String[] args) {
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);

	// Das Spiel tut nichts. Benutzen irgendeine Handlung.
	Drucktastaturhandlung h = new Drucktastaturhandlung();
	
	frame.addKeyListener(h);
	frame.setVisible(true);	
    }
}
