	
public class MergeSort {
		
	public static int[]  sortMerge(int[] array){
		int n = array.length;
		int[] help = new int[n];
		//System.out.println("\n"+"length n = " + n);
		if (n > 1) {
		int[] arrA = fillSubArray(array, n/2, 0);
		int[] arrB = fillSubArray(array, n-n/2, n/2);
		// recursion
		arrA = sortMerge(arrA);
		arrB = sortMerge(arrB);
		help = MergeSubArrays(arrA, arrB);
		return help;
		}
		return array;			
	}
		// merge subArrays A and B
		public static int[] MergeSubArrays(int[] SubArr1, int[] SubArr2){
			int[] aux = new int[SubArr2.length + SubArr1.length];
			int i = 0, j = 0, k = 0;
			while (k < aux.length) {
				if (i >= SubArr1.length){ aux[k] = SubArr2[j]; j++; }
				else if (j >= SubArr2.length ){ aux[k] = SubArr1[i]; i++; }
				if ( i < SubArr1.length && j < SubArr2.length){
					if ( SubArr1[i] < SubArr2[j] ) {
					aux[k] = SubArr1[i];
					i++;
					} else if (SubArr1[i] > SubArr2[j]) {
					aux[k] = SubArr2[j];
					j++;
					}
				}
				//System.out.println("aux "+"["+k+"] = "+aux[k]);
				k++;
			}
				return aux;
			}
		public static int[] fillSubArray(int[] array, int leng, int low){
			int[] SubArray = new int[leng];
			for(int i = 0; i < leng; i++){
				SubArray[i] = array [i+low];
				//System.out.println("SubArray "+SubArray[i]);
			}
			return SubArray;
		}
			
	public static void main(String[] args) {
		int[] arr = new int[5];
		for (int i = 0; i < arr.length; i++){
			arr[i] = (int) (Math.random()*100);
			System.out.print(arr[i]+ " ");
		}
		System.out.println("\n");
		arr = sortMerge(arr);
		for (int l = 0; l < arr.length; l++){
			System.out.print(arr[l]+ " ");
		}
	}
}
