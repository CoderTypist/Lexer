
public class LineWarning {
	
	private LineWarning() {}
	
	public static void warn(LiveToken lt, String warnMsg) {
		warn(lt, warnMsg, lt.getValue());
	}
	
	public static void warn(LiveToken lt, String warnMsg, String warnValue) {
		System.out.println("\n*** Error line " + lt.getLineNumber() + ".");
		System.out.print("*** " + warnMsg + ": ");
		// String value = Str.visifySpecialWhitespace(lt.getValue());
		String visifiedWarnValue = Str.visifySpecialWhitespace(warnValue);
		
		// use single quotes if the length is 1
		if( 1 == warnValue.length() ) {
			// don't wrap double quote in single quotes
			if( warnValue.equals("\"") ) {
				System.out.println(visifiedWarnValue);
			}
			else {
				System.out.println("'" + visifiedWarnValue + "'");
			}
		}
		
		else {
			System.out.println(visifiedWarnValue);
		}
		System.out.println();
	}
}
