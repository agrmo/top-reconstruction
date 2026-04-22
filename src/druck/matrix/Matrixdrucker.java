package druck.matrix;

import matrix.Dreimatrix;
import matrix.Zweimatrix;

public class Matrixdrucker {

    public static String drucke(Zweimatrix m) {
	StringBuilder sb = new StringBuilder();

	sb.append("\n|");
	sb.append(m.a);
	sb.append(" ");
	sb.append(m.b);
	sb.append("|\n|");
	sb.append(m.c);
	sb.append(" ");
	sb.append(m.d);
	sb.append("|");
	
	return sb.toString();
    }

    
    public static String drucke(Dreimatrix m) {
	StringBuilder sb = new StringBuilder();

	sb.append("\n|");
	sb.append(m.a);
	sb.append(" ");
	sb.append(m.b);
	sb.append(" ");
	sb.append(m.c);
	sb.append("|\n|");
	sb.append(m.d);
	sb.append(" ");
	sb.append(m.e);
	sb.append(" ");
	sb.append(m.f);
	sb.append("|\n|");
	sb.append(m.g);
	sb.append(" ");
	sb.append(m.h);
	sb.append(" ");
	sb.append(m.i);
	sb.append("|");
	
	return sb.toString();
    }
}
