/**
 * 
 */
package root_Approximation_Methods;

import utilities.Error;

/**
 * @author gianluca.mello
 *
 */
public class Bisection {
	private static void method(double x0, double a, double b, double tol) {
		int count = 0;
		double error;
		System.out.println("Bissecção\n");
		do {
			x0 = (a + b) / 2;
			error = Error.absolutError(b, a);
			System.out.format("Iteração: %d\tValor: %.5f\tErro: %.5f\n", count++, x0, error);
			if (Utilities.function(x0) == 0) {
				break;
			}
			if ((Utilities.function(x0) * Utilities.function(a)) < 0) {
				b = x0;
			} else {
				a = x0;
			}
		} while (error > tol);
	}

}
