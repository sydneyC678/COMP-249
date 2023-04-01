
public class BadYearException extends Exception{

	private static final long serialVersionUID = 1L;
	public BadYearException() {
		System.out.println("Bad Isbn 10");
	}
	public BadYearException(String s) {
		super(s);
	}
}
