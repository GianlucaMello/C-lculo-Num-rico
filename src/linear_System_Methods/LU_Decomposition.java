/**
 * 
 */
package linear_System_Methods;

import utilities.Print;

/**
 * @author gianluca.mello
 *
 */
public class LU_Decomposition {
	public static void method(double matrix[][], double b[]) {
		double mult = 1, sum = 0;
		double[] y = new double[matrix.length], x = new double[matrix.length];
		double[][] lu = new double[matrix.length][matrix.length];

		System.out.println("Matrix");
		for (int i = 0; i < matrix.length; i++) {
			Print.printMatrix(matrix);
			System.out.println();

			// Transforma a matriz em uma triangular superior
			System.out.println("Zerando a coluna " + i);
			for (int j = 0; j < matrix.length; j++) {
				if(j == i) {
					lu[i][i] = 1;
				}
				if (i < j) {
					mult = matrix[j][i] / matrix[i][i];
					lu[j][i] = mult;
					lu[i][j] = 0;
					for (int k = 0; k < matrix[0].length; k++) {
						matrix[j][k] = matrix[j][k] - mult * matrix[i][k];
					}
				}
			}
		}
		Print.printMatrix(matrix);
		
		System.out.println("L:");
		Print.printMatrix(lu);
		
		System.out.println("U:");
		Print.printMatrix(matrix);
		
		System.out.println("b:");
		Print.printVector(b);

		// Calcula o valor de y1 até yn, do primeiro para o último
		for (int i = 0; i < y.length; i++) {
			sum = 0;
			for (int j = 0; j<i; j++) {
				sum += lu[i][j]*y[j];
			}
			y[i] = (b[i] - sum) / lu[i][i];
		}
		
		System.out.println("Y:");
		Print.printVector(y);
		
		//Calcula o valor de xN, até x1, do último para o primeiro
		for (int i = matrix.length - 1; i >= 0; i--) {
			sum = 0;
			for (int j = i+1; j <matrix.length; j++) {
				sum += matrix[i][j]*x[j];
			}
			x[i] = (y[i]- sum) / matrix[i][i];
		}
		
		System.out.println("X:");
		Print.printVector(x);
		
		System.out.println("\nThe solution is: ");
		for (int i = 0; i < x.length; i++) {
			System.out.format("x%d = %.5f\n", i, x[i]);
		}
	}
}

