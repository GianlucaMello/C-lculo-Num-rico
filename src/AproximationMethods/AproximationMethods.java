package AproximationMethods;

import static java.lang.Math.pow;

public class AproximationMethods {

	public static void main(String[] args) {
		double err = 0.001, x0 = 1, x1 = 2;
		
		//f = "(2 * pow(x0, 3) + Math.log(x0) - 5)";
		//d1 = "(6 * pow(x0, 2) + 1 / x0)";
		//Bisseccao(x0, x1, err, f);
		//regulaFalsi(x0, x1, err, f);
		//FixedPoint(x0, err, f);
		
		//NewtonMethod(x0, err);
		SecMethod(x0, x1, err);
	}
	
	//Functions
	private static double Funcao(double x) {
		double fx;
		//fx = (x * Math.log(x + 3)) - (x / Math.sqrt(pow(x, 2) + 3));
		//fx = pow(x, 2)-2;
		//fx = Math.exp(-1*pow(x,2))-Math.cos(x);
		
		
		//phi
		/*1*/fx = Math.cos(x)-Math.exp(-1*pow(x, 2))+x;
		/*2*/
		/*3*/
		/*4*/
		/*5*/
		/*6*/
		
		return fx;
	}
	private static double Derivada1(double x) {
		double dx = 2*x;
		return dx;
	}
	private static double Derivada2(double x) {
		double dx2 = x;
		return dx2;
	}

	
	//Methods
	private static void Bisseccao(double aa, double bb, double y) {
        int i = 0;
        double x0, erro, a = aa, b = bb;
        System.out.println("Bissecção\n");
        do {
            x0 = (a + b) / 2;
            erro = AbsolutErr(b, a);
            System.out.format("Iteração: %d\tValor: %.5f\tErro: %.5f\n", i++, x0, erro);
            if (Funcao(x0) == 0) {
                break;
            }
            if ((Funcao(x0) * Funcao(a)) < 0) {
                b = x0;
            } else {
                a = x0;
            }
        } while (erro > y);
        System.out.println("\n\n\n");
    }

    private static void regulaFalsi(double aa, double bb, double y) {
        int i = 0;
        double x0, erro, a = aa, b = bb;
        System.out.println("Regula Falsi\n");
        do {
            x0 = ((a * Funcao(b) - b * Funcao(a)) / (Funcao(b) - Funcao(a)));
            if (Funcao(x0) == 0) {
                break;
            }
            if ((Funcao(x0)*Funcao(a)) < 0) {
            	erro = AbsolutErr(b, x0);
                b = x0;
            } else if((Funcao(x0)*Funcao(b)) < 0){
            	erro = AbsolutErr(a, x0);
            	a = x0;
            } else {
            	erro = 0;
            	System.out.println("Erro");
            	break;
            }
            System.out.format("Iteração: %d\tValor: %.5f\t\tErro: %.5f\n", i++, x0, erro);
        } while (erro > y && i < 10);
        System.out.println("\n");

    }

    private static void FixedPoint(int a, int b, double y){
        double x0 =a, x1 =b, erro = 1;
        int i =0;
        System.out.println("I\tXn\tErro\n");
        do{
            erro = AbsolutErr(x0, x1);
            System.out.format("%d\t%.5f\t%.5f\n", i++, Func(x1), erro);
            x0 = x1;
            x1 = Func(x1);
        } while(erro > y);
        
        
    }

	private static void NewtonMethod(double x, double y) {
		double x0 = x, x1, tolerancia = y, erro, d0, d1;
		int i = 0;
		System.out.println("Newton\n");
		System.out.format("Iteração \tValor \t\tErro\n");
		System.out.format("%d \t\t%.9f \t%.9f\n", i, x0, 0.0);
		
		i++;
		do {
			d0 = Funcao(x0);
			d1 = Derivada1(x0);
			x1 = x0 - (d0 / d1);
			erro = AbsolutErr(x0, x1);
			System.out.format("%d \t\t%.9f \t%.9f\n", i++, x1, erro);
			x0 = x1;
		} while (erro > tolerancia || i > 100);
		System.out.print("---------------------------------------------\n\n\n\n");
	}

	private static void SecMethod(double a, double b, double y) {
		double x0 = a, x1 = b, x2, tolerancia = y, erro, f0, f1;
		int i = 0;
		System.out.println("Secante\n");
		do {
			f0 = Funcao(x0);
			f1 = Funcao(x1);
			x2 = ((x0 * f1) - (x1 * f0)) / (f1 - f0);
			x0 = x1;
			x1 = x2;
			erro = AbsolutErr(x0, x1);
			System.out.format("Iteração: %d \tValor: %.10f   \tErro: %.10f\n", i++, x2, erro);
			
		} while (erro > tolerancia || i > 100);
	}

	
	//Err
	private static double AbsolutErr(double x0, double x1) {
		return Math.abs(x0 - x1);
	}

	private static double RelativeErr(double x0, double x1) {
		double err = (Math.abs(x1 - x0) / Math.abs(x1));
		return err;
	}
}
