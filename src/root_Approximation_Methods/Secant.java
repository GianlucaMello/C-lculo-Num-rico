/**
 * 
 */
package root_Approximation_Methods;

import utilities.Error;

/**
 * @author gianluca.mello
 *
 */
public class Secant {
	public static void method(double x0, double x1, double tol) {
		double x2, error, f0, f1;
		int count = 0;
		System.out.println("Secante\n");
		do {
			f0 = Utilities.function(x0);
			f1 = Utilities.function(x1);
			x2 = ((x0 * f1) - (x1 * f0)) / (f1 - f0);
			x0 = x1;
			x1 = x2;
			error = Error.absolutError(x0, x1);
			System.out.format("Iteração: %d \tValor: %.10f   \tErro: %.10f\n", count++, x2, error);

		} while (error > tol || count > 100);
	}

}
