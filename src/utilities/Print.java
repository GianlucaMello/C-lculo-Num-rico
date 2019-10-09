package utilities;

public abstract class Print {
	public static void printMatrix(double matrix[][], double b[]) {
		// Print the matrix before the array b
		for (int i = 0; i < matrix.length; i++) {
			System.out.print("|");
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.format("%.2f \t",matrix[i][j]);
			}
			// print the array b after print the last element of the matrix
			System.out.format("%.4f",b[i]);
			if (b[i] < 0)
				System.out.print("|\n");
			else
				System.out.print(" |\n");
		}
		System.out.println();
	}

	//print matrix b only
	public static void printMatrix(double matrix[][]) {
		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix[0].length; y++) {
				System.out.format("%.4f\t", matrix[x][y]);
			}
			System.out.println();
		}
		System.out.println();
	}

	//print array
	public static void printArray(double x[]) {
		System.out.print("[");
		for (int i = 0; i < x.length; i++) {
			System.out.format("%.4f", x[i]);
			if (i != x.length - 1)
				System.out.print("   ");
		}
		System.out.println("]\n");
	}
}
