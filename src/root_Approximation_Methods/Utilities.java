package root_Approximation_Methods;

import static java.lang.Math.pow;

public class Utilities {
	public static double function(double x) {
		double fx;
		fx = Math.cos(x) - Math.exp(-1 * pow(x, 2)) + x;
		return fx;
	}

	public static double derivative1(double x) {
		double dx = 2 * x;
		return dx;
	}

}
