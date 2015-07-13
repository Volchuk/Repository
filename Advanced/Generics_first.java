import java.util.ArrayList;
import java.util.List;

// first lesson of Java_Advanced course
// Anton Kovalchuk as tutor
// 08.07.2015

public class Generics_first {
	
	public static void main (String[] args) {
		List <Integer> numbers = new ArrayList <Integer> ();
		numbers.add(12);
		numbers.add(120);
		numbers.add(1200);
		Integer first = numbers.get(0);

	}

	// method parametrizng
	
	//public static <T> int compare(Box<T> b1, Box<T> b2) {
		
	}
	
	
	// wlidcard is interesting thing
	// type G<String> is not a subtype of G<Object>
	// cannot extract String s from G<Object> list
	// G<Object> returns only Object obj
	

