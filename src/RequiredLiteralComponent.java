
public class RequiredLiteralComponent extends SpecifiedLiteralComponent {
	
	public RequiredLiteralComponent(String validChars) {
		super(true, validChars);
	}
	
	public RequiredLiteralComponent(String validChars, int min) {
		super(true, validChars, min);
	}
	
	public RequiredLiteralComponent(String validChars, int min, int max) {
		super(true, validChars, min, max);
	}
}
