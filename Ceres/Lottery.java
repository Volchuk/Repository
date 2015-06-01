import javax.swing.JOptionPane;
import java.util.Scanner;

public class Lottery {

	public static void main(String[] args) {
		System.out.println("Try Your luck! Input two digits from 0 to 9!");
		int N=(int) (Math.random()*100), x = 0  , y = 0;
		boolean err;
		do {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner (System.in);
		err=true;
		System.out.println("Input the first digit!");
		if (sc.hasNextInt())
		{
			x = sc.nextInt();
			System.out.println("Input the second digit!");
		if (sc.hasNextInt())
		{
			y = sc.nextInt();
			err=false;
		}
		}
		} while (err);
		
		if (y==(N%10)&&x==(N/10))
		{
			System.out.println("You won $10.000  ");
		}
		else if ((x==(N/10)&&y==(N/10))||(y==(N/10)&&x==(N/10)))
		{
			System.out.println("You won $3.000  ");
		}
		else if (x==(N/10)||y==(N/10)||y==(N/10)||x==(N/10))
		{
			System.out.println("You won $1.000  ");
		}
		else
		{
			System.out.println("Try again next time  ");
		}
		System.out.println("The winning number is "+N);
		System.out.println("Your number is "+x+y);
	}
}