public class test1 {

	public static int onesc(int a){
		int count = 0, temp;
		for (int i=30;i>=0;i--) {
			 if (a==0){
					return count;
				}
			 temp = a;
			 if(Math.abs(temp)>=(int)(Math.pow(2,i))){
			temp=Math.abs(temp)-(int)(Math.pow(2,i));
			 }
			if (Math.abs(a)>Math.abs(temp)){
				a=temp;
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int a = 65535;
		System.out.println(onesc(a));

	}
}
