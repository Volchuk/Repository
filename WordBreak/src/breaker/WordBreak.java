package breaker;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordBreak {

	private Set<String> dictionary;
	
	public void createDictionary() {
		dictionary = new HashSet<String>();
		Scanner wordReader = new Scanner(System.in);
		
		while (true) {
			System.out.println("Put the new word");
			dictionary.add(wordReader.next());
			System.out.println("Wish to stop? Type \"Yes\" ");
			
			if (wordReader.next().equals("Yes")) {
				wordReader.close();
				return;
			}
		}
	}
	
	public boolean wordBreak(String s, Set<String> dictionary) {
		
		String words = "";
		
		for (int i = 0; i <= s.length(); i++) {
			
			for (int k = i; k <= s.length(); k++) {
				
				if (dictionary.contains(s.substring(i, k))) {
					words += s.substring(i, k) + ", ";
					i = k ;
				}
			}
		}
		
		System.out.println(words);
		if (words.equals("")) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public static void main(String[] args) {
		WordBreak test1 = new WordBreak();
		test1.createDictionary();
		test1.wordBreak("typeawordhere", test1.dictionary);
	}
}
