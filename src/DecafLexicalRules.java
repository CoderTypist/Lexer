
public class DecafLexicalRules extends LexicalRules {
	
	public DecafLexicalRules() {
		super();
	}
	
	@Override
	public void initKeywords() {
		
		if ( getIsInit() )
			return;
		
		// - XXXX -
		getKeywordsHashMap().put("XXXX", DecafTokenType.T_XXXX);
		getKeywordsHashMap().put("XXXX", DecafTokenType.T_XXXX);
		getKeywordsHashMap().put("XXXX", DecafTokenType.T_XXXX);
		getKeywordsHashMap().put("XXXX", DecafTokenType.T_XXXX);
		
		// - XXXX -
		getKeywordsHashMap().put("XXXX",  DecafTokenType.T_XXXX);
		getKeywordsHashMap().put("XXXX", DecafTokenType.T_XXXX);
		
		// - XXXX -
		getKeywordsHashMap().put("XXXX", DecafTokenType.T_XXXX);
		
		// - XXXX -
		getKeywordsHashMap().put("XXXX", DecafTokenType.T_XXXX);
		
		// - XXXX -
		getKeywordsHashMap().put("XXXX", DecafTokenType.T_XXXX);
		getKeywordsHashMap().put("XXXX", DecafTokenType.T_XXXX);
		getKeywordsHashMap().put("XXXX", DecafTokenType.T_XXXX);
		getKeywordsHashMap().put("XXXX", DecafTokenType.T_XXXX);
		getKeywordsHashMap().put("XXXX", DecafTokenType.T_XXXX);
		getKeywordsHashMap().put("XXXX", DecafTokenType.T_XXXX);
		
		// - XXXX -
		getKeywordsHashMap().put("XXXX", DecafTokenType.T_XXXX);
		getKeywordsHashMap().put("XXXX", DecafTokenType.T_XXXX);
		getKeywordsHashMap().put("XXXX", DecafTokenType.T_XXXX);
	}
	
	@Override
	public void initMacro() {
		
		if ( getIsInit() )
			return;
		
		getMacro().setXXXX("XXXX");
		getMacro().setXXXX("XXXX");
		getMacro().setXXXX( getMacro().getXXXX() + getMacro().getXXXX() );
		getMacro().setXXXX("XXXX"); 
		getMacro().setXXXX("XXXX");
		getMacro().setXXXX("XXXX");
		getMacro().setXXXX("XXXX");
		getMacro().setXXXX("XXXX");
		getMacro().setXXXX("XXXX");
		
		getMacro().setXXXX(Str.toSetStr(
				getMacro().getXXXX(),
				getMacro().getXXXX(),
				getMacro().getXXXX(),
				getMacro().getXXXX(),
				getMacro().getXXXX().replace("\"", ""),
				" '\t"
			));
		
		getMacro().setLangValid(getMacro().createLangValid());
	}
	
