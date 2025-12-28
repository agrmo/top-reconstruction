package spiel.leertastatur;

import handlung.Handlung;
import handlung.TastaturHandlung;

/*
  javac -d classes $(find src -name '*.java') \
  && java -cp classes spiel.leertastatur.Main
*/

public class Main{
    public static void main(String[] args) {
	TastaturHandlung h = new TastaturHandlung();
	LeerTastaturSpiel s = new LeerTastaturSpiel(h);
	s.spielen();
    }
}
