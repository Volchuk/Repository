import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Graph {
	
	public class Stack{
		
		public Person first;
		
		public Stack(){
			first = null;
		}
		
		public void add(Person pers){
			pers.next = first;
			first = pers;
		}
		
		public void remove(){
			first = first.next;
		}
		
		public boolean isEmpty(){
			return first == null;
		}
		
		public void printStack(){
			Person temp = first;
			while (temp != null) {
				System.out.println(temp.personName+" ---> ");
			}
		}
	}
	
	// heap where root is the least number
	public class Heap<T> {

		public ArrayList<Person> array;
			
			public Heap(){
				array = new ArrayList<Person>();
			}
			public void bubbleUp(){
				int k = array.size()-1 ;
				while (k > 0) {
					int parent = (k - 1) / 2;
					if (array.get(k).relativeDistance < array.get(parent).relativeDistance) {
					Person temp = array.get(parent);
					array.set(parent, array.get(k));
					array.set(k, temp);
					k = parent;
					} else {
						break;
					}
				}
			}
			public void bubbleDown(){
				int k = 0 ;
				while (k < array.size() - 1) {
					int child = k + 1;
					if (array.get(k).relativeDistance >  array.get(child).relativeDistance){
					Person temp = array.get(child);
					array.set(child, array.get(k));
					array.set(k, temp);
					k = child;
					} else {
						break;
					}
				}
			}
			public Person extractMin()
					throws NoSuchElementException{
				if ( heapIsEmpty()){
					throw new NoSuchElementException(" Heap is empty, cannot extract MIN");
				}
				if (array.size() == 1) {
					return array.get(0);
				}
				Person min = array.get(0);
				array.set(0, array.get(array.size() - 1));
				array.remove(array.size()-1);
				bubbleDown();
				return min;
			}
			public void insert(Person element){
				array.add(element);
				bubbleUp();
			}
			public void printHeap(){
				for ( int i = 0; i < array.size(); i++) {
					System.out.print("  "+array.get(i));
				}
				System.out.print("\n");
			}
			public boolean heapIsEmpty(){
				return array.isEmpty();
			}
	}
	
	public class Person {
		String personName;
		Edge listOfFriends;
		double relativeDistance = Double.MAX_VALUE;
		boolean visit = false;
		Person next;
		public Person(String name, Edge frnd){
			this.personName = name;
			this.listOfFriends = frnd;
		}
	}
	
	public class Edge {
		double weight;
		int indexOfPerson;
		Edge next;
		public Edge(double w, int index, Edge frn){
			this.indexOfPerson = index;
			next = frn;
			weight = w;
		}
	}
	
	Person[] list;
	
	public Graph(){
		list = null;
	}
	
	public Graph(String fileName) 
			throws FileNotFoundException{
			Scanner sc = new Scanner(new File(fileName));
			String graphType = sc.next();
			int n = sc.nextInt(), i = 0;
			list = new Person[n];
			// read vertices, name read and listOfFriends assign null
			while( i < n) {
				list [i] =  new Person(sc.next(), null);
				i++;
			}
			
			// read connections between vertices
			while (sc.hasNext()) {
				int k1 =  nameToIndex(sc.next()); // convert name of person to index of person
				double w = sc.nextDouble();
				int k2 = nameToIndex(sc.next());
				//if both indexes exist assign to person index k1 new friend with index k2
				list[k1].listOfFriends = new Edge (w, k2, list[k1].listOfFriends);
				// by conditional operator of the next line directed graph ----> undirected graph
				if (graphType.equalsIgnoreCase("undirected")) {
				list[k2].listOfFriends = new Edge (w, k1,  list[k2].listOfFriends);
				}
			}
	}
	// convert name of person to index of person
	int nameToIndex(String check) {
		for (int k = 0; k < list.length; k++) {
			if (list[k].personName.equals(check) ) {
				return k;
			}
		}
		return -1;
	}
	
	public void print(){
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i].personName+" has link to");
			for (Edge frnd = list[i].listOfFriends; frnd != null; frnd = frnd.next){
				System.out.println(list[frnd.indexOfPerson].personName+" path = "+frnd.weight);
			}
		}
	}
	
	public double shortestPath(String start, String finish ) {
			Heap<Person> heap = new Heap<Person>();
			Person source = null;
			Person end = null;
			for (int i = 0; i < list.length; i++ ){
				heap.insert(list[i]);
				if (list[i].personName.equals(start)) {source = list[i]; }
				if (list[i].personName.equals(finish)) {end = list[i]; }
			}
			source.relativeDistance = 0;
			Person current = source;
			while (! heap.heapIsEmpty()){
				double temp;
				for (Edge edge = current.listOfFriends; edge != null; edge = edge.next){
					temp = current.relativeDistance + edge.weight;
					if (temp < list[edge.indexOfPerson].relativeDistance){
						list[edge.indexOfPerson].relativeDistance = temp;
					}
				}
				heap.extractMin();
				current = heap.array.get(0);
				if (heap.array.size() == 1) {
					break;
				}
				//System.out.println("Error"+ current.personName+"  "+current.relativeDistance);
			}
			System.out.println("Shortest path from "+start+" to "+finish+" = "+end.relativeDistance);
			return end.relativeDistance;
	}
	
		public void dfs(String start, String finish){
			Person source = null;
			Person end = null;
			for (int i = 0; i < list.length; i++ ){
				if (list[i].personName.equals(start)) {source = list[i]; }
				if (list[i].personName.equals(finish)) {end = list[i]; }
			}
			System.out.println("Start "+ source.personName+"  End "+end.personName);
			Person current = source;
			Stack stack = new Stack();
			stack.add(current);
			while ( ! stack.isEmpty()) {
				System.out.print(current.personName+" ---> ");
				if (current.listOfFriends == null) {
					current.visit = true;
					stack.remove();
					current = stack.first;
				} else {
				for (Edge edge = current.listOfFriends; edge != null; edge = edge.next){
					if ( ! list[edge.indexOfPerson].visit) {
						current = list[edge.indexOfPerson];
						stack.add(current);
						current.visit = true;
						break;
						}
					if (edge.next == null) {
						current.visit = true;
						stack.remove();
						current = stack.first;
					}
					}
				}
			}
			for (int i = 0; i < list.length; i++ ){
				if (!list[i].visit) {dfs(list[i].personName, finish);}
			}
			return;
		}

		public static void main(String[] args)
				throws FileNotFoundException {
			String name = "D://Path.txt";
			Graph graph = new Graph(name);
			graph.print();
			//graph.shortestPath("A", "F");
			graph.dfs("B", "F");
		}
}