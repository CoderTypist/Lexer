
public class SpecifiedLiteralComponent extends BuildableComponent {
	
	public SpecifiedLiteralComponent(boolean isRequired, String validChars) {
		super(isRequired);
		try {
			addLiteralComponent(new LiteralComponent(validChars));
		}
		catch ( InvalidComponentConfigurationException e ) {
			e.printStackTrace();
		}
	}
	
	public SpecifiedLiteralComponent(boolean isRequired, String validChars, int min) {
		super(isRequired);
		try {
			addLiteralComponent(new LiteralComponent(validChars, min));
		}
		catch ( InvalidComponentConfigurationException e ) {
			e.printStackTrace();
		}
	}
	
	public SpecifiedLiteralComponent(boolean isRequired, String validChars, int min, int max) {
		super(isRequired);
		try {
			addLiteralComponent(new LiteralComponent(validChars, min, max));
		}
		catch ( InvalidComponentConfigurationException e ) {
			e.printStackTrace();
		}
	}
	
	private void addLiteralComponent(LiteralComponent lc) {
		try {
			addComponent(lc);
		}
		catch ( InvalidComponentConfigurationException e ) {
			e.printStackTrace();
		}
	}
}
