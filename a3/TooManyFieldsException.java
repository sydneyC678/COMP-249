
public class TooManyFieldsException extends Exception{

	private static final long serialVersionUID = 1L;
	public TooManyFieldsException() {
		System.out.println("Too many fields exception");
	}
	public TooManyFieldsException(String s) {
		super(s);
	}
}
