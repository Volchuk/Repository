import java.util.Scanner;
public class ChineeseCalendar {
public static void main(String[] args){
	int year=0;
	boolean err;
	System.out.println("Input the year");
	Scanner sc = new Scanner (System.in);
	do {
		err=true;
	if (sc.hasNextInt()) {
		year=sc.nextInt();
		err=false;
	} else {
		err=true;
	}
	}while(err);
	System.out.print("According to Chineese calendar this is the year of the ");
switch (year%12) {
case 4: System.out.print("rat");
break;
case 5: System.out.print("ox");
break;
case 6: System.out.print("tiger");
break;
case 7: System.out.print("rabbit");
break;
case 8: System.out.print("dragon");
break;
case 9: System.out.print("snake");
break;
case 10: System.out.print("horse");
break;
case 11: System.out.print("sheep");
break;
case 0: System.out.print("monkey");
break;
case 1: System.out.print("rooster");
break;
case 2: System.out.print("dog");
break;
case 3: System.out.print("pig");
		}
	}
}
