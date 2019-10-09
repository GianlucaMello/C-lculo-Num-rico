/**
 * 
 */
package linear_System_Methods;

import utilities.Print;

/**
 * @author gianluca.mello
 *
 */
public class Gaussian_Elimination_Partial_Pivoting {
	public static void method(double matrix[][]) {
		int l = 0;
		double mult, sum, max = 0;
		double[] b = new double[matrix.length];
		double aux;

		System.out.println("Matrix");
		for (int i = 0; i < matrix.length; i++) {
			System.out.println("Iteração: " + i);
			Print.printMatrix(matrix);
			System.out.println("Zerando a coluna " + i);
			for (int j = 0; j < matrix.length; j++) {

				// Verifica qual o maior valor entre os coeficiêntes da coluna atual
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
					Print.printMatrix(matrix);
					System.out.println("-----------------------------------------");
				}

				// Zera os coeficiêntes abaixo da diagonal principal
				if (i < j) {
					mult = matrix[j][i] / matrix[i][i];
					for (int k = 0; k < matrix[0].length; k++) {
						matrix[j][k] = matrix[j][k] - mult * matrix[i][k];
					}
				}
			}
		}
		Print.printMatrix(matrix);
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

}
