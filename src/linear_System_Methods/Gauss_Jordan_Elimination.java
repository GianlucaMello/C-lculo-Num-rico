/**
 * 
 */
package linear_System_Methods;

import utilities.Print;

/**
 * @author gianluca.mello
 *
 */

public class Gauss_Jordan_Elimination {

	public static void method(double matrix[][], double g[]) {
		double mult = 1, sum = 0;
		//double[] g = new double[matrix.length];

		System.out.println("Matrix");
		for (int i = 0; i < matrix.length; i++) {
			Print.printMatrix(matrix, g);
			System.out.println();

			// Transforma a matriz em uma triangular superior
			System.out.println("Zerando a coluna " + i);
			for (int j = 0; j < matrix.length; j++) {
				if (i < j) {
					mult = matrix[j][i] / matrix[i][i];
					g[j] = g[j] - g[i] * mult;
					for (int k = 0; k < matrix[0].length; k++) {
						matrix[j][k] = matrix[j][k] - mult * matrix[i][k];
					}
				}
			}
		}
		Print.printMatrix(matrix, g);

		for (int i = matrix.length - 2; i >= 0; i--) {
			System.out.println();

			// Transforma a matriz em uma diagonal
			System.out.println("Zerando a coluna superior" + i);
			Print.printMatrix(matrix, g);
			for (int j = i + 1; j < matrix.length; j++) {
				mult = matrix[i][j] / matrix[j][j];
				g[i] = g[i] - g[j] * mult;
				for (int k = matrix.length-1; k > i; k--) {
					matrix[i][k] = matrix[i][k] - mult * matrix[j][k];
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			g[i] = g[i] / matrix[i][i];
			matrix[i][i] = matrix[i][i] / matrix[i][i];
		}
		System.out.println("Deixando a diagonal principal unitária");
		Print.printMatrix(matrix,g);

		// Calcula o valor de Xn-1 até x1, do último para o primeiro

		/**for (int i = matrix.length - 1; i >= 0; i--) {
			sum = 0;
			for (int j = i + 1; j < matrix.length; j++) {
				sum += matrix[i][j] * g[j];
			}
			g[i] = (g[i]- sum) / matrix[i][i];
		}*/
		System.out.println("\nThe solution is: ");
		for (int i = 0; i < g.length; i++) {
			System.out.format("x%d = %.5f\n", i, g[i]);
		}
	}
}
