
public class BuildableComponent extends Buildable<Component> implements Component {

	private boolean isRequired;
	
	public BuildableComponent(boolean isRequired) {
		super();
		this.isRequired = isRequired;
	}
	
	public BuildableComponent(boolean isRequired, Component ... components) {
		super();
		this.isRequired = isRequired;
		
		for ( Component c : components ) {
			try {
				addComponent(c);
			}
			catch ( InvalidComponentConfigurationException e ) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void addComponent(Component c) throws InvalidComponentConfigurationException {
		// LiteralComponents must be the only component for a BuildableComponent
		
		// When defining a BuildableComponent, LiteralComponents can be added as Components so long as they are the only Component
		if( c instanceof LiteralComponent && getComponents().size() > 0 ) {
			throw new InvalidComponentConfigurationException("BuildableComponent: addComponent(): failed to add LiteralComponent: LiteralComponents must be the only Component within a BuildableComponent");
		}
		else if( c instanceof OpenCloseComponent && getComponents().size() > 0 ) {
			throw new InvalidComponentConfigurationException("BuildableComponent: addComponent(): failed to add OpenCloseComponent: OpenCloseComponents must be the only Component within a BuildableComponent");
		}
		
		super.addComponent(c);
	}
	
	@Override
	public String consume(InputStream stream) {
		
		InputStreamState state = stream.getState();
		
		// addComponent guarantees that if a Component is a LiteralComponent, then it is the only Component
		// This does not account for RequiredLiteralComponents and OptionalLiteralComponents
		if ( getComponents().get(0) instanceof LiteralComponent || getComponents().get(0) instanceof OpenCloseComponent ) {
			return getComponents().get(0).consume(stream);
		}
		
		// If there is more than one Component, we can be guaranteed that they are BuildableComponents
		// This means that we can up-cast Components to BuildableComponents
		String text = "";
		for ( int i = 0 ; i < getComponents().size(); i++ ) {
			BuildableComponent bc = (BuildableComponent)getComponents().get(i);
			
			String subText = bc.consume(stream);
			// RequiredComponent || RequiredLiteralComponent
			if ( bc.getIsRequired() ) {
				// component finds a match
				if ( "" != subText ) {
					text += subText;
				}
				// component failed to find a match
				else {
					// reset the stream state
					stream.setState(state);
					return "";
				}
			}
			// OptionalComponent || OptionalLiteralComponent
			else {
				// component finds a match
				if ( "" != subText ) {
					text += subText;
				}
				// the component is optional, so it doesn't matter if a match is not found
			}
		}
		return text;
	}
	
	public boolean getIsRequired() {
		return this.isRequired;
	}
}
