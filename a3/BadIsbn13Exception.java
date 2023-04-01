
public class BadIsbn13Exception extends Exception{

	private static final long serialVersionUID = 1L;
	public BadIsbn13Exception() {
		System.out.println("Bad Isbn 10");
	}
	public BadIsbn13Exception(String s) {
		super(s);
	}
}
