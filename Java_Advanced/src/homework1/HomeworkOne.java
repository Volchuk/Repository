package homework1;

import persons.FireFighter;
import persons.Policeman;
import vehicles.FireTruck;
import vehicles.PoliceCar;
import vehicles.Taxi;

public class HomeworkOne {

	public static void main (String [] args) throws Exception {
		
	Taxi taxi = new Taxi (); // 3 seats
	FireTruck truck = new FireTruck (); // 6 seats
	
	Policeman cop1 = new Policeman ("John");
	Policeman cop2 = new Policeman ("Sam");
	Policeman cop3 = new Policeman ("Slit");
	Policeman cop4 = new Policeman ("Backs");
	
	FireFighter fire1 = new FireFighter ("Nux");
		
	taxi.in(cop1.getName(), cop1);
	taxi.in(cop2.getName(), cop2);
	taxi.in(cop3.getName(), cop3);
	// taxi.in(cop4.getName(), cop4);

	System.out.println(taxi.out("Sam"));
	
	System.out.println(taxi.freeSeats());
		
	truck.in(fire1.getName(), fire1);
	
	System.out.println(truck.freeSeats());
	
	
	}
	
}
