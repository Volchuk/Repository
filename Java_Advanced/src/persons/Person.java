package persons;

public abstract class Person {

	private String personName;
	
	public Person(String s) {
		personName = s;
	}
	
	public String getName() {
		return personName;
	}
	
	@Override
	public String toString () {
		return "Removed person is "+ getClass() + " with name " + getName();
	}
	
}
