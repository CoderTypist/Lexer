
public class OptionalLiteralComponent extends SpecifiedLiteralComponent {
	
	public OptionalLiteralComponent(String validChars) {
		super(false, validChars);
	}
	
	public OptionalLiteralComponent(String validChars, int min) {
		super(false, validChars, min);
	}
	
	public OptionalLiteralComponent(String validChars, int min, int max) {
		super(false, validChars, min, max);
	}
}

