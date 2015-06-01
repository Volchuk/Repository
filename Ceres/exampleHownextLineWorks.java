import java.util.Scanner;

public class exampleHownextLineWorks {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("enter numerical value");    
		int option;
		option = input.nextInt ();//read numerical value from input
		String string = input.nextLine ();
		System.out.println(string);
		System.out.println("enter 1st string"); 
		String string1 = input.nextLine ();//read first string which is skipped
		System.out.println(string1);
		System.out.println("enter 2nd string");
		String string2 = input.nextLine ();//read 2nd string which appeared straight after reading numerical value
		System.out.println(string2);	
	}
}