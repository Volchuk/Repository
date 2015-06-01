public class CountHowManyOnesInBinaryNumber {

	public static int onesc(int a){
		int count = 0;
		for (int i=31;i>=0;i--) {
			 if (a==0){
					return count;
				}
			 if(Math.abs(a)>=(int)(Math.pow(2,i))){
			a=Math.abs(a)-(int)(Math.pow(2,i));
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int a = 7;
		System.out.println(onesc(a));

	}
}
