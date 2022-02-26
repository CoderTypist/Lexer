
public class Macro {
		
		private String lowerAlpha;
		private String upperAlpha;
		private String alpha;
		private String digit; 
		private String nonZeroDigit;
		private String whitespace;
		private String arithmetic;
		private String syntaxSugar;
		private String miscValid;
		private String stringValid;
		private String langValid;
		
		public Macro() {
			this.lowerAlpha = "";
			this.upperAlpha = "";
			this.alpha = "";
			this.digit = "";
			this.nonZeroDigit = "";
			this.whitespace = "";
			this.arithmetic = "";
			this.syntaxSugar = "";
			this.miscValid = "";
			this.stringValid = "";
			this.langValid = "";
		}
		
		// not a getter or setter
		public String createLangValid() {
			return Str.toSetStr(
				this.lowerAlpha,
				this.upperAlpha,
				this.alpha,
				this.digit,
				this.nonZeroDigit,
				this.whitespace,
				this.arithmetic,
				this.syntaxSugar,
				this.miscValid,
				this.stringValid
			);
		}
		
		public boolean isInLang(char c) {
			return this.langValid.contains(""+c);
		}
		
		public String getLowerAlpha() {
			return lowerAlpha;
		}

		public void setLowerAlpha(String lowerAlpha) {
			this.lowerAlpha = lowerAlpha;
		}

		public String getUpperAlpha() {
			return upperAlpha;
		}

		public void setUpperAlpha(String upperAlpha) {
			this.upperAlpha = upperAlpha;
		}

		public String getAlpha() {
			return alpha;
		}

		public void setAlpha(String alpha) {
			this.alpha = alpha;
		}

		public String getDigit() {
			return digit;
		}

		public void setDigit(String digit) {
			this.digit = digit;
		}

		public String getNonZeroDigit() {
			return nonZeroDigit;
		}

		public void setNonZeroDigit(String nonZeroDigit) {
			this.nonZeroDigit = nonZeroDigit;
		}

		public String getWhitespace() {
			return whitespace;
		}

		public void setWhitespace(String whitespace) {
			this.whitespace = whitespace;
		}

		public String getArithmetic() {
			return arithmetic;
		}

		public void setArithmetic(String arithmetic) {
			this.arithmetic = arithmetic;
		}

		public String getSyntaxSugar() {
			return syntaxSugar;
		}

		public void setSyntaxSugar(String syntaxSugar) {
			this.syntaxSugar = syntaxSugar;
		}
		
		public String getMiscValid() {
			return miscValid;
		}

		public void setMiscValid(String miscValid) {
			this.miscValid = miscValid;
		}

		public String getStringValid() {
			return stringValid;
		}

		public void setStringValid(String stringValid) {
			this.stringValid = stringValid;
		}

		public String getLangValid() {
			return langValid;
		}

		public void setLangValid(String langValid) {
			this.langValid = langValid;
		}
	}