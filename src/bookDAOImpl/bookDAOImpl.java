package bookDAOImpl;

import java.util.ArrayList;
import java.util.List;

import bookDAO.BookDAO;
import entity.Book;

public class bookDAOImpl implements BookDAO<Book>{

	private List<Book> books;
	private int id=0;
	public  bookDAOImpl() {
		books= new ArrayList<>();
	}
	
	@Override
	public Book get(int id){
		Book book;
		try {
		if(id>0) {
			id-=1;
		}
		book=books.get(id);
		return book;
		}
		catch(IndexOutOfBoundsException ex) {
			return null;
		}
		
	}

	@Override
	public boolean checkInput(String input) {
		try
        {
            Integer.parseInt(input);
        }
        catch(NumberFormatException ex)
        {
            return false;
        }
        return true;
	}

	@Override
	public List<Book> getAll() {
		return books;
	}

	@Override
	public void save(Book t) {
		autoIncre();
		t.setId(id);
		books.add(t);
	}
	private void autoIncre() {
		id+=1;
	}
	@Override
	public boolean update(int id, Book book) {
			Book getBook=get(id--);
			if(getBook==null) {
				return false;
			}
			getBook.setAuthor(book.getAuthor());
			getBook.setBookName(book.getBookName());
			getBook.setDescription(book.getBookName());
			getBook.setISBN(book.getISBN());
			getBook.setLocation(book.getLocation());
			getBook.setPublisher(book.getPublisher());
			getBook.setQuantity(book.getQuantity());
			return true;

		
	}

	@Override
	public void delete(Book t) {
		books.remove(t);
		
	}
	public boolean checkId(int id) {
		int bookSize=books.size()+1;
		
		if(id>0&&id<bookSize) {
			return true;
		}
		System.out.println("No record found");
		System.out.println("----------------------");
		System.out.println("");
		return false;
		
	}
}
