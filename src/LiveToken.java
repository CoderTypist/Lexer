
public class LiveToken extends Token {
	
	private int startCol;
	private int endCol;
	private int lineNumber;

	public LiveToken(Token t, InputStreamState state) {
		super(t.getType(), t.getValue());
		initLive(state);
	}
	
	public LiveToken(TokenType type, String value, InputStreamState state) {
		super(type, value);
		initLive(state);
	}
	
	private void initLive(InputStreamState state) {
		this.startCol = state.getCol();
		
		if( 0 == getValue().length() ) {
			this.endCol = this.startCol;
		}
		else {
			this.endCol = ( state.getCol() + getValue().length() ) - 1;
		}
		
		this.lineNumber = state.getLineNumber();
	}
	
	public int getStartCol() {
		return this.startCol;
	}

	public int getEndCol() {
		return this.endCol;
	}

	public int getLineNumber() {
		return this.lineNumber;
	}
}
