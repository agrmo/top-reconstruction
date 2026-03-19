package bogen;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes bogen.Main
*/

public class Main {
    static void beispielEins() {
	Bogen b = new Bogen(5, 5, 50, 20);
    }

    public static void main(String[] args) {
	beispielEins();
    }
}
