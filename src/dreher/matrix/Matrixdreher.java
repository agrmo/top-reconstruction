package dreher.matrix;

import matrix.Dreimatrix;

public class Matrixdreher {

    /* Bauen eine Matrix, die um die x-Achse (in der yz-Fläche) dreht.
       
       |1 0    0  |
       |0 cos  sin|
       |0 -sin cos|
     */
    public static Dreimatrix machedreherx(double theta) {
	return new Dreimatrix(1, 0, 0,
			      0, Math.cos(theta), Math.sin(theta),
			      0, -Math.sin(theta), Math.cos(theta));
    }

    /* Bauen eine Matrix, die um die y-Achse (in der zx-Fläche) dreht.
       
       |cos 0  -sin|
       |0   1  0   |
       |sin 0  cos |
     */
    public static Dreimatrix machedrehery(double theta) {
	return new Dreimatrix(Math.cos(theta), 0, -Math.sin(theta),
			      0, 1, 0,
			      Math.sin(theta), 0, Math.cos(theta));
    }

    /* Bauen eine Matrix, die um die z-Achse (in der xy-Fläche) dreht.
       
       |cos  sin 0|
       |-sin cos 0|
       |0    0   1|
     */
    public static Dreimatrix machedreherz(double theta) {
	return new Dreimatrix(Math.cos(theta), Math.sin(theta), 0,
			      -Math.sin(theta), Math.cos(theta), 0,
			      0, 0, 1);
    }
}

