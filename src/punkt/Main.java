package punkt;

import java.util.Arrays;

/*
  javac -d classes $(find src -name '*.java') && java -cp classes punkt.Main
*/

public class Main {
    static void beispielEins() {
	Punkt p = new Punkt(1,2,3);
	System.out.println(p.drucken());
    }

    static void beispielZwei() {
	Punkt pa = new Punkt(1,2,3);
	System.out.println(pa.drucken());
	Punkt pb = new Punkt(5,5,5);
	pa.addieren(pb);
	System.out.println(pa.drucken());	
    }
    
    public static void main(String[] args) {
	beispielZwei();
    }
}
