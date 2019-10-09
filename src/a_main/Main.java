/**
 * 
 */
package a_main;

import linear_System_Iterative_Methods.Gauss_Jacobi;
import linear_System_Iterative_Methods.Gauss_Seidel;
import linear_System_Methods.Cholesky_Decomposition;
import linear_System_Methods.Gaussian_Elimination;
import linear_System_Methods.Gaussian_Elimination_Partial_Pivoting;
import linear_System_Methods.Gaussian_Elimination_Total_Pivoting;
import linear_System_Methods.LU_Decomposition;

/**
 * @author gianluca.mello
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Matrix C
		double C[][] = new double[][] {
			{16,4,8,4,32},
			{4,10,8,4,26},
			{8,8,12,10,38},
			{4,4,10,12,30}};
			
//			{20,7,9},
//			{7,30,8},
//			{9,8,30}

		// Array g
		double g[] = new double[] {32,26,38,30};

		// Array with the inicial values of x0
		double x0[] = new double[] {1,2,1,0};
		double x1[] = new double[] { 0, 0, 0 , 0};

		// Tolerance
		double tol = 0.01;
		
		/**double aux[][] = new double[][] {
			{ 9, -6, -3, -4, -5, -5, -8, 6, -2, 2, -7, -1, 4, -9, 4, 5, 9, 4, 9, -5, -15.13620337 },
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
	//double x0[] = new double[] { 1, 01, 01, 01, 01, 01, 01, 01, 01, 01, 01, 01, 01, 01, 01, 01, 01, 01, 01, 01 };
	double matriz[][] = new double[aux.length][aux.length];
	for (int i = 0; i < matriz.length; i++) {
		for (int j = 0; j <matriz.length; j++) {
			matriz[i][j] = aux[i][j];
		}
	}
	double b[] = new double[aux.length];
	for (int i = 0; i < b.length; i++) {
		b[i] = aux[i][aux.length];
	}*/
		
		
		
		Gauss_Jacobi jacobi = new Gauss_Jacobi();
		Gauss_Seidel seidel = new Gauss_Seidel();

		LU_Decomposition lu = new LU_Decomposition();
		Cholesky_Decomposition cholesky = new Cholesky_Decomposition();
		Gaussian_Elimination gauss = new Gaussian_Elimination();
		Gaussian_Elimination_Partial_Pivoting gauss_p = new Gaussian_Elimination_Partial_Pivoting();
		Gaussian_Elimination_Total_Pivoting gauss_t = new Gaussian_Elimination_Total_Pivoting();
		//cholesky.method(C, g);
		gauss.method(C);
		
		//jacobi.method(C, g, x0, tol);
		// seidel.method(C, g, x1, tol);

		
		
	}
}
