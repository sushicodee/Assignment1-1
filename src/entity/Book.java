package entity;

import java.io.Serializable;

public class Book implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String bookName;
	private String ISBN;
	private String description;
	private String publisher;
	private String author;
	private int quantity;
	private String location;
	
	public Book() {
		super();
	}
	public Book( String bookName, String iSBN, String description, String publisher, String author,
			int quantity, String location) {
		this.bookName = bookName;
		ISBN = iSBN;
		this.description = description;
		this.publisher = publisher;
		this.author = author;
		this.quantity = quantity;
		this.location = location;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", ISBN=" + ISBN + ", description=" + description
				+ ", publisher=" + publisher + ", author=" + author + ", quantity=" + quantity + ", location="
				+ location + "]";
	}
	
	

}
