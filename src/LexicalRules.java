import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public abstract class LexicalRules {
	
	private boolean isInit;

	private Macro macro;
	private HashMap<String, TokenType> keywords;
	private ArrayList<TokenDefinition> tokenDefinitions;
	private int identifierMaxLength;
	
	public LexicalRules() {
		this.isInit = false;
		this.macro = new Macro();
		this.keywords = new HashMap<String, TokenType>();
		this.tokenDefinitions = new ArrayList<TokenDefinition>();
		
		initKeywords();
		initMacro();
		initTokenDefinitions();
		initIdentifierMaxLength();
		
		this.isInit = true;
	}
	
	public abstract void initKeywords();
	public abstract void initMacro();
	public abstract void initTokenDefinitions();
	public abstract void initIdentifierMaxLength();
	public abstract TokenType getTextTokenType(String token);
	public abstract void showNextToken(InputStream stream) throws StreamTokenizationException;
	// does not handle numerical types or string literals (e.g., "hello")
	
	public void addTokenDefinition(TokenDefinition ... tokenDefinitions) {
		for( TokenDefinition td : tokenDefinitions ) {
			this.tokenDefinitions.add(td);
		}
	}
	
	// ex: int          line 3 cols 1-3 is T_Int
	public void showTypeOnly(LiveToken lt) {
		String value = Str.visifySpecialWhitespace(lt.getValue());
		System.out.printf("%-12s line %d cols %d-%d is %s\n", value, lt.getLineNumber(), lt.getStartCol(), lt.getEndCol(), lt.getType().toString());
	}
	
	// ex: <            line 17 cols 1-1 is '<'
	public void showValueOnly(LiveToken lt) {
		String value = Str.visifySpecialWhitespace(lt.getValue());
		String displayValue = Str.visifySpecialWhitespace(lt.getDisplayValue());
		System.out.printf("%-12s line %d cols %d-%d is '%s'\n", value, lt.getLineNumber(), lt.getStartCol(), lt.getEndCol(), displayValue);
	}
	
	// ex: true         line 11 cols 1-4 is T_BoolConstant (value = true)
	public void showTypeAndValue(LiveToken lt) {
		String value = Str.visifySpecialWhitespace(lt.getValue());
		String displayValue = Str.visifySpecialWhitespace(lt.getDisplayValue());
		System.out.printf("%-12s line %d cols %d-%d is %s (value = %s)\n", value, lt.getLineNumber(), lt.getStartCol(), lt.getEndCol(), lt.getType().toString(), displayValue);
	}
	
	// does NOT modify the LiveToken (i.e., does not change value or TokenType)
	// TokenType would be language specific, so the value is also left alone
	public void showIdentifierTooLong(LiveToken lt) {
		String value = lt.getValue();
		System.out.printf("%s line %d cols %d-%d is %s (truncated to %s)\n", value, lt.getLineNumber(), lt.getStartCol(), lt.getEndCol(), lt.getType().toString(), value.substring(0, identifierMaxLength));
	}
	
	// used for whitespace
	public void showNothing(LiveToken lt) {
		return;
	}
	
	public Set<String> getKeywordsSet() {
		return this.keywords.keySet();
	}
	
	public HashMap<String, TokenType> getKeywordsHashMap() {
		return this.keywords;
	}
	
	protected boolean getIsInit() {
		return this.isInit;
	}

	protected void setIsInit(boolean isInit) {
		this.isInit = isInit;
	}
	
	public Macro getMacro() {
		return this.macro;
	}
	
	public ArrayList<TokenDefinition> getTokenDefinitions() {
		return this.tokenDefinitions;
	}
	
	public int getIdentifierMaxLength() {
		return this.identifierMaxLength;
	}
	
	public void setIdentifierMaxLength(int identifierMaxLength) {
		this.identifierMaxLength = identifierMaxLength;
	}
	
	public boolean isKeyword(String s) {
		return this.keywords.containsKey(s);
	}
	
	
}
