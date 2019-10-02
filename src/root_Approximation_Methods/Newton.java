package root_Approximation_Methods;

import utilities.Error;

public class Newton {
	private static void method(double x0, double tol) {
		double x1, error = 0, d0 = 0, d1 = 0;
		int count = 0;
		System.out.println("Newton\n");
		System.out.format("Iteração \tValor \t\tErro\n");
		System.out.format("%d \t\t%.9f \t%.9f\n", count, x0, 0.0);

		count++;
		do {
			d0 = Utilities.function(x0);
			d1 = Utilities.derivative1(x0);
			x1 = x0 - (d0 / d1);
			error = Error.absolutError(x0, x1);
			System.out.format("%d \t\t%.9f \t%.9f\n", count++, x1, error);
			x0 = x1;
		} while (error > tol || count > 100);
		System.out.print("---------------------------------------------\n\n\n\n");
	}

}
