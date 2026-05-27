package spiegel;

/*
  javac -d classes $(find src -type f) \
  && java -cp classes spiegel.Main
*/

public class Main {

    static void weinwausx(double weingrad) {
	double weinradiant = (Math.PI / 180.0) * weingrad;
	double wausgrad = (180.0 / Math.PI) * Spiegel.spiegelexrad(weinradiant);
	System.out.println(wausgrad);
    }

    static void weinwausy(double weingrad) {
	double weinradiant = (Math.PI / 180.0) * weingrad;
	double wausgrad = (180.0 / Math.PI) * Spiegel.spiegeleyrad(weinradiant);
	System.out.println(wausgrad);
    }
    
    static void beispieleins() {
	// x Q1
	weinwausx(10.0);
	// 350	
    }

    static void beispielzwei() {
	// x Q2
	weinwausx(170.0);
	// 190	
    }

    static void beispieldrei() {
	// x Q3
	weinwausx(190.0);
	// 170
    }

    static void beispielvier() {
	// x Q4
	weinwausx(350);
	// 10	
    }

    static void beispielfuenf() {
	// y Q1
	weinwausy(10.0);
	// 170
    }

    static void beispielsechs() {
	// y Q2
	weinwausy(120.0);
	// 60
    }

    static void beispielsieben() {
	// y Q3
	weinwausy(260.0);
	// 280
    }

    static void beispielacht() {
	// y Q4
	weinwausy(280);
	// 260
    }
    
    public static void main(String[] args) {
	beispieleins();
    }
}
