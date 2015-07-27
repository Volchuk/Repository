
public class triangle {
	double a;
	double b;
	double c;
public triangle(){
	boolean err1;
	do{
	System.out.println("Input coordinates of Point1");
	Point p1=new Point();
	System.out.println("Input coordinates of Point2");
	Point p2=new Point();
	System.out.println("Input coordinates of Point3");
	Point p3=new Point();
	a=p1.lengthBetweenTwoPoints(p2);
	b=p2.lengthBetweenTwoPoints(p3);
	c=p3.lengthBetweenTwoPoints(p1);
		err1=false;
	if(a+b>c&&b+c>a&&a+c>b){
		System.out.println("Triangle constructed");
	} else{
		System.out.println("Can't construct triangle, input another coordinates");
		err1=true;
	}
	}while(err1);
}

public String print(){
	return "a="+a+" b="+b+" c="+c;
}
}
