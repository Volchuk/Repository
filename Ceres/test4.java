import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class test4 {
		
	public static void main(String[] args) {
		String name = "D:\\Ints.txt";
		int sum=0;
		File file = new File(name);
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(file);
		while(sc.hasNextInt()){
			sum+=sc.nextInt();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sum);
	}
}