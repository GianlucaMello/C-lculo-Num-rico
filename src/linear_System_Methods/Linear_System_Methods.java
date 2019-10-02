package linear_System_Methods;

public class Linear_System_Methods {
	public static void main(String[] args) {
		double[][] matriz;
		// float[] b;
		// matriz = new float[][]{
		// {2, 3, -1, 5},
		// {4, 4, -3, 3},
		// {2,-3, 1, -1}};
		// b = new float[]{5,3,-1};

		matriz = new double[][] 
				/**{{ 9, -6, -3, -4, -5, -5, -8, 6, -2, 2, -7, -1, 4, -9, 4, 5, 9, 4, 9, -5, -15.13620337 },
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
				{ 6, 9, -7, -4, -2, 0, 3, 1, -9, -7, 0, -8, 1, -5, -8, -4, 10, -3, 8, 6, -126.9036292 } };*/

		
		 { { 2, 2, 1, 1, 7 }, { 1, -1, 2, -1, 1 }, { 3, 2, -3, -2, 4 }, { 4, 3, 2, 1,12 } };

		gauss_Elimination_Partial_Pivoting(matriz);
	}

	// Gauss Elimination Method
	private static void gaussElimination(double matrix[][]) {
		double mult, sum;
		double[] b = new double[matrix.length];

		System.out.println("Matrix");
		for (int i = 0; i < matrix.length; i++) {
			printMatrix(matrix);
			System.out.println();
			
			//Transforma a matriz em uma triangular superior
			System.out.println("Zerando a coluna " + i);
			for (int j = 0; j < matrix.length; j++) {
				if (i < j) {
					mult = matrix[j][i] / matrix[i][i];
					for (int k = 0; k < matrix[0].length; k++) {
						matrix[j][k] = matrix[j][k] - mult * matrix[i][k];
					}
				}
			}
		}
		printMatrix(matrix);
		
		//calcula o valor de Xn
		b[matrix.length - 1] = matrix[matrix.length - 1][matrix.length] / matrix[matrix.length - 1][matrix.length - 1];
		
		//Calcula o valor dos outros X, de baixo para cima
		for (int i = matrix.length - 1; i >= 0; i--) {
			sum = 0;
			for (int j = i + 1; j < matrix.length; j++) {
				sum += matrix[i][j] * b[j];
			}
			b[i] = (matrix[i][matrix.length] - sum) / matrix[i][i];
		}
		System.out.println("\nThe solution is: ");
		for (int i = 0; i < b.length; i++) {
			System.out.format("x%d = %.5f\n", i, b[i]);
		}
	}

	private static void gauss_Elimination_Partial_Pivoting(double matrix[][]) {
		int l = 0;
		double mult, sum, max = 0;
		double[] b = new double[matrix.length];
		double aux;

		System.out.println("Matrix");
		for (int i = 0; i < matrix.length; i++) {
			System.out.println("Iteração: "+i);
			printMatrix(matrix);
			System.out.println("Zerando a coluna " + i);
			for (int j = 0; j < matrix.length; j++) {
				
				//Verifica qual o maior valor entre os coeficiêntes da coluna atual
				if (i == j && i != matrix.length - 1) {
					max = 0;
					for (int x = i; x < matrix.length; x++) {
						if (Math.abs(matrix[x][j]) > max) {
							max = Math.abs(matrix[x][j]);
							l = x;
						}
					}
					System.out.println("O maior valor da coluna é: " + max);
					if (i != l) {
						for (int x = i; x < matrix[0].length; x++) {
							aux = matrix[i][x];
							matrix[i][x] = matrix[l][x];
							matrix[l][x] = aux;
						}
					}
					printMatrix(matrix);
					System.out.println("-----------------------------------------");
				}
				
				//Zera os coeficiêntes abaixo da diagonal principal
				if (i < j) {
					mult = matrix[j][i] / matrix[i][i];
					for (int k = 0; k < matrix[0].length; k++) {
						matrix[j][k] = matrix[j][k] - mult * matrix[i][k];
					}
				}
			}
		}
		printMatrix(matrix);
		b[matrix.length - 1] = matrix[matrix.length - 1][matrix.length] / matrix[matrix.length - 1][matrix.length - 1];
		for (int i = matrix.length - 1; i >= 0; i--) {
			sum = 0;
			for (int j = i + 1; j < matrix.length; j++) {
				sum += matrix[i][j] * b[j];
			}
			b[i] = (matrix[i][matrix.length] - sum) / matrix[i][i];
		}
		System.out.println("\nThe solution is: ");
		for (int i = 0; i < b.length; i++) {
			System.out.format("x%d = %.5f\n", i, b[i]);
		}
	}

	
	private static void printMatrix(double matrix[][]) {
		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix[0].length; y++) {
				System.out.format("%.2f\t", matrix[x][y]);
			}
			System.out.println();
		}
		System.out.println();

	}

}
