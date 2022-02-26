
public class RequiredComponent extends BuildableComponent {
	
	public RequiredComponent() {
		super(true);
	}
	
	public RequiredComponent(Component ... components) {
		super(true, components);
	}
}
