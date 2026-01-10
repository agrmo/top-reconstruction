package druck.vielflach;

import vielflach.kubus.Kubus;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes druck.vielflach.Main
*/

public class Main {
    public static void main(String[] args) {
	Kubus k = new Kubus(1);
	System.out.println(Vielflachdrucker.druckenEcken(k));
	System.out.println(Vielflachdrucker.druckenStrecken(k));
    }
}
