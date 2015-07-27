import java.util.Random;
public class arr4 {

	public static void main(String[] args) {
			// TODO Auto-generated method stub
			int n=11;
			int max=9;
			int min=0;
			int[] Arr = new int[n];
			for (int i=0; i<Arr.length;i++) {
				Random rand=new Random();
				Arr[i]=rand.nextInt(max-min+1)+min;
				System.out.print(Arr[i]+" ");
				}
			
			System.out.print("\n");
				int[] k=new int[n];
				for (int j=0; j<Arr.length; j++){
					k[j]=1;
					for (int i=0; i<Arr.length;i++) {
						if(j==Arr.length-1&&i==Arr.length-1){
							break;
						}
						if(i==j&&i!=Arr.length-1){
							i++;
							}
							if(Arr[j]==Arr[i]){
							k[j]++;
									}
						}
					System.out.print(k[j]+" ");
					}
				int kmax=k[0];
				int FreqArr=Arr[0];
				for (int j=0; j<k.length;j++) {
					if (k[j]>kmax){
						kmax=k[j];
						FreqArr=Arr[j];
							}
						}
				int ind=0;
					for (int j=0; j<k.length;j++) {
						if (kmax==k[j]&&FreqArr!=Arr[j]){
							ind++;
							System.out.print("\n"+"most frequent element is none");
							break;
						}
							}
							if (ind==0){
		System.out.print("\n"+"most frequent element is "+FreqArr);
									}
		}
}