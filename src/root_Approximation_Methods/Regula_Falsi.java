/**
 * 
 */
package root_Approximation_Methods;

import utilities.Error;

/**
 * @author gianluca.mello
 *
 */
public class Regula_Falsi {
	private static void method(double a, double b, double tol) {
		int count = 0;
		double x0, error = 0;
		System.out.println("Regula Falsi\n");
		do {
			x0 = ((a * Utilities.function(b) - b * Utilities.function(a))
					/ (Utilities.function(b) - Utilities.function(a)));
			if (Utilities.function(x0) == 0) {
				break;
			}
			if ((Utilities.function(x0) * Utilities.function(a)) < 0) {
				error = Error.absolutError(b, x0);
				b = x0;
			} else if ((Utilities.function(x0) * Utilities.function(b)) < 0) {
				error = Error.absolutError(a, x0);
				a = x0;
			} else {
				error = 0;
				System.out.println("Erro");
				break;
			}
			System.out.format("Iteração: %d\tValor: %.5f\t\tErro: %.5f\n", count++, x0, error);
		} while (error > tol && count < 10);
		System.out.println("\n");

	}
}
