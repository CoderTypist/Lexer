# Lexer

## Description
A library for writing a lexer that I made for my compilers class. We are going to write a compiler for the Decaf language. *DecafTokenType.java* and *DecafLexicalRules.java* have been heavily redacted, but they still serve as a good example for how to use the library.

## Usage
You need to create two files:
- <***YourLang***>*TokenType.java*
  - Enum containing all token types
- <***YourLang***>*LexicalRules.java*
  - Define all TokenDefinitions

Once you write those two files, you create a lexer as follows:
```
Lexer lex = new Lexer(new <YourLang>LexicalRules());
lex.tokenize(new InputStream(<inputFilePath>));
```

## UML Class Diagram
![Lexer UML Class Diagram](https://github.com/CoderTypist/Lexer/blob/main/Lexer_UML.png)

## Example
Here is how you would define a token for basic text faces.
```
/*
 * VALID FACES:
 * ------------
 * :(    X(    ;( 
 * :)    X)    ;)
 * :/    X/    -/
 * :D    XD    ;D
 * :3    X3    ;3
 * :-(    X-(    ;-(
 * :-)    X-)    ;-)
 * :-/    X-/    ;-/
 * :-D    X-D    ;-D
 * :-3    X-3    ;-3
 */
try {
    TokenDefinition defFace = new TokenDefinition(<YourLang>TokenType.T_FACE,
            // eyes
            // minimum of 1 of the listed characters
            // maximum of 1 of the listed characters
            new RequiredLiteralComponent(":X;", 1, 1),
            // nose
            new OptionalLiteralComponent("-", 1, 1),
            // mouth
            new RequiredLiteralComponent("()/D3", 1, 1)
        );
    addTokenDefinition(defFace);
}
catch ( InvalidTokenDefinitionException e ) {
    e.printStackTrace();
}
```
