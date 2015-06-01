
public class secondMax {
	public static int returnSecond(int[] a){
		if (a.length < 2) {
		System.out.println("array is not long enough");
		return 0;
		}
		int min = a[0];
		int minSecond = a[0];
		for(int i = 0; i < a.length; i++){
		if (a[i] < min){
			min = a[i];
		}
		}
		System.out.println("Smallest is "+min);
		for(int i = 0; i < a.length; i++){
		if (a[i] < minSecond && a[i] > min){
			minSecond = a[i];
		}
		}
		return minSecond;
		}
	
	public static void main(String[] args){
		
		int[] arr = new int[4];
		arr[0] = 47;
		arr[1] = 5;
		arr[2] = 12;
		arr[3] = 6;
		int k = returnSecond(arr);
		System.out.println("Second smallest is "+k);
	}
}
