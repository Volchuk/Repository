import java.util.Scanner;
public class Point {
public double x;
public double y;

 public void print(Point p){
 System.out.println(this.toString());
 }
 public Point(double a, double b){
	this.x=a;
	this.y=b;
 }
 public Point(){
	boolean err;
	do{
		err=false;
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
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
public double length(Point p){
	double d=Math.sqrt(Math.pow(this.x-p.x, 2)+Math.pow(this.y-p.y, 2));	
	return d;
}
public boolean colinear(Point p1, Point p2){
	if ((this.x-p1.x)/(p2.x-p1.x)==(this.y-p1.y)/(p2.y-p1.y)){
	return true;} else {
		return false;
	}
}
public String toString() {
	return "x="+x+"  y="+y;
}
@Override
public int hashCode() {
	final int p =17 ;
	int result = 1;
	long temp;
	temp = Double.doubleToLongBits(x);
	result = p * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(y);
	result = p * result + (int) (temp ^ (temp >>> 32));
	return result;
}
@Override
public boolean equals(Object obj) {
	if (obj == null) {
		return false;
	}
	Point p = (Point) obj;
	if (this.x!= p.x) {
		return false;
	}
	if (this.y!= p.y) {
		return false;
	}
		return true;
}
public void print(){
	System.out.println(this.toString());
}
}