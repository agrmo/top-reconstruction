package spiegel;

/*
  Ein Spiegeler spiegelt einen Winkel um eine Achse.

  Spiegelung um y-Achse
  - Quadrant I: 180 - theta
  - Quadrant II: 180 - theta
  - Quadrant III: 540 - theta
  - Quadrant IV: 540 - theta

  Spiegelung um x-Achse
  - Quadrant I: 360 - theta
  - Quadrant II: 360 - theta
  - Quadrant III: 360 - theta
  - Quadrant IV: 360 - theta
*/
public class Spiegel {
    
    public static double spiegelexgrad(double theta) {

	if (theta >= 0.0 && theta <= 360.0) {
	    // Fall Q1, Q2, Q3, Q4
	    return 360.0 - theta;
	}
	
	System.out.println("Dieser Winkel hat eine unbekannte Größe: " + theta);
	System.out.println("Gebe 0 aus");
	return 0.0;
    }

    public static double spiegeleygrad(double theta) {

	if (theta >= 0.0 && theta <= 90.0) {
	    // Fall Q1
	    return 180 - theta;
	    
	} else if (theta >= 90.0 && theta <= 180.0) {
	    // Fall Q2
	    return 180 - theta;
	    
	} else if (theta >= 180.0 && theta < (3.0 / 2.0) * 180.0) {
	    // Fall Q3
	    return (3.0 * 180) - theta;
	    
	} else if (theta >= (3.0 / 2.0) * 180.0 && theta <= 2.0 * 180.0) {
	    // Fall Q4
	    return (3.0 * 180) - theta;
	}

	System.out.println("Dieser Winkel hat eine unbekannte Größe: " + theta);
	System.out.println("Gebe 0 aus");
	return 0.0;
    }

    // Spiegele den gegebenen Winkel um die x-Achse.
    public static double spiegelexrad(double theta) {

	double grad = theta * (180.0 / Math.PI);
	return Spiegel.spiegelexgrad(grad);
    }

    // Spiegele den gegebenen Winkel um die y-Achse.
    public static double spiegeleyrad(double theta) {

	double grad = theta * (180.0 / Math.PI);
	return Spiegel.spiegeleygrad(grad);
    }
}
