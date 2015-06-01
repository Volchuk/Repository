import java.util.ArrayList;
import java.util.NoSuchElementException;

// heap where root is the least number
public class Heap<T extends Comparable<T>> {

	private ArrayList<T> array;
		
		public Heap(){
			array = new ArrayList<T>();
		}
		private void bubbleUp(){
			int k = array.size()-1 ;
			while (k > 0) {
				int parent = (k - 1) / 2;
				if (array.get(k).compareTo(array.get(parent) ) < 0){
				T temp = array.get(parent);
				array.set(parent, array.get(k));
				array.set(k, temp);
				k = parent;
				} else {
					break;
				}
			}
		}
		private void bubbleDown(){
			int k = 0 ;
			while (k < array.size() - 1) {
				int child = k + 1;
				if (array.get(k).compareTo(array.get(child) ) > 0){
				T temp = array.get(child);
				array.set(child, array.get(k));
				array.set(k, temp);
				k = child;
				} else {
					break;
				}
			}
		}
		public T extractMin()
				throws NoSuchElementException{
			if ( heapIsEmpty()){
				throw new NoSuchElementException(" Heap is empty, cannot extract MIN");
			}
			if (array.size() == 1) {
				return array.get(0);
			}
			T min = array.get(0);
			array.set(0, array.get(array.size() - 1));
			array.remove(array.size()-1);
			bubbleDown();
			return min;
		}
		public void insert(T element){
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

		public static void main(String[] args) {
			Heap<Integer> heap = new Heap<Integer>();
			heap.heapIsEmpty();
			heap.insert(13);
			heap.insert(11);
			heap.insert(12);
			heap.insert(9);
			heap.insert(5);
			heap.insert(4);
			heap.insert(9);
			heap.insert(8);
			heap.insert(4);
			heap.printHeap();
			System.out.println("Min = "+heap.extractMin());
			heap.printHeap();
			System.out.println("Min = "+heap.extractMin());
			heap.printHeap();
			System.out.println("Min = "+heap.extractMin());
			heap.printHeap();
			System.out.println("Min = "+heap.extractMin());
			heap.printHeap();
		}
}
