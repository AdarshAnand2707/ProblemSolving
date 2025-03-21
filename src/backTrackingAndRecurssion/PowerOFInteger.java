package backTrackingAndRecurssion;

public class PowerOFInteger {

	public static float power (int x, int n) {
		if(x == 0 && n <= 0) {
			throw new ArithmeticException("Undefined");
		}
		float result = positivePower(Math.abs(x), Math.abs(n));
		if (n < 0) {
			result = 1/result;
		}
		if (x < 0 && n % 2 != 0) {
			return -1 * result;
		}
		return result;
		
	}
	
	public static float positivePower (int x, int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}
		float halfPower = positivePower(x, n/2);
		return n % 2 == 0 ? (halfPower * halfPower) : 
			(x * halfPower * halfPower);
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(power(2, 4));
		System.out.println(power(2, -4));
		System.out.println(power(-2, 4));
		System.out.println(power(-2, -4));
		System.out.println(power(-2, 3));
	}

}
