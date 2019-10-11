package linear_System_Iterative_Methods;

import utilities.Print;

/**
 * @author Gianluca Mello
 *
 */

public class Gauss_Seidel {
	public void method(double C[][], double g[], double x0[], double tol) {
		int count = 0;
		double sup, inf = 1, err = 0, aux, B, sum = 0;
		double[] beta = new double[x0.length];
		boolean converge = true;

		System.out.println("Gauss-Seidel Method\n");

		// print the matrix
		Print.printMatrix(C, g);

		for (int i = 0; i < C.length; i++) {
			if (C[i][i] == 0) {
				System.out.format("\nC[%d][%d] = 0\n",i,i);
				System.out.format("\nDivisão por zero na linha %d\n\n", i);
			}

			sum = 0;
			if (i == 0) {
				for (int j = 1; j < C.length; j++) {
					sum += Math.abs(C[i][j]);
				}
			} else {
				for (int j = 0; j < C.length; j++) {
					if (i > j)
						sum += beta[i] * Math.abs(C[i][j]);
					else if (i < j) {
						sum += Math.abs(C[i][j]);
					}
				}
			}

			beta[i] = sum / Math.abs(C[i][i]);
			if (beta[i] >= 1) {
				System.out.println("Método não tem garantia devido a linha: " + i);
				converge = false;
			}
		}
		if (converge)
			System.out.println("Método converge para qualquer valor de x0\n");
		else
			System.out.println("Método pode não convergir\n");

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
				System.out.format("x%d: %.4f\n", i, x0[i]);

			}
			System.out.format("\nx%d: ", count);
			Print.printArray(x0);

			// print tolerance
			System.out.format(" Tol: %.4f\n", tol);

			// print error
			System.out.format("Erro: %.4f\n", err);
			System.out.println("---------------------------------");
		} while (!(err < tol || count > 50));
		System.out.println("Gauss-Seidel Method");
	}
}
