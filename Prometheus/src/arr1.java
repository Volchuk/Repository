import  java.util.Random;
public class arr1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=4;
		int max=10;
		int min=1;
		int count=1;
		int[] Arr = new int[n];
		for (int i=0; i<Arr.length;i++) {
			Random rand=new Random();
			Arr[i]=rand.nextInt(max-min+1)+min;
			System.out.print(Arr[i]+" ");
			}
			for (int i=0; i<Arr.length-1;i++) {
				if (Arr[i]<Arr[i+1]){
					count++;
					Arr[i]=0;
					}
				}
			if (count==Arr.length){
				System.out.println("ѕоследовательность строго возрастает");
			}
			else {
				System.out.println("ѕоследовательность не возрастающа€");
			}
		}
	}