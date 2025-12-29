package druck.kante;

import kante.Dreikante;
import kante.Zweikante;
import punkt.Dreipunkt;
import punkt.Zweipunkt;

/*
  javac -d classes $(find src -name '*.java') \
  && java -cp classes druck.kante.Main
*/

public class Main {
    public static void main(String[] args) {
	Dreipunkt pa = new Dreipunkt(1,1,1);
	Dreipunkt pb = new Dreipunkt(2,2,2);
	Dreikante k = new Dreikante(pa, pb);

	System.out.println(Kantedrucker.drucken(k));
    }
}
