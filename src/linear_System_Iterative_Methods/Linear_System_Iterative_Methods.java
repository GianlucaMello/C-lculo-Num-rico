package linear_System_Iterative_Methods;

public class Linear_System_Iterative_Methods {
	public static void main(String[] args) {
		double aux[][] = new double[][] 
				{{ 9, -6, -3, -4, -5, -5, -8, 6, -2, 2, -7, -1, 4, -9, 4, 5, 9, 4, 9, -5, -15.13620337 },
				{ -8, 5, -7, -8, 0, 2, 10, -8, -2, -8, 10, -2, -10, 2, 7, -7, 6, -8, -4, -8, -39.00404466 },
				{ 0, -1, -3, 9, -5, -4, -7, 8, 0, -3, -1, -2, -8, 10, -1, 5, -9, 10, 1, -9, 97.77414194 },
				{ 9, -10, 7, -10, -4, 7, 4, 9, 9, -2, 2, 10, -2, 1, 2, 8, 4, -4, 6, 5, 77.49451566 },
				{ -6, -8, -4, 3, 0, 6, 4, -3, 3, -5, -2, -7, -9, -10, 8, 0, -9, -7, 3, 0, 88.98422281 },
				{ 8, 1, 5, -1, -7, 6, -6, -8, -7, 8, 6, 2, -6, -7, 5, 7, -9, -6, 3, -9, -30.08865658 },
				{ 7, 1, 3, -6, -9, 4, 0, 5, -4, -2, -2, -2, -6, 0, -6, 0, 4, -3, 0, -6, -31.79366138 },
				{ -8, 6, -1, -9, 0, -10, -10, -10, 5, -10, -2, 4, -10, 2, 7, 1, -5, -6, 0, -4, 2.706242335 },
				{ 7, -2, -8, -5, -2, -9, 10, -7, -8, -2, 5, 2, 3, -3, 4, -10, 10, 5, 4, -5, -47.27926512 },
				{ 7, -9, 6, 5, 5, -6, -3, -3, 1, -4, 0, -6, 10, 0, 7, 8, -5, 10, -4, -3, 28.16297901 },
				{ 6, -9, 4, 5, -1, -5, 10, 10, -8, 9, 3, 9, -9, 6, -10, 5, -1, -7, -5, 3, -2.672380611 },
				{ 4, 3, -10, -1, -3, 5, 4, -10, 2, -8, -4, 9, 7, 7, 6, -3, 1, -4, -6, 2, -22.54696639 },
				{ 7, 10, 10, 2, 6, -7, 10, 1, 2, 6, -6, 8, 6, 10, 1, -1, 7, -2, 5, 9, -2.54743802 },
				{ -7, 9, 9, -3, 10, 4, 6, 3, -9, -2, -6, -4, -6, 3, -8, -6, 7, 1, 8, -9, -146.1374418 },
				{ 1, 1, -4, -4, -4, 1, -5, -6, -4, -1, 5, 7, -2, -5, 9, -2, 0, 4, 3, -8, -33.24042277 },
				{ 5, 0, -10, -6, -7, -1, 8, 4, 1, -10, 4, -9, -4, -7, -4, 3, 5, 8, 2, 6, -22.63040472 },
				{ -10, -2, 10, 7, -7, 5, -8, 6, 5, 8, 9, -7, -5, -10, 7, -1, -2, -4, 2, 7, 154.6761739 },
				{ -6, 6, 1, 4, 0, -2, 3, -8, 9, -6, 7, -6, -4, -2, 10, 7, 10, 1, 1, 2, 9.713142717 },
				{ 1, -8, 8, -9, 10, 7, -5, 5, -2, -9, 10, 5, 6, 0, -8, -8, -3, 7, -7, -1, -57.9061427 },
				{ 6, 9, -7, -4, -2, 0, 3, 1, -9, -7, 0, -8, 1, -5, -8, -4, 10, -3, 8, 6, -126.9036292 } };
		
		double matriz[][] = new double[aux.length][aux.length]; 
				for(int i=0; i<matriz.length; i++) {
					for(int j=0; j<matriz.length; j++) {
						matriz[i][j]=aux[i][j];
					}
				}
				//{ { 10, 2, 1}, { 1, 5, 1}, { 2, 3, 10}};
		double b[] = new double[aux.length];
			for(int i =0; i<b.length; i++) {
				b[i]=aux[i][aux.length];
			}
				
				//{ 7, -8, 6};
		double x0[] = new double[] { 1,01,01,01,01,01,01,01,01,01,01,01,01,01,01,01,01,01,01,01};
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
