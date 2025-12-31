package handlung.druck.mousebewegen;

import javax.swing.JFrame;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes handlung.druck.mouse.Main
*/

public class Main {
    public static void main(String[] args) {
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);

	// Das Spiel tut nichts. Benutzen irgendeine Handlung.
	DruckMouseBewegenHandlung h = new DruckMouseBewegenHandlung();
	
	frame.addMouseMotionListener(h);
	frame.setVisible(true);
    }
}
