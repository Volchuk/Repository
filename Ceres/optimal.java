
public class optimal {

	public static int largestPalindromic(){
		int part1, pal, res1, res2, count = 0;
		String partFir, whole;
		for (int i = 9; i > 0; i--) {
			for (int j = 9; j >= 0; j--) {
				for (int k = 9; k >= 0; k--) {
					part1 = i*100+j*10+k;
					partFir = Integer.toString(part1);
					whole = partFir + new StringBuilder(partFir).reverse().toString();
					pal = Integer.parseInt(whole);
					for (int num = 999; num >= 1E2; num--) {
						res1 = pal % num;
						res2 = pal / num;
						count++;
						if ( res2 > 1E3) {
							break;
						}
						if (res1 == 0 && res2 < 1E3){
							System.out.println(res2 + " * "+ num + "  count "+count);
							return pal;
						}
					}
				}
			}
		}
		return 42;
	}
	public static void main(String[] args){
		long startTime = System.nanoTime();
		System.out.println("Largest palindromic "+ largestPalindromic()+" time "+(System.nanoTime() - startTime ));
	}
}
