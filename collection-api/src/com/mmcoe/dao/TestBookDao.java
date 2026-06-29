package com.mmcoe.dao;

import java.util.List;

import com.mmcoe.dao.BookDao;
import com.mmcoe.dao.BookDaoCollectionImpl;
import com.mmcoe.pojo.Book;

public class TestBookDao {

	public static void main(String[] args) {

		BookDao dao = new BookDaoCollectionImpl();

		// Add Books
		dao.save(new Book(101, "Java", "Herbert", 650));
		dao.save(new Book(102, "Python", "Guido", 500));
		dao.save(new Book(103, "C++", "Bjarne", 700));
		dao.save(new Book(104, "DBMS", "Korth", 400));
		dao.save(new Book(105, "OS", "Galvin", 550));

		System.out.println("===== ALL BOOKS =====");

		for(Book b : dao.list()) {
			System.out.println(b);
		}

		System.out.println("\n===== FIND BOOK =====");

		Book book = dao.find(103);

		if(book != null)
			System.out.println(book);
		else
			System.out.println("Book Not Found");

		System.out.println("\n===== BOOKS BETWEEN 500 AND 650 =====");

		List<Book> books = dao.findByPrice(500, 650);

		for(Book b : books) {
			System.out.println(b);
		}

		System.out.println("\n===== DELETE BOOK =====");

		if(dao.delete(102))
			System.out.println("Book Deleted");
		else
			System.out.println("Book Not Found");

		System.out.println("\n===== BOOKS AFTER DELETE =====");

		for(Book b : dao.list()) {
			System.out.println(b);
		}
	}
}