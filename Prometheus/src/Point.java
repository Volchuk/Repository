import java.util.Scanner;
public class Point {
public double x;
public double y;
public static Scanner sc=new Scanner(System.in);

public void print(Point p){
System.out.println("x="+x+" y="+y);
}

public Point(){
	boolean err;

	do{
		err=false;
		System.out.println("Input x, y");
		if (sc.hasNextDouble()){
			this.x=sc.nextDouble();}
		if (sc.hasNextDouble()){
			this.y=sc.nextDouble();
		} else{
			err=true;
			System.out.println("Input number");
		}
	} while(err);
}
public double lengthBetweenTwoPoints(Point p){
	double d=Math.sqrt(Math.pow(this.x-p.x, 2)+Math.pow(this.y-p.y, 2));	
	return d;
}

}
