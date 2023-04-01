
public class TooFewFieldsException extends Exception {
	private static final long serialVersionUID = 1L;
	public TooFewFieldsException() {
		System.out.println("Too few fields exception");
	}
	public TooFewFieldsException(String s) {
		super(s);
	}
}
