package liste;

import java.util.ArrayList;
import java.util.Arrays;

/*
javac -d classes $(find src -type f) && java -cp classes liste.Main
*/

public class Main {

    static void beispieleins() {
	// drucken eine Liste von Liste von ganzen Zahlen...
	ArrayList<int[]> a = new ArrayList<int[]>();
	a.add(new int[] {1,2});
	int[][] aArray = Liste.nehmeArrayListArrayInteger(a);
	for (int[] zeile : aArray) {
	    System.out.println(Arrays.toString(zeile));
	}

	// drucken eine Liste von Liste von ganzen Zahlen...
	ArrayList<ArrayList<Integer>> b = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> bZeile = new ArrayList<Integer>();
	bZeile.add(1);
	bZeile.add(2);
	b.add(bZeile);
	int[][] paarearray = Liste.nehmeArrayListArrayListInteger(b);
	for (int[] zeile : aArray) {
	    System.out.println(Arrays.toString(zeile));
	}	
    }

    static void beispielzwei() {
	// drucken eine Liste von Liste von Double...
	ArrayList<double[]> a = new ArrayList<double[]>();
	a.add(new double[] {1.53,2.371});
	double[][] aArray = Liste.nehmeArrayListArrayDouble(a);
	for (double[] zeile : aArray) {
	    System.out.println(Arrays.toString(zeile));
	}

	// drucken eine Liste von Liste von Double...
	ArrayList<ArrayList<Double>> b = new ArrayList<ArrayList<Double>>();
	ArrayList<Double> bZeile = new ArrayList<Double>();
	bZeile.add(1.9851);
	bZeile.add(2.27461);
	b.add(bZeile);
	double[][] paarearray = Liste.nehmeArrayListArrayListDouble(b);
	for (double[] zeile : aArray) {
	    System.out.println(Arrays.toString(zeile));
	}	
    }

    static void beispieldrei() {
	double[][] doubleArrayArray = new double[2][];
	doubleArrayArray[0] = new double[] {0.01,0.25};
	doubleArrayArray[1] = new double[] {0.6,0.9};
	String doubleArrayArrayString = Liste.nehmeStringVonArrayArrayDouble(doubleArrayArray);
	System.out.println(doubleArrayArrayString);			
    }

    static void beispielvier() {
	ArrayList<Integer> l = new ArrayList<Integer>();
	l.add(4);
	l.add(5);
	System.out.println(Arrays.toString(Liste.nehmeArrayInt(l)));		
    }

    static void beispielfuenf() {
	int[][] a = new int[5][2];

	a[0] = new int[]{1,2};
	a[1] = new int[]{3,4};
	a[2] = new int[]{5,6};
	a[3] = new int[]{7,8};
	a[4] = new int[]{9,10};

	System.out.println(Liste.nehmeStringVonArrayArray(a));		
    }

    public static void main(String[] args) {
	beispielfuenf();
    }
}
