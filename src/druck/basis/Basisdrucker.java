package druck.basis;

import basis.Zweibasis;
import basis.Dreibasis;
import druck.vektor.Vektordrucker;

public class Basisdrucker {
    public static String drucken(Zweibasis b) {
	StringBuilder sb = new StringBuilder();
	sb.append("[");
	sb.append(Vektordrucker.drucken(b.eins));
	sb.append(",");
	sb.append(Vektordrucker.drucken(b.zwei));
	sb.append("]");
	return sb.toString();
    }

    public static String drucken(Dreibasis b) {
	StringBuilder sb = new StringBuilder();
	sb.append("[");
	sb.append(Vektordrucker.drucken(b.eins));
	sb.append(",");
	sb.append(Vektordrucker.drucken(b.zwei));
	sb.append(",");
	sb.append(Vektordrucker.drucken(b.drei));
	sb.append("]");
	return sb.toString();
    }
}
