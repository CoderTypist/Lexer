
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class InputStream {
	
	private String text;
	private int length;
	private int numLines;
	
	private int index;
	private int col;
	private int prevCol;
	private int lineNumber;
	
	public InputStream(String fpath) {
		
		this.text = "";
		this.length = 0;
		this.numLines = 1;
		
		this.index = 0;
		this.col = 1;
		this.prevCol = 0;
		// lineNumber starts at 1, not 0
		this.lineNumber = 1;
		
		BufferedReader bf = null;
		try {
			bf = new BufferedReader(new FileReader(fpath));
			
			String strLine = bf.readLine();
			
			// read each line
			for ( int i = 1 ; null != strLine ; i++ ) {
				
				if ( i > 1 ) {
					this.text += "\n";
					this.length += 1;
					this.numLines += 1;
				}
				this.text += strLine;
				this.length += strLine.length();
				strLine = bf.readLine();
			}
			// does not counts towards this.length
			this.text += Character.MIN_VALUE;
		}
		
		catch(FileNotFoundException e) { 
			System.out.println("InputStream: constructor: No such file: " + fpath);
			e.printStackTrace();
		}
		
		catch(IOException e) {
			System.out.println("InputStream: constructor: I/O error: " + fpath);
			e.printStackTrace();
		}
		
		finally {
			if ( null != bf ) {
				try {
					bf.close();
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public char getNext() {
		char c = this.text.charAt(this.index);
		
		if ( Character.MIN_VALUE != c ) {
			// newline character
			if ( '\n' == c ) {
				this.lineNumber += 1;
				this.prevCol = this.col;
				this.col = 1;
			}
			// any other character
			else {
				this.col += 1;
			}
			// all characters
			this.index += 1;
		}
		
		return c;
	}
	
	// returned String may contain Character.MIN_VALUE
	public String getMultipleNext(int n) {
		String text = "";
		for( int i = 0 ; i < n ; i++ ) {
			text += getNext();
		}
		return text;
	}
	
	public String peekMultipleNext(int n) {
		InputStreamState state = getState();
		String text = getMultipleNext(n);
		setState(state);
		return text;
	}
	
	public void backspace() {
		
		// can't backspace at the beginning
		if( this.index == 0 ) {
			return;
		}
		
		// the last character consumed is at this.index-1
		// this.index is the next character to get
		char c =  this.text.charAt(this.index-1);
		
		// if at EOF
		if ( Character.MIN_VALUE == c ) {
			return;
		}
		// if the first character has not been read yet
		else if ( 0 == this.index ) {
			return;
		}
		// if going back a line
		else if ( '\n' == c ) {
			this.col = this.prevCol;
			this.lineNumber -= 1;
			this.index -= 1;
		}
		// if just going back a character
		else {
			this.col -= 1;
			this.index -= 1;
		}
	}
	
	public char peekNext() {
		return this.text.charAt(this.index);
	}
	
	public InputStreamState getState() {
		return new InputStreamState(this.index, this.col, this.prevCol, this.lineNumber);
	}
	
	// should be used to restore to a previous state
	public void setState(InputStreamState state) {
		this.index = state.getIndex();
		this.col = state.getCol();
		this.prevCol = state.getPrevCol();
		this.lineNumber = state.getLineNumber();
	}
	
	// used when an error is found in a line
	public void skipLine() {
		char c;
		do {
			c = getNext();
		} while ( Character.MIN_VALUE != c && '\n' != c );
	}
	
	public String getText() {
		return this.text;
	}
	
	public int getLength() {
		return this.length;
	}
	
	public int getNumLines() {
		return this.numLines;
	}

	public int getIndex() {
		return this.index;
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
		String s = "InputStream:\n";
		s += "\t- length: " + this.length + "\n";
		s += "\t- num lines: " + this.numLines + "\n";
		s += getState().toString();
		return s;
	}
	
	/************************************************************************************************/
	// DEBUGGING AND TESTING
	/************************************************************************************************/
	
	public String charToDisplayStr(char c) {
		
		// newline
		if ( '\n' == c ) {
			return "<newline>";
		}
		// tab
		else if ( '\t' == c ) {
			return "<tab>";
		}
		// space
		else if ( ' ' == c ) {
			return "<space>";
		}
		// EOF
		else if ( Character.MIN_VALUE == c ) {
			return "<EOF>";
		}
		else {
			return Character.toString(c);
		}
	}
	
	// Print every character in the InputStream
	public void inspectStream() {
		
		// get the current state
		InputStreamState state = getState();
		
		// print each character along with the index
		char c;
		for( ; index< this.text.length() ; index++ ) {
			System.out.print("text[" + index + "]: ");
			c = this.text.charAt(index);
			System.out.println(charToDisplayStr(c));
		}
		
		// restore the old state
		setState(state);
	}
	
	public void printMultipleNext(int n) {
		
		if ( n <= 0 ) {
			return;
		}
		
		InputStreamState state = getState();
		
		char c;
		for ( int i = 0 ; i < n ; i++ ) {
			c = getNext();
			System.out.println(i + ": " + charToDisplayStr(c));
		}
		
		setState(state);
	}
	
}
