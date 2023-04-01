import java.io.Serializable;

public class Book implements Serializable {

	private String title;
	private String authors;
	private double price;
	private String isbn;
	private String genre;
	private int year;
	
	
	public Book(String title, String authors, double price, String isbn, String genre, int year) {
		this.title = title;
		this.authors = authors;
		this.price = price;
		this.isbn = isbn;
		this.genre = genre;
		this.year = year;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String toString() {
		return title + ", " + authors + ", " + price + ", " + isbn + ", " + genre + ", " + year;
	}
	public boolean equals(Object x) {
		if(x==null||this.getClass()!=x.getClass()) {
			return false;
		}
		else {
			Book book = (Book)x;
			return this.title.equals(book.title)&& this.authors.equals(book.authors)&&this.price==book.price &&this.isbn.equals(book.isbn)&&this.genre.equals(book.genre)&&this.year==book.year;
		}
	}
}
