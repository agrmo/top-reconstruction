package dreher.zweimatrix;

import matrix.Zweimatrix;

public class Zweimatrixdreher {

    /* Baue eine Matrix, um eine zweidimensionale Drehung zu machen.
       
       |cos  -sin|
       |sin  cos |
    */
    public static Zweimatrix nehmedrehung(double theta) {
	
	return new Zweimatrix(Math.cos(theta), -Math.sin(theta),
			      Math.sin(theta), Math.cos(theta));
    }
}

