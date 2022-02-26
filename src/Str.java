import java.util.HashSet;
import java.util.Set;

public class Str {
	
	private Str() {}
	
	public static String visifySpecialWhitespace(String s) {
		return s.replaceAll("\t", "\\\\t").replaceAll("\n",  "\\\\n");
	}
	
	public static String visifyWhitespace(String s) {
		return s.replaceAll(" ", "\\\\s").replaceAll("\t", "\\\\t").replaceAll("\n",  "\\\\n");
	}
	
	// functionality not available in older versions of Java
	public static String repeat(String s, int n) {
		String repeated = "";
		
		for( int i = 0 ; i < n ; i++ ) {
			repeated += s;
		}
		return repeated;
	}
	
	public static String toSetStr(String ... strings) {
		
		// append all Strings into one larger String
		String allStr = "";
		for( String s : strings ) {
			allStr += s;
		}
		
		// create a Set of Unique Characters
		Set<Character> chars = new HashSet<Character>();
		for( int i = 0 ; i < allStr.length(); i++ ) {
			chars.add(new Character(allStr.charAt(i)));
		}
		
		// convert the Set to a String
		String setStr = "";
		for( Character c : chars ) {
			setStr += Character.valueOf(c);
		}
		
		return setStr;
	}
}
