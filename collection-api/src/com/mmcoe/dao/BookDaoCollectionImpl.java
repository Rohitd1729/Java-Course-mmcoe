package com.mmcoe.dao;

import java.util.List;
import java.util.Vector;

import com.mmcoe.pojo.Book;

public class BookDaoCollectionImpl implements BookDao {
	private List<Book> books;
	
	
	public BookDaoCollectionImpl() {
		books = new Vector<Book>();
	}

	@Override
	public boolean save(Book b) {
		books.add(b);
		return true;
	}

	@Override
	public Book find(int isbn) {
		
		return books.stream().filter(b->b.getIsbn()== isbn).findFirst().orElse(null);
	}

	@Override
	public List<Book> list() {
		
		return books;
	}

	@Override
	public boolean delete(int isbn) {
		return books.removeIf(b->b.getIsbn()==isbn);
	}

	@Override
	public List<Book> findByPrice(double min, double max) {
		return books.stream().filter(b->b.getPrice()>=min && b.getPrice()<=max).toList();
	}

}
