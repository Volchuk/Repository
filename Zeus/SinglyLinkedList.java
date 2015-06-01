import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class SinglyLinkedList {

	private Elem first;
	
	// empty LinkedList
	public SinglyLinkedList(){
		first = null;
	}
	
	// check if List is empty
	public boolean isEmpty(){
		return first == null;
	}
	// add elements
	
	public void add(String d1){
		Elem elem = new Elem(d1);
		elem.next = first;
		first=elem;
	}
	
	public Object delete(){
		Elem temp = first;
		first = first.next;
		return temp;
	}
	
	public void printList(){
		Elem temp = first;
		System.out.println("List Elements are");
		while(temp != null){
			temp.printElement();
			temp = temp.next;
		}
	}
	
	// get first element
	public Elem getTail(){
		Elem temp = first;
		while (temp.next != null){
			temp = temp.next;
		}
		return temp;
	}
	// fill List from file
	public SinglyLinkedList fillListFromFile(String name){
		try{
			Scanner sc = new Scanner(new File(name));
			while(sc.hasNext())
			this.add(sc.next());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return this;
	}
	// reverse List
	public SinglyLinkedList reverseList(SinglyLinkedList list){
		if (first.next == null || this.isEmpty()){
			return list;
		} else {
			Elem temp = first.next;
			Elem head = first;
			first = temp;
		reverseList(list);
		temp.next = head;
		head.next = null;
		}
		return list;
	}
	
	public static void main(String[] args){
		
		SinglyLinkedList linkedList = new SinglyLinkedList();
		String name = "D://Friends.txt";
		linkedList.fillListFromFile(name);
		//linkedList.printList();
		//linkedList.reverseList(linkedList);
		linkedList.printList();
		
	}
	
}
