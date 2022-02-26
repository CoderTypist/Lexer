
public class Debug {
	
	public static final boolean DEBUG = false;
	private Debug() {}
	
	public static class out {
		public static void print(String s) {
			if( Debug.DEBUG ) {
				System.out.print(s);
			}
		}
		public static void printf(String s, Object ... args) {
			if( Debug.DEBUG ) {
				System.out.printf(s, args);
			}
		}
		public static void println(String s) {
			if( Debug.DEBUG ) {
				System.out.println(s);
			}
		}
	}
	
	public static class err {
		public static void print(String s) {
			if( Debug.DEBUG ) {
				System.err.print(s);
			}
		}
		public static void printf(String s, Object ... args) {
			if( Debug.DEBUG ) {
				System.err.printf(s, args);
			}
		}
		public static void println(String s) {
			if( Debug.DEBUG ) {
				System.err.println(s);
			}
		}
	}
}
