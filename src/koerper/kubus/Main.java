package koerper.kubus;

import punkt.Punkt;
import java.util.ArrayList;
import java.util.Arrays;

/*
  javac -d classes $(find src -name '*.java') && java -cp classes koerper.kubus.Main
*/

public class Main {
    public static void main(String[] args) {

	Kubus k = new Kubus(1);

	Punkt[] ecken = k.nehmeEcken();

	for (int i = 0; i < ecken.length; i++) {
	    System.out.println(Arrays.toString(ecken[i].teile));
	}
    }
}
