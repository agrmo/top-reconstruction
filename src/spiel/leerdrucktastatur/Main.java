package spiel.leerdrucktastatur;

import handlung.DruckTastaturHandlung;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes spiel.leerdrucktastatur.Main
*/

public class Main{
    public static void main(String[] args) {
	DruckTastaturHandlung h = new DruckTastaturHandlung();
	LeerDruckTastaturSpiel s = new LeerDruckTastaturSpiel();
	s.spielen(h);
    }
}
