package vowels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VowelCounter {
	
	public static Map<String,Integer> wordmap = new HashMap<>(); 
	public static List<String> words = new ArrayList<String>();
	public static Scanner st = new Scanner(System.in);

	public static void main(String[] args) {
		
		Input();
		buildingMap();
		vowelCounting();
		
	}
	
public static void Input() {
		
		System.out.println("Enter the list of words.");
		String input = st.nextLine();
		while(!input.equalsIgnoreCase("quit")) {
			buildList(input);
			input = st.nextLine();
		}
	}

private static void buildingMap() {
	
	for(int i=0;i<words.size();i++) {
		wordmap.put(words.get(i),NoOfVowels(words.get(i)));
	}
	
}

	
	
	private static void vowelCounting() {
		
		System.out.println("Enter a word to find number of vowels in it!");
		System.out.println("'quit' for quitting the program");
		String inp = st.nextLine();
		while(!inp.equalsIgnoreCase("quit")) {
			VowelsFromMap(inp);
			inp = st.nextLine();
		}
		
	}


	
	public static void buildList(String word) {
		words.add(word);
	}
	
	public static int NoOfVowels(String word) {
		int vowels=0;
		for(int i=0;i<word.length();i++) {
			if(word.charAt(i)=='a'||word.charAt(i)=='e'||word.charAt(i)=='i'||word.charAt(i)=='o'||word.charAt(i)=='u') 
				vowels++;
		}
		
		return vowels;
	}
	
	public static void VowelsFromMap(String word) {
		if(wordmap.containsKey(word)) {
			System.out.println("No. of vowels in "+word+" are:"+wordmap.get(word));
		}
		else {
			System.out.println("Not found");
		}
	}

}
	


