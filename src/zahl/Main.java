package zahl;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
	boolean flag = true;
	char grade = 'A';
	byte b = 12;
	short s = 24;
	int i,j,k = 257;
	long l = 290L;
	float pi = 3.14F;
	double e = 2.71;
	
	System.out.println(flag);
	System.out.println(grade);
	System.out.println(b);
	System.out.println(s);
	System.out.println(pi);

	Counter c = new Counter();
	System.out.println("Count: " + c.getCount());
	c.increment();
	c.increment(5);
	System.out.println("Count: " + c.getCount());

	Map<String,Integer> m = new HashMap<String,Integer>();
	m.put("a", 1);
	m.put("b", 2);
	m.put("c", 3);

	System.out.println("Map elements:" + m);

	int[][] arrayarray = {{4,5,6},{7,8,9}};
	for (int[] arraya : arrayarray) {
	    System.out.println(Arrays.toString(arraya));   
	}

	// ArrayList ma = new ArrayList<Integer>(Arrays.asList(3,4));
	// ma.add(2);
	// ma.add(5);
	// System.out.println(ma);

	// Map<Integer,List<Integer>> intToListInt = new HashMap<Integer,List<Integer>>();
	// intToListInt.put(1,Arrays.asList(3,4));
	// System.out.println(intToListInt);

	// Map<Integer,int[]> intToListInt = new HashMap<Integer,int[]>();
	// intToListInt.put(1,new int[] {3,4});
	// System.out.println(intToListInt);

	int[] funfarray = new int[5];
	funfarray[0] = 1;
	System.out.println(Arrays.toString(funfarray));
	System.out.println(funfarray.length);

	// Zufallsvariabeln
	System.out.println(Math.random());

        // N.b.!
        System.out.println((1/2)*5*(5-1));
        System.out.println((1/2)*4*(4-1));
        System.out.println((0.5)*5.0*(5.0-1));
        System.out.println((0.5)*4.0*(4.0-1));

	// drucken eine Liste von Liste...
	ArrayList<int[]> paare = new ArrayList<int[]>();
	paare.add(new int[] {1,2});
	System.out.println(Arrays.toString(paare.get(0)));
    }
}