	@Override
	public void initTokenDefinitions() {
		
		if ( getIsInit() )
			return;
		
		try {
			
			// - XXXX -
			TokenDefinition defXXXX = new TokenDefinition(DecafTokenType.T_XXXX,
					new RequiredLiteralComponent("XXXX", 2, 2),
					// XXXX
					new OptionalLiteralComponent(getMacro().getXXXX().replaceAll("XXXX", ""))
				);
			
			// - XXXX -
			TokenDefinition defXXXX = new TokenDefinition(DecafTokenType.T_XXXX,
					new RequiredComponent(new TerminatedOpenCloseComponent("XXXX", getMacro().getXXXX(), "XXXX"))
				);
			
			// - XXXX -
			TokenDefinition defXXXX = new TokenDefinition(DecafTokenType.T_XXXX,
					new RequiredComponent(new UnterminatedOpenCloseComponent("XXXX", getMacro().getXXXX(), "XXXX"))
				);
			
			// - XXXX -
			TokenDefinition defXXXX = new TokenDefinition(DecafTokenType.T_XXXX, 
						new RequiredLiteralComponent(getMacro().getXXXX())
					);
			
			// - XXXX -
			TokenDefinition defXXXX = new TokenDefinition(DecafTokenType.T_XXXX,
						// XXXX
						new RequiredLiteralComponent(getMacro().getXXXX(), 1, 1),
						// XXXX
						new OptionalLiteralComponent(getMacro().getXXXX() + getMacro().getXXXX() + "_")
					);
			
			// - XXXX -
			TokenDefinition defXXXX = new TokenDefinition(DecafTokenType.T_XXXX,
					// XXXX
					new RequiredLiteralComponent(getMacro().getXXXX(), 1)
				);
			
			// - XXXX -
			TokenDefinition defXXXX = new TokenDefinition(DecafTokenType.T_XXXX,
					// XXXX
					new OptionalLiteralComponent("XXXX", 1, 1),
					// decimal and leading digits
					new RequiredComponent(
							// XXXX
							new RequiredLiteralComponent(getMacro().getXXXX(), 1),
							// XXXX
							new RequiredLiteralComponent("XXXX", 1, 1)
						),
					// XXXX
					new OptionalLiteralComponent(getMacro().getXXXX()),
					// XXXX
					new OptionalComponent(
							// XXXX
							new RequiredLiteralComponent("XXXX", 1, 1),
							// XXXX
							new RequiredLiteralComponent("XXXX", 1, 1),
							// XXXX
							new RequiredLiteralComponent(getMacro().getXXXX(), 1)
						)
				);
			
			// - XXXX -
			TokenDefinition defXXXX = new TokenDefinition(DecafTokenType.T_XXXX,
					new RequiredLiteralComponent("XXXX", 1, 1),
					new RequiredLiteralComponent("XXXX", 1, 1)
				);
			
			// - XXXX -
			TokenDefinition defXXXX = new TokenDefinition(DecafTokenType.T_XXXX,
					new RequiredLiteralComponent("XXXX", 1, 1),
					new RequiredLiteralComponent("XXXX", 1, 1)
				);
			
			// - XXXX -
			TokenDefinition defXXXX = new TokenDefinition(DecafTokenType.T_XXXX,
					new RequiredLiteralComponent("XXXX", 1, 1)
				);
			
			// - XXXX -
			TokenDefinition defXXXX = new TokenDefinition(DecafTokenType.T_XXXX,
					new RequiredLiteralComponent("XXXX", 2, 2)
				);
			
			// - XXXX -
			TokenDefinition defXXXX = new TokenDefinition(DecafTokenType.T_XXXX,
					new RequiredLiteralComponent("XXXX", 1, 1),
					new RequiredLiteralComponent("XXXX", 1, 1)
				);
			
			// - XXXX -
			TokenDefinition defXXXX = new TokenDefinition(DecafTokenType.T_XXXX,
					new RequiredLiteralComponent("XXXX", 2, 2)
				);
			
			// - XXXX -
			TokenDefinition defXXXX = new TokenDefinition(DecafTokenType.T_XXXX,
					new RequiredLiteralComponent("XXXX", 2, 2)
				);
			
			// - XXXX -
			TokenDefinition defXXXX = new TokenDefinition(DecafTokenType.T_XXXX,
					new RequiredLiteralComponent(getMacro().getXXXX(), 1, 1)
				);
			
			// - XXXX -
			TokenDefinition defXXXX = new TokenDefinition(DecafTokenType.T_XXXX,
					new RequiredLiteralComponent(getMacro().getXXXX(), 1, 1)
				);
			
			// - XXXX -
			TokenDefinition defXXXX = new TokenDefinition(
					DecafTokenType.T_XXXX,
					// opening double quote
					new RequiredLiteralComponent("XXXX", 1, 1),
					new OptionalLiteralComponent(getMacro().getXXXX()),
					new RequiredLiteralComponent("XXXX", 1, 1)
				);
			
			// - XXXX -
			TokenDefinition defXXXX = new TokenDefinition(DecafTokenType.T_XXXX,
					new RequiredLiteralComponent("XXXX", 1, 1),
					new OptionalLiteralComponent(getMacro().getXXXX()),
					new RequiredLiteralComponent("XXXX", 1, 1)
				);
			
			// - XXXX -
			TokenDefinition defXXXX = new TokenDefinition(
					DecafTokenType.T_XXXX,
					new RequiredLiteralComponent("\"", 1, 1)
				);
			
			addTokenDefinition(
					defXXXX,
					defXXXX,
					defXXXX,
					defXXXX,
					defXXXX,
					// defXXXX needs to be added before defXXXX
					defXXXX,
					defXXXX,
					defXXXX,
					defXXXX,
					defXXXX,
					defXXXX,
					defXXXX,
					defXXXX,
					defXXXX,
					defXXXX,
					defXXXX,
					// order for string constant TokenDefinitions is important
					defXXXX,
					defXXXX,
					defXXXX
				);
		}
		catch ( InvalidTokenDefinitionException e ) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void initIdentifierMaxLength() {
		
		if ( getIsInit() )
			return;
		
		setIdentifierMaxLength(31);
	}
	
	@Override
	public TokenType getTextTokenType(String token) {
		
		// Does not account for T_XXXX
		
		if ( getKeywordsHashMap().containsKey(token) ) {
			return getKeywordsHashMap().get(token);
		}
		
		return DecafTokenType.T_XXXx;
	}
	
	@Override
	public void showXXXX(InputStream stream) throws StreamTokenizationException {
		
		LiveToken lt = null;

		// loop over token definitions
		for ( TokenDefinition td : getTokenDefinitions() ) {
			
			Debug.out.println(Str.repeat("    ", 2) + "- DecafLexicalRules: showXXXX(): looking for: " + td.getType().toString());
			lt = td.consume(stream);
			
			// if a token is not found
			if ( null == lt ) {
					
				// check for unrecognized characters
				char c = stream.peekNext();
				if( false == getMacro().isInLang(c) && Character.MIN_VALUE != c ) {
					lt = new LiveToken(DecafTokenType.T_XXXX);
					showXXXX(stream, lt);
					return;
				}
				
				Debug.out.println(Str.repeat("    ", 4) + "- DecafLexicalRules: showXXXX(): not found: " + td.getType().toString());
				continue;
			}
			
			// XXXX
			else if ( DecafTokenType.T_XXXX == lt.getType() ) {
				// modify the token type if it is a keyword
				if( getKeywordsHashMap().containsKey(lt.getValue()) ) {
					lt.setType(getKeywordsHashMap().get(lt.getValue()));
				}
				else if ( lt.getValue().length() > getIdentifierMaxLength() ) {
					lt.setType(DecafTokenType.T_XXXX);
				}
			}
			
			// XXXX
			else if ( DecafTokenType.T_XXXX == lt.getType() ) {
				lt.setDisplayValue("" + Integer.parseInt(lt.getValue()));
			}
			
			// XXXX
			else if ( DecafTokenType.T_XXXX == lt.getType() ) {
				double d = Double.parseDouble(lt.getValue());
				
				// remove trailing ".0"
				if( 0 == (d % 1) ) {
					lt.setDisplayValue("" + (int)d);
				}
				else {
					lt.setDisplayValue("" + d);
				}
			}
			
			// XXXX
			else if ( DecafTokenType.T_XXXX == lt.getType() ) {
				lt.setDisplayValue("\"" + lt.getValue() + "\"");
			}
						
			// XXXX
			else if ( DecafTokenType.T_XXXX == lt.getType()
					|| DecafTokenType.T_XXXX == lt.getType() ) 
			{
				String value = lt.getValue();
				lt.setValue(value.substring(0,value.length()-1));
			}
			
			showXXXX(stream, lt);
			Debug.out.println(Str.repeat("    ", 3) + "- DecafLexicalRules: showXXXX(): found: " + td.getType().toString());
			Debug.out.println(Str.repeat("-", 150));
			return;
		}
		
		
		if( getMacro().getXXXX().contains(""+stream.peekNext()) ) {
			lt = new LiveToken(DecafTokenType.T_XXXX);
			showXXXX(stream, lt);
			return;
		}
		
		// if a token was not found
		lt = new LiveToken(DecafTokenType.T_XXXX);
		showXXXX(stream, lt);
		throw new StreamTokenizationException(stream.getState());
	}
	
	private void showXXXX(InputStream stream, LiveToken lt) {
		// call the appropriate function from lexical rules (e.g., showTypeOnly, showValueOnly, and showTypeAndValue)
		
		switch((DecafTokenType)lt.getType()) {
		
			// - XXXX -
			case T_XXXX: showXXXX(lt); break;
			
			// - XXXX -
			case T_XXXX: showXXXX(lt); break;
			case T_XXXX: showXXXX(lt); break;
			case T_XXXX: showXXXX(lt); break;
			case T_XXXX: showXXXX(lt); break;
			
			// - XXXX -
			case T_XXXX: showXXXX(lt); break;
			case T_XXXX: showXXXX(lt); break;
			case T_XXXX: showXXXX(lt); break;
			case T_XXXX: showXXXX(lt); break;
	
			// - XXXX -
			case T_XXXX: showXXXX(lt); break;
			case T_XXXX: showXXXX(lt); break;
			case T_XXXX: showXXXX(lt); break;
			case T_XXXX: showXXXX(lt); break;
			case T_XXXX: showXXXX(lt); break;
			case T_XXXX: showXXXX(lt); break;
			
			// - XXXX -
			case T_XXXX: showXXXX(lt); break;
			
			// - XXXX -
			case T_XXXX: showXXXX(lt); break;
			
			// - XXXX -
			case T_XXXX: showXXXX(lt); break;
			case T_XXXX: showXXXX(lt); break;
			case T_XXXX: showXXXX(lt); break;
			case T_XXXX: showXXXX(lt); break;
			case T_XXXX: showXXXX(lt); break;
			
			// - XXXX -
			case T_XXXX: showXXXX(lt); break;
		    case T_XXXX: showXXXX(lt); break;
		    
		    // - XXXX -
		    case T_XXXX: showXXXX(lt); break;
		    
		    // - XXXX -
			case T_XXXX: showXXXX(lt); break;
			case T_XXXX: showXXXX(lt); break;
			
			// - XXXX -
			case T_XXXX: showXXXX(lt); break;
			case T_XXXX: showXXXX(lt); break;
			case T_XXXX: showXXXX(lt); break;
			
			// - XXXX -
			case T_XXXX: showXXXX(lt); break;
			case T_XXXX: showXXXX(lt); break;
			
			// - XXXX -
			case T_XXXX:
				LineWarning.warn(lt, "XXXX", "\"" + lt.getValue() + "\"");
				lt.setType(DecafTokenType.T_XXXX);
				showXXXX(lt);
				lt.setValue(lt.getValue().substring(0, getXXXX()));
				stream.skipLine();
				break;
				
			case T_XXXX:
				LineWarning.warn(lt, "XXXX");
				stream.skipLine();
				break;
				
			case T_XXXX:
				LineWarning.warn(lt, "XXXX");
				break;
				
			case T_XXXX:
				LineWarning.warn(lt, "XXXX");
				stream.skipLine();
				break;
				
			case T_XXXX:
				LineWarning.warn(lt, "XXXX");
				showXXXX(lt);
				// no need to skip a line at EOF (Character.MIN_VALUE)
				break;
			
			// - XXXX -
			case T_XXXX: showXXXX(lt); break;
			
		} // end switch
	}
}
