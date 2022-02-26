
public class Main {

	public static void main(String[] args) {
		
		String path = args[0];
		Lexer lex = new Lexer(new DecafLexicalRules());
		lex.tokenize(new InputStream(path));
		
		// (new InputStream(path)).inspectStream();
	}
}