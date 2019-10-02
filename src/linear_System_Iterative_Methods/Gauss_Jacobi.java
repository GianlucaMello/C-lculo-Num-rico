/**
 * 
 */
package linear_System_Iterative_Methods;

import utilities.Print;

/**
 * @author Gianluca Mello
 *
 */

public class Gauss_Jacobi {

	public void method(double C[][], double g[], double x0[], double tol) {
		int count = 1;
		double x1[] = new double[x0.length];
		double sup, inf = 1, err = 0;

		System.out.println("Gauss-Jacobi Method\n");

		// call method printMatrix to print the matrix C
		Print.printMatrix(C, g);

		// print array x0
		System.out.print("x0: ");
		Print.printVector(x0);
		System.out.println("---------------------------------");

		// x1=sup/inf;
		do {
			err = 0;
			for (int i = 0; i < C.length; i++) {
				sup = g[i];
				for (int j = 0; j < C.length; j++) {
					if (i == j) {
						inf = C[i][j];
					}
					if (i != j) {
						sup = sup - (C[i][j] * x0[j]);
					}
				}
				x1[i] = sup / inf;

				// Error Calculation
				if (Math.abs(x0[i] - x1[i]) > err) {
					err = Math.abs(x0[i] - x1[i]);
				}
			}

			System.out.println("Iteração: " + count + "\n");

			// print array x0
			System.out.print("x" + count + ": ");
			Print.printVector(x0);

			// print array x1
			System.out.print("x" + ++count + ": ");
			Print.printVector(x1);

			// fill in the array x0 with the values of array x1
			for (int i = 0; i < x0.length; i++) {
				x0[i] = x1[i];
			}

			// print tolerance
			System.out.format(" Tol: %.4f\n", tol);
			// print error
			System.out.format("Erro: %.4f\n", err);
			System.out.println("---------------------------------");
		} while (err > tol);
		System.out.println("Gauss-Jacobi Method");
	}
}
