package linear_System_Methods;

public class Linear_Syxtem_Methods {
	public static void main(String[] args) {
		float[][] matriz;
		//float[] b;
//		matriz = new float[][]{
//			{2, 3, -1, 5},
//			{4, 4, -3, 3},
//			{2,-3, 1, -1}};
		//b = new float[]{5,3,-1};
		
		matriz =  new float [][] {
			{2,  2, 1,  1, 7},
			{1, -1, 2, -1, 1},
			{3, 2, -3, -2, 4},
			{4, 3,  2,  1, 12}
			};
//			System.out.println(matriz.length);
//			System.out.println(matriz[0].length);
			gaussElimination(matriz);
	}
	
	//Gauss Elimination Method
	private static void gaussElimination(float matriz[][]) {
		float mult, sum;
		float[] b = new float[matriz.length];
		for(int i=0; i< matriz.length; i++) {
			for(int x=0; x<matriz.length; x++) {
				for(int y =0; y<matriz[0].length; y++) {
					System.out.format("%.2f\t", matriz[x][y]);
				}
				System.out.println();
			}
			System.out.println();
			for(int j=0; j< matriz.length; j++) {
				if (i<j) {
					mult= matriz[j][i]/ matriz[i][i];
					for (int k=0; k<matriz[0].length; k++) {
						matriz[j][k] = matriz[j][k]- mult*matriz[i][k];
					}
				}
			}
		}
		
		for(int x=0; x<matriz.length; x++) {
			for(int y =0; y<matriz[0].length; y++) {
				System.out.format("%.2f\t", matriz[x][y]);
			}
			System.out.println();
		}
		
		b[matriz.length-1] = matriz[matriz.length-1][matriz.length]/matriz[matriz.length-1][matriz.length-1];
		
		for (int i=matriz.length-1; i>=0; i--) {
			sum =0;
			for (int j = i+1; j<matriz.length; j++) {
				sum+=matriz[i][j]*b[j];
			}
			b[i]=(matriz[i][matriz.length]-sum)/matriz[i][i];
		}
		System.out.println("\nThe solution is: ");
		for (int i = 0; i<b.length; i++) {
			System.out.format("x%d = %.2f\n", i, b[i]);
		}
	}

}
