package utilities;

public class Error {
	public static double absolutError(double x0, double x1) {
		return Math.abs(x0 - x1);
	}

	public static double relativeError(double x0, double x1) {
		return (Math.abs(x1 - x0) / Math.abs(x1));
	}
}
