package linear_System_Iterative_Methods;

public class Linear_System_Iterative_Methods {
	public static void main(String[] args) {
		double matriz[][] = new double[][] { { 10, 2, 1}, { 1, 5, 1}, { 2, 3, 10}};
		double b[] = new double[] { 7, -8, 6};
		double x0[] = new double[] { 0, 0, 0};
		Gauss_Jacobi(matriz, b, x0, 0.05);
	}

	// Gauss Jacobi Method
	private static void Gauss_Jacobi(double C[][], double g[], double x0[], double tol) {
		int count = 0;
		double x1[] = new double[x0.length];
		double sup, inf = 1, err = 0;

		System.out.println("Gauss-Jacobi Method\n");
		
		// print the matrix
		System.out.println("Matrix: ");
		for (int i = 0; i < C.length; i++) {
			System.out.print("|");
			for (int j = 0; j < C.length; j++) {
				System.out.print(C[i][j] + "\t");
			}
			// print the array b
			System.out.print(g[i]);
			if (g[i] < 0)
				System.out.print("|\n");
			else
				System.out.print(" |\n");
		}
		
		// print array x0
				System.out.print("\nx0: ");
				System.out.print("[");
				for (int k = 0; k < x0.length; k++) {
					System.out.format("%.4f", x0[k]);
					if (k != x0.length - 1)
						System.out.print("   ");
				}
				System.out.println("]");
		System.out.print("---------------------------------");
		for(int i = 3; i<C.length; i++)
			System.out.print("----------");
		System.out.println("");
		
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
			System.out.print("[");
			for (int i = 0; i < x0.length; i++) {
				System.out.format("%.4f", x0[i]);
				if (i != x0.length - 1)
					System.out.print("   ");
			}
			System.out.println("]\n");

			// print array x1
			System.out.print("x" + ++count + ": ");
			System.out.print("[");
			for (int i = 0; i < x1.length; i++) {
				System.out.format("%.4f", x1[i]);
				if (i != x0.length - 1)
					System.out.print("   ");
			}
			System.out.println("]\n");

			// fill in the array x0 with the values of array x1
			for (int i = 0; i < x0.length; i++) {
				x0[i] = x1[i];
			}

			System.out.format(" Tol: %.4f\n", tol);
			// print error
			System.out.format("Erro: %.4f\n", err);
			System.out.print("---------------------------------");
			for(int i = 3; i<C.length; i++)
				System.out.print("----------");
			System.out.println("");
		} while (err > tol);
		System.out.println("Gauss-Jacobi Method");
	}

	// Gauss Seidel Method
	private static void Gauss_Seidel(double C[][], double g[], double x0[], double tol) {
		int count = 0;
		double sup, inf = 1, err = 0, aux;

		System.out.println("Gauss-Seidel Method\n");
		// print the matrix
		System.out.println("Matrix: ");
		for (int i = 0; i < C.length; i++) {
			System.out.print("|");
			for (int j = 0; j < C.length; j++) {
				System.out.print(C[i][j] + "\t");
			}
			// print the array b
			System.out.print(g[i]);
			if (g[i] < 0)
				System.out.print("|\n");
			else
				System.out.print(" |\n");
		}

		// print array x0
		System.out.print("\nx0: ");
		System.out.print("[");
		for (int k = 0; k < x0.length; k++) {
			System.out.format("%.4f", x0[k]);
			if (k != x0.length - 1)
				System.out.print("   ");
		}
		System.out.println("]");
		System.out.print("---------------------------------");
		for(int i = 3; i<C.length; i++)
			System.out.print("----------");
		System.out.println("");
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
				System.out.print("[");
				for (int k = 0; k < x0.length; k++) {
					System.out.format("%.4f", x0[k]);
					if (k != x0.length - 1)
						System.out.print("   ");
				}
				System.out.println("]\n");
			}
			
			System.out.format(" Tol: %.4f\n", tol);
			// print error
			System.out.format("Erro: %.4f\n", err);
			System.out.print("---------------------------------");
			for(int i = 3; i<C.length; i++)
				System.out.print("----------");
			System.out.println("");
		} while (err > tol);
		System.out.println("Gauss-Seidel Method");
	}
}
