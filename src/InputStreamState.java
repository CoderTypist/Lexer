
public class InputStreamState {
	
	private int index;
	private int col;
	private int prevCol;
	private int lineNumber;
	
	public InputStreamState(int index, int col, int prevCol, int lineNumber) {
		this.index = index;
		this.col = col;
		this.prevCol = prevCol;
		this.lineNumber = lineNumber;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public int getCol() {
		return this.col;
	}
	
	public int getPrevCol() {
		return this.prevCol;
	}
	
	public int getLineNumber() {
		return this.lineNumber;
	}
	
	@Override
	public String toString() {
		String s = "InputStreamState:\n";
		s += "\t- index: " + this.index + "\n";
		s += "\t- column: " + this.col + "\n";
		s += "\t- prev col: " + this.prevCol + "\n";
		s += "\t- line #: " + this.lineNumber + "\n";
		return s;
	}
}
