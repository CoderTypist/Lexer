
public class LiteralComponent implements Component {
	
	public static final int UNBOUNDED = -1;
	private String validChars;
	private int min;
	private int max;
	
	// exception is only added here for consistency across constructors
	public LiteralComponent(String validChars) throws InvalidComponentConfigurationException {
		this.validChars = validChars;
		initMinMax(1, UNBOUNDED);
	}
	
	public LiteralComponent(String validChars, int min) throws InvalidComponentConfigurationException {
		this.validChars = validChars;;
		initMinMax(min, UNBOUNDED);
	}
	
	public LiteralComponent(String validChars, int min, int max) throws InvalidComponentConfigurationException {
		this.validChars = validChars;
		initMinMax(min, max);
	}
	
	private void initMinMax(int min, int max) throws InvalidComponentConfigurationException {
		
		if ( min <= 0 ) {
			throw new InvalidComponentConfigurationException("LiteralComponent: initMinMax(): min must be greater than 0");
		}
		
		if ( UNBOUNDED != max && max < min ) {
			throw new InvalidComponentConfigurationException("LiteralComponent: initMinMax(): max must be greater than or equal to min");
		}
		
		this.min = min;
		this.max = max;
	}
	
	@Override
	public String consume(InputStream stream) {
		
		Debug.out.println(Str.repeat("    ", 4) + "- LiteralComponent: consume(): validChars = " + Str.visifyWhitespace(this.validChars));	
		
		InputStreamState state = stream.getState();
		String text = "";
		char c;
		
		while ( true ) {
			c = stream.getNext();
			
			// next char is in the valid set of characters
			// constructors guarantee a this.min of at least 1
			if ( this.validChars.contains(""+c) ) {
				
				text += c;
				
				// component has reached max length
				if ( atMax(text) ) {
					Debug.out.println(Str.repeat("    ", 5) + "- LiteralComponent: consume(): found:" + Str.visifyWhitespace(text));
					return text;
				}
			}
			
			// next char is not in the valid set of characters
			else {
				
				// was able to fully build the literal component
				if ( text.length() >= this.min ) {
					Debug.out.println(Str.repeat("    ", 5) + "- LiteralComponent: consume(): found:" + text);
					// put the character we read back only if c != Character.MIN_VALUE
					// otherwise you will end up with a single character identifier or an error
					if( Character.MIN_VALUE != c ) {
						stream.backspace();
					}
					return text;
				}
				
				// was not able to fully build the literal component
				else {
					// reset the stream state
					stream.setState(state);
					return "";
				}
			}
			
		} // end while

	}
	
	private boolean atMax(String text) {
		if ( UNBOUNDED == this.max ) {
			return false;
		}
		else if ( text.length() >= this.max ) {
			return true;
		}
		return false;
	}
	
	public String getValidChars() {
		return this.validChars;
	}
	
	public int getMin() {
		return this.min;
	}
	
	public int getMax() {
		return this.max;
	}
}
