package spiel.leermouse;

import handlung.Handlung;
import handlung.MouseHandlung;

/*
  javac -d classes $(find src -name '*.java') \
  && java -cp classes spiel.leermouse.Main
*/

public class Main{
    public static void main(String[] args) {
	MouseHandlung h = new MouseHandlung();
	LeerMouseSpiel ms = new LeerMouseSpiel(h);
	ms.spielen();
    }
}
