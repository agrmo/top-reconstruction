package druck.bogen;

import bogen.Bogen;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes druck.bogen.Main
*/

public class Main {
    public static void main(String[] args) {
	Bogen b = new Bogen(5, 5, 20, 10);
	System.out.println(Bogendrucker.drucke(b));
    }
}
