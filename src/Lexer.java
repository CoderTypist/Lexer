
public class Lexer {
	
	private LexicalRules rules;
	
	public Lexer(LexicalRules rules) {
		this.rules = rules;
	}
	
	public void tokenize(InputStream stream) {
		
		// loop while not at the end
		while( Character.MIN_VALUE != stream.peekNext() ) {
			
			try {
				Debug.out.println("- Lexer: tokenize(): calling LexicalRules.showNextToken()");
				
				// ideal spot for breakpoint
				rules.showNextToken(stream);
			}
			catch ( StreamTokenizationException e ) {
				e.printStackTrace();
				return;
			}
		}
	}
	
	public LexicalRules getRules() {
		return this.rules;
	}
}