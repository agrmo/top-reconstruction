package druck.koerper.kubus;

import koerper.kubus.Kubus;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes druck.koerper.kubus.Main
*/

public class Main {
    public static void main(String[] args) {
	Kubus k = new Kubus(1);
	System.out.println(Kubusdrucker.druckenLaenge(k));
	System.out.println(Kubusdrucker.druckenEcken(k));
	System.out.println(Kubusdrucker.druckenKanten(k));
    }
}
