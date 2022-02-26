import java.util.ArrayList;

public class TokenDefinition extends Buildable<BuildableComponent> implements Consumable<LiveToken> {
	
	private TokenType type;
	
	public TokenDefinition(TokenType type, BuildableComponent ... buildableComponents) throws InvalidTokenDefinitionException {
		super();
		this.type = type;
		
		// add components
		for( BuildableComponent bc : buildableComponents ) {
			try {
				addComponent(bc);
			}
			catch ( InvalidComponentConfigurationException e ) {
				e.printStackTrace();
			}
		}
		
		// verify that there is at least one required component
		boolean hasRequired = false;
		for(BuildableComponent bc: getComponents()) {
			if ( true == bc.getIsRequired() ) {
				hasRequired=true;
			}
		}
		if( false == hasRequired ) {
			throw new InvalidTokenDefinitionException("TokenDefinition: verify(): Must have at least one required BuildableComponent.");
		}
	}
	
	// returns a BuildableComponent that can be used for creating other TokenDefinitions
	public BuildableComponent asBuildableComponent(boolean isRequired) {
		ArrayList<BuildableComponent> bcList = getComponents();
		return new BuildableComponent(isRequired, bcList.toArray(new BuildableComponent[bcList.size()]));
	}
	
	@Override
	public void addComponent(BuildableComponent bc) throws InvalidComponentConfigurationException {
		
		// Cannot add LiteralComponent to TokenDefinition
		// Can only add RequiredComponents and OptionalComponents
		if ( !(bc instanceof BuildableComponent) ) {
			throw new InvalidComponentConfigurationException("TokenDefinition: addComponent(): cannot add LiteralComponent: place LiteralComponent within a BuildableComponent");
		}
		
		super.addComponent(bc);
	}
	
	@Override
	public LiveToken consume(InputStream stream) {
           
		Debug.out.println(Str.repeat("    ", 3) + "- TokenDefinition: consume(): " + this.type.toString());
		InputStreamState state = stream.getState();
		
		// addComponent guarantees that all Components are BuildableComponents
		// This means that we can up-cast Components to BuildableComponents
		String text = "";
		for( int i = 0 ; i < getComponents().size() ; i++ ) {
			
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
					return null;
				}
			}
			// OptionalComponent || OptionalLiteralComponent
			else {
				// component finds a match
				if ( "" != subText ) {
					text += subText;
				}
				// The component is optional, so it doesn't matter if a match is not found
				// The underlying BuildableComponents and LiteralComponents will reset the state
			}
		}
		return new LiveToken(this.type, text, state);
	}
	
	public TokenType getType() {
		return this.type;
	}
}
