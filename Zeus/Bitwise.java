
public class Bitwise {

	public static int bitwiseAnd(int m, int n){
		int result = Integer.MAX_VALUE;
		if (m < n) {
		for (int i = m; i <= n; i++){
			result = result & i;
		}
		} else {
			System.out.println(" Interval incorrect");
			return 0;
		}
		return result;
	}
	
	public static int bitwiseAndAnother(int m, int n){

			char[] binM = Integer.toBinaryString(m).toCharArray();
			char[] binN = Integer.toBinaryString(n).toCharArray();
			char[] result = new char[binN.length];
			for (int i = 0; i <= binN.length; i++) {
				if (binM[i] == '0'){
					for (int j = i; j < binN.length; j++){
						result[j] = '0';
					}
					break;
				} else {
					result[i] = '1';
				}
			}
			System.out.println(binM);
			System.out.println(binN);
			System.out.println(result);
		return Integer.parseInt((new String(result)), 2);
	}
	
	
	public static void main(String[] args) {
		int m = 5;
		int n = 7;
		System.out.println("One & in interval [ "+m+", "+n+" ] = "+bitwiseAnd(m, n));
		System.out.println("Another & in interval [ "+m+", "+n+" ] = "+bitwiseAndAnother(m, n));
	}

}
