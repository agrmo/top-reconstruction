package koerper.kubus;

import punkt.Dreipunkt;
import strecke.Dreistrecke;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes koerper.kubus.Main
*/

public class Main {
    public static void main(String[] args) {
	Kubus k = new Kubus(1);

	Dreistrecke[] kl = k.nehmeStrecken();
    }
}
