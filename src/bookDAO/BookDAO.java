package bookDAO;

import java.util.List;

import entity.Book;

public interface BookDAO<T> {
	Book get(int id);
	List<T> getAll();
	void save(T t);
	boolean update(int id, Book book);
	void delete(T t);
	boolean checkId(int id);
	boolean checkInput(String input);
}
