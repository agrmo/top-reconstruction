package menge;

import java.util.Arrays;
import java.util.HashSet;

/*
javac -d classes $(find src -type f) && java -cp classes menge.Main
*/

public class Main {
    static void beispieleins() {
	HashSet<Integer> s = new HashSet<Integer>();
	s.add(1);
	s.add(2);
	s.add(5);
	s.add(6);

	int[] a = Menge.nehmeArrayVonMenge(s);
	System.out.println(Arrays.toString(a));
    }
    
    public static void main(String[] args) {
	beispieleins();
    }
}
