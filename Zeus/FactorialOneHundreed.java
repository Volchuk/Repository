import java.math.BigInteger;

public class FactorialOneHundreed {

	public static BigInteger factorial(int n, BigInteger res) {
		if (n == 1) {
			return res;
		}
		return factorial( n -1 , res.multiply(BigInteger.valueOf(n)));
	}
	
	public static int sumOfDigits(){
		BigInteger number = BigInteger.valueOf(1);
		number  = factorial(100, number);
		char[] ch = number.toString().toCharArray();
		int sum = 0;
		for (int i = 0; i < ch.length; i++) {
			sum += Character.getNumericValue(ch[i]);
		}
		return sum;
	}
	
	public static void main(String[] args){
		System.out.println("Sum of 100! is " + sumOfDigits());
	}
}
