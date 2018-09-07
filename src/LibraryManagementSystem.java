import java.util.Scanner;

import bookDAO.BookDAO;
import entity.Book;
import view.View;

public class LibraryManagementSystem {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BookDAO<Book> bookDAOImpl = new bookDAOImpl.bookDAOImpl();
		View view = new View(scan, bookDAOImpl);
		while(true) {
			view.menu();
			switch(scan.nextInt()) {
			case 1 :
					view.add();
				break;
			case 2:
				view.showById();
				break;
			case 3:
				view.showAll();
				break;
			case 4:
				view.updateBook();
				break;
			case 5:
				view.DeleteBook();
				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.exit(0);
				break;
			}
		}
	}

}
