import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Cities {

	City[] list;
			
		public class City {
			String cityName;
			Neighbor listOfNeighbors;
			double relativeDistance = Double.MAX_VALUE;
			
			public City(String name, Neighbor neigh){
				this.cityName = name;
				this.listOfNeighbors = neigh;
			}
		}
		
		public class Neighbor {
			double distance;
			int indexOfCity;
			Neighbor next;
			
			public Neighbor(double d, int index, Neighbor neigh){
				this.indexOfCity = index;
				this.next = neigh;
				this.distance = d;
			}
		}
		
		public Cities() {
			int s, n, p, nr, cost, r;
				System.out.println("Enter");
				System.out.println("Number of tests:");
				Scanner sc = new Scanner(System.in);
				s = sc.nextInt(); // number of tests
				for (int l = 0; l < s; l++){
				System.out.println("Number of cities:");
				n = sc.nextInt(); // number of cities
				list = new City[n];
					for (int k = 0; k < n; k++) {
						System.out.println("Name of city:");
						list[k] = new City(sc.next(), null);
						System.out.println("Number of neighbors of this city:");
						p = sc.nextInt(); // number of neighbors of particular city
							for (int y = 0; y < p; y ++) {
								System.out.println("index of neighbor");
								nr = sc.nextInt() - 1; // index of neighbor
								System.out.println("distance to this neighbor");
								cost = sc.nextInt(); // distance to neighbor
								list[k].listOfNeighbors = new Neighbor (cost, nr, list[k].listOfNeighbors);
							}
					}
					System.out.println("Enter number of paths");
					r = sc.nextInt();
					for (int u = 0; u < r; u++) {
						System.out.println("Enter names of 2 cities to compute path: ");
						String start = sc.next();
						String finish = sc.next();
						shortestPath(start, finish);
					}
				}
				sc.close();
		}
		
		public double shortestPath(String start, String finish) {
			// compute shortest path using heap data structure
				Heap <City> heap = new Heap <City> ();
				City source = null;
				City end = null;
				// find such cities in 'City []' 
				for (int i = 0; i < list.length; i++ ){
					// insert cities into heap
					heap.insert(list[i]);
					if (list[i].cityName.equals(start)) {source = list[i]; }
					if (list[i].cityName.equals(finish)) {end = list[i]; }
				}
				// relative distance of 'source' where path starts is zero
				source.relativeDistance = 0;
				City current = source;
				// iterate while heap is not empty
				while (! heap.heapIsEmpty()){
					double temp;
					// for current City look through all neighbors
					for (Neighbor neigh = current.listOfNeighbors; neigh != null; neigh = neigh.next){
						// compute temporary relative distance
						// relative distance is sum of
						// relative distance of current City + distance to neighbor
						temp = current.relativeDistance + neigh.distance;
						// compare temporary distance with existing
						// if new distance from source is smaller
						// assign 'relativeDistance' = 'temp'
						if (temp < list[neigh.indexOfCity].relativeDistance){
							list[neigh.indexOfCity].relativeDistance = temp;
						}
					}
					// extract City with minimum distance from starting point
					heap.extractMin();
					// new City with minimum distance will take place
					current = heap.array.get(0);
					// if Heap contains only one Node
					// we reached the destination
					if (heap.array.size() == 1) {
						break;
					}
				}
				System.out.println("Shortest path from "+start+" to "+finish+" = "+end.relativeDistance);
				return end.relativeDistance;
		}
		
		// heap where root is the least number
		public class Heap <T> {
			// heap is organized as ArrayList with array(0) as root
			public ArrayList <City> array;
				
				public Heap(){
					array = new ArrayList <City>();
				}
				// method to move Node up the Heap to suitable place
				// if its value is less than of parent
				public void bubbleUp(){
					int k = array.size()-1 ;
					while (k > 0) {
						int parent = (k - 1) / 2;
						if (array.get(k).relativeDistance < array.get(parent).relativeDistance) {
						City temp = array.get(parent);
						array.set(parent, array.get(k));
						array.set(k, temp);
						k = parent;
						} else {
							break;
						}
					}
				}
				// method to move Node down the Heap
				// if its value greater than of parent
				public void bubbleDown(){
					int k = 0 ;
					while (k < array.size() - 1) {
						int child = k + 1;
						if (array.get(k).relativeDistance >  array.get(child).relativeDistance){
						City temp = array.get(child);
						array.set(child, array.get(k));
						array.set(k, temp);
						k = child;
						} else {
							break;
						}
					}
				}
				// removes the minimum == root of Heap
				// and moves the next least to root place
				public City extractMin()
						throws NoSuchElementException{
					if ( heapIsEmpty()){
						throw new NoSuchElementException(" Heap is empty, cannot extract MIN");
					}
					if (array.size() == 1) {
						return array.get(0);
					}
					City min = array.get(0);
					array.set(0, array.get(array.size() - 1));
					array.remove(array.size()-1);
					bubbleDown();
					return min;
				}
				public void insert(City element){
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

			public static void main(String[] args) {
				Cities cities = new Cities();
			}
	}
