package druck.strecke;

import strecke.Zweistrecke;
import strecke.Dreistrecke;
import druck.vektor.Vektordrucker;

public class Streckedrucker {
    public static String drucken(Zweistrecke k) {
	StringBuilder sb = new StringBuilder();
	sb.append("Von ");
	sb.append(Vektordrucker.drucken(k.von));
	sb.append(" bis ");
	sb.append(Vektordrucker.drucken(k.bis));

	return sb.toString();
    }

    public static String drucken(Dreistrecke k) {
	StringBuilder sb = new StringBuilder();
	sb.append("Von ");
	sb.append(Vektordrucker.drucken(k.von));
	sb.append(" bis ");
	sb.append(Vektordrucker.drucken(k.bis));

	return sb.toString();
    }
}
