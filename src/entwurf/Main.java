package entwurf;

/*
  javac -d classes src/entwurf/* && java -cp classes entwurf.Main
*/

public class Main {
    public static void main(String[] args) {
	int a = 5;
	double b = 0.5;
	int c = (int) (((double) a) * b);

	System.out.println(c);
    }
}
