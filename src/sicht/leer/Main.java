package sicht.leer;

import javax.swing.JFrame;

/*
  javac -d classes $(find src -name '*.java') \
  && java -cp classes sicht.leer.Main
*/

public class Main {

    public static void main(String[] args){
 	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1200, 600);
	frame.setVisible(true);
    }
}

