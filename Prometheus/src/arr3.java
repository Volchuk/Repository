	import java.util.Random;
public class arr3 {

	public static void main(String[] args) {
			// TODO Auto-generated method stub
			int n=12;
			int max=10;
			int min=1;
			int[] Arr = new int[n];
			for (int i=0; i<Arr.length;i++) {
				Random rand=new Random();
				Arr[i]=rand.nextInt(max-min+1)+min;
				System.out.print(Arr[i]+" ");
				}
				int ArrMax=Arr[0];
				for (int i=0; i<Arr.length-1;i++) {
					if (Arr[i]>ArrMax){
						ArrMax=Arr[i];
					}
				}	
				System.out.print("\n"+ArrMax);
			}
		}