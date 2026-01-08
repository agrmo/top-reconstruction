package sicht.leer;

import javax.swing.JFrame;
import maler.Maler;
import sicht.Sicht;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes sicht.leer.Main
*/

public class Main {

    public static void main(String[] args){
 	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);

	Leersicht s = new Leersicht();
	Maler m = new Maler(new Sicht[] {s});
	
	frame.add(m);
	frame.setVisible(true);
    }
}

