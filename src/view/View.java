package view;

import java.util.List;
import java.util.Scanner;
import bookDAO.BookDAO;
import entity.Book;

public class View {
	Scanner scan;
	BookDAO<Book> bookDAO;

	public View(Scanner scan, BookDAO<Book> bookDAO) {
		this.scan = scan;
		this.bookDAO = bookDAO;
	}

	public void menu() {
		System.out.println("Welcome to Library Management System");
		System.out.println("-------------------------------------");
		System.out.println("");
		System.out.println("1. Add Book");
		System.out.println("2. Get Book by id");
		System.out.println("3. Show all books");
		System.out.println("4. Edit Book");
		System.out.println("5. Delete Book");
		System.out.println("6. Exit");
	}

	public void add() {
		String qtyinput;
		while (true) {
			Book book = new Book();
			System.out.println("Enter book name.");
			book.setBookName(scan.next());
			System.out.println("Enter book ISBN.");
			book.setISBN(scan.next());
			System.out.println("Enter book description.");
			book.setDescription(scan.next());
			System.out.println("Enter book author.");
			book.setAuthor(scan.next());
			System.out.println("Enter book publisher.");
			book.setPublisher(scan.next());
			System.out.println("Enter book location.");
			book.setLocation(scan.next());
			System.out.println("Enter book quantity.");
			qtyinput=scan.next();
		
				if(bookDAO.checkInput(qtyinput)) {
					book.setQuantity(Integer.parseInt(qtyinput));
				}
				else {
					System.out.println("");
					System.out.println("Please enter number only in the quantity");
					System.out.println("-----------------------------------------");
					System.out.println("");
					break;
				}
			
			
			bookDAO.save(book);
			System.out.println("Do you want to add more [Y/N]");
			if (scan.next().equalsIgnoreCase("n")) {
				break;
			}
		}

	}

	public void showAll() {
		List<Book> listOfBook = bookDAO.getAll();
		if (!listOfBook.isEmpty()) {
			System.out.println("List of book:");
			System.out.println("");
			listOfBook.forEach(bo -> {
				System.out.println(bo.toString());
			});
			System.out.println("-------------------------------------");
			System.out.println("");
		} else {
			System.out.println("No record found");
			System.out.println("-------------------------------------");
			System.out.println("");
		}

	}

	public void showById() {
		System.out.println("Enter book id");
		Book book;
		int inputValue = scan.nextInt();
		if (bookDAO.checkId(inputValue)) {
			book = bookDAO.get(inputValue);
			if (book != null) {
				System.out.println("");
				System.out.println("Result:");
				System.out.println(book.toString());
				System.out.println("----------------------");
			}
		}

	}

	public void DeleteBook() {
		System.out.println("Enter book id");
		Book book;
		int inputValue = scan.nextInt();
		if (bookDAO.checkId(inputValue)) {
			book = bookDAO.get(inputValue);
			if (book != null) {
				bookDAO.delete(book);
				System.out.println("");
				System.out.println("Deleted successfully!!!!!!!!!!");
				System.out.println("-------------------------------------");
				System.out.println("");
			} 
		}
	}

	public void updateBook() {
		String qtyinput;
		System.out.println("Enter book id");
		Book book = new Book();
		int inputValue = scan.nextInt();
		if (bookDAO.checkId(inputValue)) {
			System.out.println("Enter book name.");
			book.setBookName(scan.next());
			System.out.println("Enter book ISBN.");
			book.setISBN(scan.next());
			System.out.println("Enter book description.");
			book.setDescription(scan.next());
			System.out.println("Enter book author.");
			book.setAuthor(scan.next());
			System.out.println("Enter book publisher.");
			book.setPublisher(scan.next());
			System.out.println("Enter book location.");
			book.setLocation(scan.next());
			System.out.println("Enter book quantity.");
			qtyinput=scan.next();
			
			if(bookDAO.checkInput(qtyinput)) {
				book.setQuantity(Integer.parseInt(qtyinput));
			}
			else {
				System.out.println("");
				System.out.println("Please enter number only in the quantity");
				System.out.println("-----------------------------------------");
				System.out.println("");
			}
			if (bookDAO.update(inputValue, book)) {
				System.out.println("Updated successfully!!!");
				System.out.println("-------------------------------------");
				System.out.println("");
			}
		}

	}
}
