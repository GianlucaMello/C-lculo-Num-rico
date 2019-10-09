package linear_System_Iterative_Methods;

import utilities.Print;

/**
 * @author Gianluca Mello
 *
 */

public class Gauss_Seidel {
	public void method(double C[][], double g[], double x0[], double tol) {
		int count = 0;
		double sup, inf = 1, err = 0, aux;

		System.out.println("Gauss-Seidel Method\n");

		// print the matrix
		Print.printMatrix(C, g);

		// print array x0
		System.out.print("x0: ");
		Print.printArray(x0);
		System.out.println("---------------------------------");

		// x0[i]=sup/inf;
		do {
			System.out.println("Iteração: " + count++ + "\n");
			err = 0;
			for (int i = 0; i < C.length; i++) {
				sup = g[i];
				for (int j = 0; j < C.length; j++) {
					if (i == j) {
						inf = C[i][j];
					}
					if (i != j) {
						sup -= (C[i][j] * x0[j]);
					}
				}
				aux = sup / inf;

				// Error Calculation
				if (Math.abs(x0[i] - aux) > err) {
					err = Math.abs(x0[i] - aux);
				}
				x0[i] = aux;

				// print array x0
				System.out.print("x0: ");
				Print.printArray(x0);
			}

			// print tolerance
			System.out.format(" Tol: %.4f\n", tol);

			// print error
			System.out.format("Erro: %.4f\n", err);
			System.out.println("---------------------------------");
		} while (err > tol);
		System.out.println("Gauss-Seidel Method");
	}
}
