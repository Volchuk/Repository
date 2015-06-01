import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class qsort {
	private static void sortQuick(ArrayList<Integer> arrList, int low, int high){
		int i = partition(arrList, low, high);
		if (low < i-1) {
		sortQuick(arrList, low, i-1); }
		if (i < high) {
		sortQuick(arrList, i, high); }
	}
	private static int partition (ArrayList<Integer> arrList, int low, int high){
		int j = high, i = low;
		int temp;
		int p = arrList.get((low+high)/2);
		while( i <= j ) {
			while(arrList.get(i) < p ) {
				i++;
			}
			while (arrList.get(j) > p ) {
				j--;
			}
			if(i <= j) {
				temp = arrList.get(j);
				arrList.set(j, arrList.get(i));
				arrList.set(i, temp);
				i++;
				j--;
				}
				}
		return i;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(); 
		String name = "D:\\Homework1.txt";
		try {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner (new File(name));
		while(sc.hasNextInt()){
			list.add(sc.nextInt());
		}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sortQuick(list, 0, (list.size()-1));
		System.out.print(list+"\n"+list.size());
	}
}