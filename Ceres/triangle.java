import java.util.Scanner;

public class triangle {
	private Point p1, p2, p3;
	private double a, b, c;
	private static boolean check;
private Point median(Point p1, Point p2){
	Point pm=new Point((p1.x+p2.x)/2, (p1.y+p2.y)/2);
	return pm;
}
public Point findCenterOfMass(){
	Point pm1=median(p2, p3);
	Point pm2=median(p1, p3);
	double[][] A=new double[2][2];
	double[][] B=new double[2][1];
	A[0][0]=p1.y-pm1.y;
	A[0][1]=pm1.x-p1.x;
	A[1][0]=p2.y-pm2.y;
	A[1][1]=pm2.x-p2.x;
	B[0][0]=pm1.x*p1.y-p1.x*pm1.y;
	B[1][0]=pm2.x*p2.y-p2.x*pm2.y;
	double[][] X=solveLinearEquations.SolveLinEq(A, B);
	double x=X[0][0], y=X[1][0];
	Point cenOfMass=new Point(x,y);
	cenOfMass.print(cenOfMass);
	return cenOfMass;
}
	public triangle(){
	boolean err1;
	do{
		err1=false;
	System.out.println("Input coordinates of Point1");
	p1=new Point();
	System.out.println("Input coordinates of Point2");
	p2=new Point();
	System.out.println("Input coordinates of Point3");
	p3=new Point();
	a=p1.length(p2);
	b=p2.length(p3);
	c=p3.length(p1);
	if (p1.colinear(p2, p3)){
		System.out.println("Can't construct triangle, points colinear");
	}
	if(a+b>c&&b+c>a&&a+c>b){
		System.out.println("Triangle constructed");
		check=true;
		err1=false;
	} else{
		String in=new String();
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		int q=0;
		while(q<1){
			System.out.println("Input another coordinates? y=yes, n=no");
			in=sc.next();
			if(in.equals("y")){
				q++;
				err1=true;
			}else if(in.equals("n")) {
				q++;
				err1=false;
			} else {
				System.out.println("Invalid charachter");
				err1=false;
			}
		}
		}
	}while(err1);
}
public Point getPoint1(){
	return p1;
}
public Point getPoint2(){
	return p2;
}
public Point getPoint3(){
	return p3;
}
public double getEdges(double ed1, double ed2, double ed3){
	return ed1+ed2+ed3;
}
public double Perim(triangle t){
	double p=0;
	if(check){
	p=t.a+t.b+t.c;
	System.out.println("Perimeter="+p);
	}
	return p;
}
public double Area(triangle t){
	double ar=0;
	if (check){
	double per=this.Perim(t)/2;
	ar=Math.sqrt(per*(per-t.a)*(per-t.b)*(per-t.c));
	System.out.println("Area="+ar);
	}
	return ar;
}
public void print(){
	System.out.println(this.toString());
}
@Override
public String toString() {
	return "triangle [p1: " + p1 + "; p2: " + p2 + "; p3: " + p3+"]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((p1 == null) ? 0 : p1.hashCode());
	result = prime * result + ((p2 == null) ? 0 : p2.hashCode());
	result = prime * result + ((p3 == null) ? 0 : p3.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	triangle other = (triangle) obj;
	if (p1 == null) {
		if (other.p1 != null)
			return false;
	} else if (!p1.equals(other.p1))
		return false;
	if (p2 == null) {
		if (other.p2 != null)
			return false;
	} else if (!p2.equals(other.p2))
		return false;
	if (p3 == null) {
		if (other.p3 != null)
			return false;
	} else if (!p3.equals(other.p3))
		return false;
	return true;
}
}