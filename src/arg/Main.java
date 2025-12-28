package arg;

/*
javac src/arg/*.java -d classes && java -cp classes arg.Main Hello World
*/

public class Main {
    public static void main(String[] args) {
	System.out.println(args[0]);
        System.out.println(args[1]);
    }
}
