@SuppressWarnings("serial")
public class StreamTokenizationException extends Exception {
	public StreamTokenizationException(InputStreamState state) {
		super("Error tokenizing stream. State before error:\n" + state.toString() + "\n");
	}
}
