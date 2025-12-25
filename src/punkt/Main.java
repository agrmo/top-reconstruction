package punkt;

import java.util.Arrays;

/*
  javac -d classes $(find src -name '*.java') && java -cp classes punkt.Main
*/

public class Main {
    public static void main(String[] args) {
	Punkt p = new Punkt(new int[] {1,2,3});

	System.out.println(Arrays.toString(p.teile));
    }
}
