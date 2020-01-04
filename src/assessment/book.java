package assessment;

public class book {

	private int isbn;
	private String title;
	private int pages;
	private int pub_year;
	private String type;
	private author author;
	private publisher publisher;
	
	public book(int isbn, String title, int pages, int pub_year, String type, author author, publisher publisher) {
		this.isbn = isbn;
		this.title = title;
		this.pages = pages;
		this.pub_year = pub_year;
		this.type = type;
		this.author = author;
		this.publisher = publisher;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getPub_year() {
		return pub_year;
	}
	public void setPub_year(int pub_year) {
		this.pub_year = pub_year;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public author getAuthor() {
		return author;
	}
	public void setAuthor(author author) {
		this.author = author;
	}
	public publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(publisher publisher) {
		this.publisher = publisher;
	}
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", pages=" + pages + ", pub_year=" + pub_year + ", type="
				+ type + ", author=" + author + ", publisher=" + publisher + "]";
	}
	
	
}
