package liste;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

	Liste l = new Liste();
	
	// drucken eine Liste von Liste...
	ArrayList<int[]> a = new ArrayList<int[]>();
	a.add(new int[] {1,2});
	int[][] aArray = l.nehmeArrayListArray(a);
	for (int[] zeile : aArray) {
	    System.out.println(Arrays.toString(zeile));
	}

	// drucken eine Liste von Liste...
	ArrayList<ArrayList<Integer>> b = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> bZeile = new ArrayList<Integer>();
	bZeile.add(1);
	bZeile.add(2);
	b.add(bZeile);
	int[][] paarearray = l.nehmeArrayListArrayList(b);
	for (int[] zeile : aArray) {
	    System.out.println(Arrays.toString(zeile));
	}


    }
}
