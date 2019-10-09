package linear_System_Methods;

import utilities.Print;
import java.lang.Math;

/**
 * @author gianluca.mello
 *
 */
public class Cholesky_Decomposition {
	public static void method(double A[][], double b[]) {
		double sum = 0;
		double[] y = new double[A.length];
		double[][] G = new double[A.length][A.length];

		System.out.println("Matrix A");
		Print.printMatrix(A, b);
		//Create the lower matrix
		for(int k=0; k<A.length; k++) {
			for(int i=0; i<A.length; i++) {
				sum=0;
				if(A[k][i]!=A[i][k]) {
					System.out.format("Erro, as posicoes: A[%d][%d] e A[%d][%d] nao sao iguais!!!",i,k, k,i);
					return;
				}
				if(k==i) {
					for(int j=0; j<k; j++) {
						sum += Math.pow(G[k][j],2);
					}
					G[k][k]=Math.sqrt(A[k][k]-sum);
				}else if(k>i) {
					for(int j=0; j<i; j++) {
						sum += G[i][j]*G[k][j];
					}
					G[k][i]=(A[k][i]-sum)/G[i][i];
				} else{
					G[k][i]=0;
				}
			}
		}
		
		//print the matrix G
		System.out.println("Matrix G:");
		Print.printMatrix(G, b);
		
		
		//Discovery the values of array Y
		for(int i=0; i<A.length; i++) {
			sum=0;
			for(int j=0; i>j; j++) {
				sum+= G[i][j]*y[j];
			}
			y[i]=(b[i]-sum)/G[i][i];
		}
		
		//print array b
		System.out.println("Array b: ");
		Print.printArray(b);
		//print array y
		System.out.println("Array y: ");
		Print.printArray(y);
		
		//verify if Gt(sum) is equal to y
		for(int i=0; i<G.length; i++) {
			sum=0;
			for(int j=0; j<G.length; j++) {
				sum+=G[j][i];
			}
			System.out.format("%f = %f\n", sum,y[i]);
		}
	}
}

