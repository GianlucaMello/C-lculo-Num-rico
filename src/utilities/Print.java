package utilities;

public abstract class Print {
	public static void printMatrix(double matrix[][], double b[]) {
		// Print the matrix
		System.out.println("Matrix:");
		for (int i = 0; i < matrix.length; i++) {
			System.out.print("|");
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			// print the array b after print the last element of the matrix
			System.out.print(b[i]);
			if (b[i] < 0)
				System.out.print("|\n");
			else
				System.out.print(" |\n");
		}
		System.out.println();
	}

	public static void printMatrix(double matrix[][]) {
		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix[0].length; y++) {
				System.out.format("%.2f\t", matrix[x][y]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void printVector(double x[]) {
		System.out.print("[");
		for (int i = 0; i < x.length; i++) {
			System.out.format("%.4f", x[i]);
			if (i != x.length - 1)
				System.out.print("   ");
		}
		System.out.println("]\n");
	}
}
