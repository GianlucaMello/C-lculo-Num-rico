/**
 * 
 */
package linear_System_Methods;

import utilities.Print;

/**
 * @author gianluca.mello
 *
 */
public class Gaussian_Elimination_Total_Pivoting {
	public static void method(double matrix[][]) {
		String[] vetorX = new String[matrix.length];
		String auxX;
		int l = 0, c = 0;
		double mult, sum, max = 0;
		double[] b = new double[matrix.length];
		double aux;

		for (int i = 0; i < vetorX.length; i++) {
			vetorX[i] = "x" + i;
		}

		System.out.println("Matrix");
		for (int i = 0; i < matrix.length; i++) {
			System.out.println("Iteração: " + i);
			Print.printMatrix(matrix);
			System.out.println("Zerando a coluna " + i);
			for (int j = 0; j < matrix.length; j++) {

				// Verifica qual o maior valor entre os coeficiêntes da matriz
				if (i == j && i != matrix.length - 1) {
					max = 0;
					for (int x = i; x < matrix.length; x++) {
						for (int y = j; y < matrix.length; y++) {
							if (Math.abs(matrix[x][y]) > max) {
								max = Math.abs(matrix[x][y]);
								l = x;
								c = y;
							}
						}
					}
					System.out.println(" Linha: " + l);
					System.out.println("Coluna: " + c);
					System.out.println("J: " + j);
					System.out.println("O maior valor é: " + max);
					// Substitui as colunas para deixar o maior valor como pivo na coluna atual
					if (j != c) {
						for (int y = 0; y < matrix.length; y++) {
							aux = matrix[y][j];
							matrix[y][j] = matrix[y][c];
							matrix[y][c] = aux;

						}
						auxX = vetorX[c];
						vetorX[c] = vetorX[j];
						vetorX[j] = auxX;
					}
					// substitui as linhas para deixar o maior valor como pivo
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
			System.out.format("%s = %.5f\n", vetorX[i], b[i]);
		}
	}
}
