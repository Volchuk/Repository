
import java.util.Scanner;
public class HappyNumber {
	
	public static boolean isNumberHappy(int num){
		int total = 0;
		int digit = 0;
		while (num > 0){
			digit = num % 10;
			num = num /10;
			total = total + (int)Math.pow(digit, 2);
			//System.out.println("Processed total in loop "+ total);
		}
		//System.out.println("Processed total outside "+ total);
		if (total != 1) {
			isNumberHappy(total);
		}
		return true;
		
	}
	
	public static void main(String[] args) {
			int num = 0;
		try{
			System.out.println("Input number");
			Scanner sc = new Scanner(System.in);
			num = sc.nextInt();
			sc.close();
			System.out.println("Is number "+num+" happy? Answer: "+isNumberHappy(num));
		} catch (StackOverflowError e) {
			System.out.println("It seems number "+num+" is not happy.");
		}

	}

}
