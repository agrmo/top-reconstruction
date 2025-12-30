package spiel.leerdruckmouse;

import handlung.Handlung;
import handlung.DruckMouseHandlung;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes spiel.leerdruckmouse.Main
*/

public class Main{
    public static void main(String[] args) {
	DruckMouseHandlung h = new DruckMouseHandlung();
	LeerDruckMouseSpiel s = new LeerDruckMouseSpiel();
	s.spielen(h);
    }
}
