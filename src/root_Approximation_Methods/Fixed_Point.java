/**
 * 
 */
package root_Approximation_Methods;

import utilities.Error;

/**
 * @author gianluca.mello
 *
 */
public class Fixed_Point {
	private static void method(double x0, double x1, double tol) {
		double error = 0;
		int count = 0;
		System.out.println("I\tXn\tErro\n");
		do {
			error = Error.absolutError(x0, x1);
			System.out.format("%d\t%.5f\t%.5f\n", count++, Utilities.function(x1), error);
			x0 = x1;
			x1 = Utilities.function(x1);
		} while (error > tol);

	}
}
