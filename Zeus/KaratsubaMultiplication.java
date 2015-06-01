
public class KaratsubaMultiplication {

	public static int multiplication(int x, int y){
		int total = 0;
		if (x>100&&y>100){
		int a = x / 100;
		int b = x % 100;
		int c = y / 100;
		int d = y % 100;
		total = (multiplication(a, c) * ((int)1E4))+(multiplication(b, d))+(multiplication(b, c)+ multiplication(a, d))*((int)1E2);
		}
		else {
			total = x * y;
		}
		return total;
	}
	
	public static void main(String[] args) {
		int x = 567869, y = 123479;
		System.out.println(multiplication(x, y));
		System.out.println((x*y));

	}

}
