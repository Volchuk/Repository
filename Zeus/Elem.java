
public class Elem {

	public String data;
	public Elem next;
	
	public Elem(String d) {
		this.data = d;
		}
	
	public void printElement(){
		System.out.println("Element's data is "+data);
	}
	
	public Elem get(){
		return this;
	}
	
	@Override
	public String toString() {
		return "Elem [data=" + data + ", next=" + next + "]";
	}
	
}
