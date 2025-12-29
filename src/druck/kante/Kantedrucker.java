package druck.kante;

import kante.Zweikante;
import kante.Dreikante;
import druck.punkt.Punktdrucker;

public class Kantedrucker {
    public static String drucken(Zweikante k) {
	StringBuilder sb = new StringBuilder();
	sb.append("Von ");
	sb.append(Punktdrucker.drucken(k.von));
	sb.append(" bis ");
	sb.append(Punktdrucker.drucken(k.bis));

	return sb.toString();
    }

    public static String drucken(Dreikante k) {
	StringBuilder sb = new StringBuilder();
	sb.append("Von ");
	sb.append(Punktdrucker.drucken(k.von));
	sb.append(" bis ");
	sb.append(Punktdrucker.drucken(k.bis));

	return sb.toString();
    }
}
