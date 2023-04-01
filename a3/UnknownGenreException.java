
public class UnknownGenreException extends Exception {
	private static final long serialVersionUID = 1L;
	public UnknownGenreException() {
		System.out.println("Unknown Genre Exception");
	}
	public UnknownGenreException(String s) {
		super(s);
	}
}
