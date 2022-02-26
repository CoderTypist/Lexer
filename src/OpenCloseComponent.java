
public abstract class OpenCloseComponent implements Component {
	
	private boolean isTerminated;
	private String open;
	private String inbetween;
	private String close;
	
	public OpenCloseComponent(boolean isTerminated, String open, String inbetween, String close) {
		this.isTerminated = isTerminated;
		this.open = open;
		this.inbetween = inbetween;
		this.close = close;
	}
	
	@Override
	public String consume(InputStream stream) {
		
		InputStreamState state = stream.getState();
		String text = "";
		char c;
		
		String open = getOpen();
		// found open
		if ( open.equals(stream.peekMultipleNext(open.length())) ) {
			text += stream.getMultipleNext(open.length());
		}
		// did not find open
		else {
			stream.setState(state);
			return "";
		}
		
		String close = getClose();
		String peek = "";
		while( true ) {
			
			peek = stream.peekMultipleNext(close.length());
			// found close
			if ( close.equals(peek) ) {
				if( this.isTerminated ) {
					stream.getMultipleNext(close.length());
					return text;
				}
				else {
					stream.setState(state);
					return "";
				}
			}
			
			c = stream.getNext();
			// valid inbetween character
			if( getInbetween().contains(""+c) ) {
				text += c;
			}
			// invalid inbetween character
			else {
				// end of the stream
				if ( Character.MIN_VALUE == c ) {
					if( this.isTerminated ) {
						stream.setState(state);
						return "";
					}
					else {
						return text;
					}
				}
				else {
					stream.setState(state);
					return "";
				}
			}
		} // end while
	}
	
	public boolean getIsTerminated() {
		return isTerminated;
	}
	
	public String getOpen() {
		return open;
	}

	public String getInbetween() {
		return inbetween;
	}
	
	public String getClose() {
		return close;
	}
}
