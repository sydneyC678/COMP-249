
public class BadPriceException extends Exception {

	private static final long serialVersionUID = 1L;
	public BadPriceException() {
		System.out.println("Bad Isbn 10");
	}
	public BadPriceException(String s) {
		super(s);
	}
}
