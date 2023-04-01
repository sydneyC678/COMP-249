
public class BadIsbn10Exception extends Exception{
	private static final long serialVersionUID = 1L;
	public BadIsbn10Exception() {
		System.out.println("Bad Isbn 10");
	}
	public BadIsbn10Exception(String s) {
		super(s);
	}
}
