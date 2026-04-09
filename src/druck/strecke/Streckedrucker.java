package druck.strecke;

import strecke.Zweistrecke;
import strecke.Dreistrecke;
import druck.vektor.Vektordrucker;

public class Streckedrucker {
    public static String drucke(Zweistrecke k) {
	StringBuilder sb = new StringBuilder();
	sb.append("Von ");
	sb.append(Vektordrucker.drucke(k.von));
	sb.append(" bis ");
	sb.append(Vektordrucker.drucke(k.bis));

	return sb.toString();
    }

    public static String drucke(Dreistrecke k) {
	StringBuilder sb = new StringBuilder();
	sb.append("Von ");
	sb.append(Vektordrucker.drucke(k.von));
	sb.append(" bis ");
	sb.append(Vektordrucker.drucke(k.bis));

	return sb.toString();
    }
}
