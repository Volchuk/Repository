import java.util.Scanner;
class Circle {
    // свойства класса
    public double x; // абсцисса центра
    public double y; // ордината центра
    public double r; // радиус
    // методы класса
    // выводит на экран параметры окружности
    public Circle() {
    	System.out.println("Please, input coordinates of circle center and radius");
    	boolean err;
    	do {
    		err=false;
        Scanner sc = new Scanner(System.in); // создаём объект класса Scanner
    		 if (sc.hasNextDouble()){ 
           this.x=sc.nextDouble();} // считывает целое число с потока ввода и сохраняем в переменную
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
    // перемещает центр, движение окружности
    public void moveCircle(double a, double b) {
        x = x + a;
        y = y + b;
    }
    public void randomMoveCircle(Circle cir){
       cir.x=Math.random()*199-99;
       cir.y=Math.random()*199-99;
    }
    // масштабируем, выполняем преобразование подобия с коэффициентом k
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
    public boolean equalsCircle(Circle cir) { // метод вызывается для определенного объекта и в метод передается еще один
    										  //объект класса Circle с которым сравниваем
        if(this.squareCircle() == cir.squareCircle()) { // ключевое слово this для того,
        												//чтобы выбрать именно squareCircle() для объекта, вызвавшего метод
        												//а к объекту сіr тоже применяется метод squareCircle()
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

