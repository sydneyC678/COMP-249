
public class MissingFieldException extends Exception {
	private static final long serialVersionUID = 1L;
	public MissingFieldException() {
		System.out.println("Missing field exception");
	}
	public MissingFieldException(String s) {
		super(s);
	}
}
