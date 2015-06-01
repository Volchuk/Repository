
public class test {

    public static String reverse(String s){
    	char[] letters = s.toCharArray();
    	for (int i=0;i<s.length()/2;i++) {
    		char prev=letters[i];
    		char next=letters[s.length()-1-i];
    		letters[i]=next;
    		letters[s.length()-1-i]=prev;
    	}

    	return new String(letters);
    }
	public static void main(String[] args) {
		String s="Hello my Friend";
		System.out.println(reverse(s));
	}
}