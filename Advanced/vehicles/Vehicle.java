package vehicles;

import java.util.HashMap;

import persons.Person;
import exception.NoFreeSeatsException;
import exception.NoPassengerException;

public abstract class Vehicle<T extends Person> {

	protected int seats;
	protected HashMap<String, T> map;
	
	public Vehicle(int seats) {
		map = new HashMap<> ();
		this.seats = seats;
	}
	
	
	public void in(String name, T t) throws NoFreeSeatsException {
		if (map.size() == seats) {
			throw new NoFreeSeatsException ("Vehicle is full");
		}
		map.put(name, t);
	}
	
	public Person out(String name) throws NoPassengerException {

				if (map.containsKey(name) ){
					return map.remove(name);
				}
			throw new NoPassengerException ("No passenger with such name");
	}
	
	public int freeSeats(){
		return seats - map.size();
	}
	
}

