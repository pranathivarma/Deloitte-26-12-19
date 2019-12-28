package strings;

import java.util.Arrays;

public class StringManip {

	public static void main(String[] args) {
		String str = new String();
		str="This is a text.";
		String st = new String("This is a line of text");
		System.out.println(str==st);
		System.out.println(str.equals(st));
		str = st;
		System.out.println(str == st);
		System.out.println(str.equals(st));
		
		//int len = str.length();
		
		int indexOfC = str.indexOf('t');
		System.out.println(indexOfC);
		
		int lastIndexOft = str.lastIndexOf('t');
		System.out.println(lastIndexOft);
		int count = 0;
		for(char c : str.toCharArray()) {
			if(c == 't') {
				++count;
			}
		}
		System.out.println("t occurs "+count+" times.");
		
		locate("text", str);
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("<html>");
		buffer.append("<head><title>My Web Page</title></head>");
		buffer.append("<body>");
		buffer.append("<h1>This is my web profile</h1>");
		buffer.append("</body></html>");
		
		System.out.println(buffer.toString());
		System.out.println(CheckPalindrome("malayalam"));
		System.out.println(CheckPalindrome("able was i ere i saw elba"));
		System.out.println(CheckPalindrome("malayalam123"));
		
		String text="the quick brown fox jumps over a lazy dog";
		System.out.println(numAlphabet(text));
		
	}
	
	public static boolean CheckPalindrome(String text) {
		StringBuffer sb = new StringBuffer(text);
	    sb = sb.reverse();
	    return text.contentEquals(sb.toString());
		
	}
	//the quick brown fox jumps over a lazy dog
	public static int numAlphabet(String text) {
		String chars = "";
		
		for(char c : text.toCharArray()) {
			if(!chars.contains(c+"") && c != ' ') {
				chars += c;
			}
		}
		char[] ch=chars.toCharArray();
		Arrays.sort(ch);
		System.out.println(new String(ch));
		System.out.println();
		return chars.length();
	}
	
	public static void locate(String word,String line) {
		
		if(line.contains(word)) {
			int start = line.indexOf(word);
			int end = start + word.length()-1;
		    System.out.println(start+":"+end);
		}
		
		//line.substring(start,end)
			
	}

}
