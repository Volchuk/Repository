import java.util.Scanner;
class Circle {
    // �������� ������
    public double x; // �������� ������
    public double y; // �������� ������
    public double r; // ������
    // ������ ������
    // ������� �� ����� ��������� ����������
    public Circle() {
    	System.out.println("Please, input coordinates of circle center and radius");
    	boolean err;
    	do {
    		err=false;
        Scanner sc = new Scanner(System.in); // ������ ������ ������ Scanner
    		 if (sc.hasNextDouble()){ 
           this.x=sc.nextDouble();} // ��������� ����� ����� � ������ ����� � ��������� � ����������
           if (sc.hasNextDouble()){
           this.y=sc.nextDouble();}
           if (sc.hasNextDouble()){
           this.r=sc.nextDouble();
           sc.close();
           }else {
        	   err=true;
        	   System.out.println("Please, input number");
           }
    	 } while(err);
    }
    public Circle(double a, double b, double c){
    	x=a;
    	y=b;
    	r=c;
    }
    public void printCircle() {
        System.out.println("Circle center ("+x+";"+y+"), radius "+r);
    }    
    // ���������� �����, �������� ����������
    public void moveCircle(double a, double b) {
        x = x + a;
        y = y + b;
    }
    public void randomMoveCircle(Circle cir){
       cir.x=Math.random()*199-99;
       cir.y=Math.random()*199-99;
    }
    // ������������, ��������� �������������� ������� � ������������� k
    public void zoomCircle(double r) {
        this.r = this.r * r;
    }    
    public double squareCircle () {
    	double s=Math.PI*r*r;
    	return s;
    }
    public double lengthCircle (){
    	double l=2*Math.PI*r;
    	return l;
    }
    public boolean equalsCircle(Circle cir) { // ����� ���������� ��� ������������� ������� � � ����� ���������� ��� ����
    										  //������ ������ Circle � ������� ����������
        if(this.squareCircle() == cir.squareCircle()) { // �������� ����� this ��� ����,
        												//����� ������� ������ squareCircle() ��� �������, ���������� �����
        												//� � ������� �r ���� ����������� ����� squareCircle()
            return true;
        } else {
            return false;
        }
    }
    public double interCenterDistance (Circle cir) {
    	double dis=Math.sqrt(Math.pow((this.x-cir.x), 2)+Math.pow((this.y-cir.y), 2));
    	return dis;
    }
    public void circleTouch(Circle cir) {
    	if (((this.r+cir.r)==this.interCenterDistance(cir))
    			||(this.interCenterDistance(cir)==(this.r-cir.r))||
    			(this.interCenterDistance(cir)==(cir.r-this.r))) {
    		System.out.println("Circles touch");
        	}else{
    		System.out.println("Circles don't touch");
    	}
    }
    
    public String toString (){
    	return "x="+x+"y="+y+"r="+r;
    }
}

