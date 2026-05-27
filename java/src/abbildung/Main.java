package abbildung;

import java.util.HashMap;
import liste.Liste;

/*
javac -d classes $(find src -type f) && java -cp classes abbildung.Main
*/

public class Main {
    static void beispieleins() {
	HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
	m.put(1,6);
	m.put(5,2);

	int[][] arrayarray = Abbildung.nehmeArrayArrayVonAbbildung(m);
	String arrayarrayString = Liste.nehmeStringVonArrayArray(arrayarray);
	System.out.println(arrayarrayString);	
    }
    
    public static void main(String[] args) {
	beispieleins();
    }
}
