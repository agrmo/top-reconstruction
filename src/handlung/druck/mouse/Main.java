package handlung.druck.mouse;

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
	DruckMouseHandlung h = new DruckMouseHandlung();
	
	frame.addMouseListener(h);
	frame.setVisible(true);
    }
}
