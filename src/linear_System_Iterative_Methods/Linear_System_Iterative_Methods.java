package linear_System_Iterative_Methods;

public class Linear_System_Iterative_Methods {
	public static void main(String[] args) {
		double matriz[][] = new double[][] {{10,2,1},{1,5,1},{2,3,10}};
		double b[] = new double[] {7,-8,6};
		Gauss_Jacobi(matriz, b, 0.05);

	}
	
	//Gauss Jacobi Method
	private static void Gauss_Jacobi(double C[][], double g[], double tol) {
		int count=0;
		double x0[]= new double[] {0.7,-1.6,0.6}, x1[]= new  double[x0.length];
		double sup, inf=1, err=0;
		
		// print the matrix 
		for (int i=0; i< C.length; i++) {
			for(int j=0; j< C.length; j++) {
				System.out.print(C[i][j]+"\t");
			}
			//print the array b
			System.out.println(g[i]);
		}
		System.out.println("-----------------------------------");
		//x1=sup/inf;
		do {
			err = 0;
			for(int i=0; i< C.length; i++) {
				sup = g[i];
				for (int j=0; j<C.length; j++) {
					if (i==j) {
						inf = C[i][j];
					}
					if(i!=j) {
						sup = sup -(C[i][j]*x0[j]);
					}
				}
				x1[i]= sup/inf;
				
				//Error Calculation
				if(Math.abs(x0[i]-x1[i]) > err) {
					err=Math.abs(x0[i]-x1[i]);
				}
			}
			
			System.out.println("Iteração: "+count);
			
			//print array x0
			System.out.println("x"+count+":");
			System.out.print("[");
			for(int i=0; i<x0.length; i++) {
				System.out.format("%.4f\t",x0[i]);
			}
			System.out.println("]\n");
			
			//print array x1
			System.out.println("x"+ ++count+":");
						System.out.print("[");
			for(int i=0; i<x1.length; i++) {
				System.out.format("%.4f\t", x1[i]);
			}
			System.out.println("]\n");
			
			//fill in the array x0 with the values of array x1
			for(int i=0; i< x0.length; i++) {
				x0[i]=x1[i];
			}
			
		//print error
		System.out.format("Erro: %.4f\n", err);
		System.out.println("-----------------------------------");
		} while (err>tol);
		
	}

}
