public class arr2 {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			int n=20;
			int[] Arr = new int[n];
			Arr[0]=1;
			Arr[1]=1;
			for (int i=2; i<Arr.length;i++) {
				Arr[i]=Arr[i-1]+Arr[i-2];
				}
			for (int i=0; i<Arr.length;i++) {
				System.out.print(Arr[i]+" ");
				}

		}
}