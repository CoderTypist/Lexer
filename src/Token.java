
public class Token {
	
	private TokenType type;
	private String value;
	private String displayValue;
	
	public Token(TokenType type, String value) {
		this.type = type;
		this.value = value;
		this.displayValue = value;
	}
	
	public Token(TokenType type, String value, String displayValue) {
		this.type = type;
		this.value = value;
		this.displayValue = displayValue;
	}
	
	public TokenType getType() {
		return this.type;
	}
	
	public void setType(TokenType type) {
		this.type = type;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getDisplayValue() {
		return this.displayValue;
	}
	
	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}
}
