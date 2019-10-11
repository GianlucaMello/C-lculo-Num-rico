/**
 * 
 */
package a_main;

import linear_System_Iterative_Methods.Gauss_Jacobi;
import linear_System_Iterative_Methods.Gauss_Seidel;
import linear_System_Methods.Cholesky_Decomposition;
import linear_System_Methods.Gauss_Jordan_Elimination;
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
			{20,7,9},
			{7,30,8},
			{9,8,17}
			};

		// Array g
		double g[] = new double[] {16,38,38};

		// Array with the inicial values of x0
		double x0[] = new double[] {1,2,1};
		
		// Tolerance
		double tol = 0.01;		
		
		
		Gauss_Jacobi jacobi = new Gauss_Jacobi();
		Gauss_Seidel seidel = new Gauss_Seidel();
		LU_Decomposition lu = new LU_Decomposition();
		Cholesky_Decomposition cholesky = new Cholesky_Decomposition();
		Gaussian_Elimination gauss = new Gaussian_Elimination();
		Gaussian_Elimination_Partial_Pivoting gauss_p = new Gaussian_Elimination_Partial_Pivoting();
		Gaussian_Elimination_Total_Pivoting gauss_t = new Gaussian_Elimination_Total_Pivoting();
		Gauss_Jordan_Elimination jordan = new Gauss_Jordan_Elimination();
		
		//jordan.method(C, g);
		//cholesky.method(C, g);
		//gauss.method(C);
		//jacobi.method(C, g, x0, tol);
		//seidel.method(C, g, x0, tol);
		lu.method(C, g);

		
		
	}
}
