package com.mmcoe.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.mmcoe.dao.BookDao;
import com.mmcoe.pojo.Book;

public class BookServiceImpl implements BookService {

    private BookDao dao;

    public BookServiceImpl(BookDao dao) {
        this.dao = dao;
    }

    @Override
    public boolean save(Book b) {
        return dao.save(b);
    }

    @Override
    public Book find(int isbn) throws BookNotFoundException {

        Optional<Book> opt = dao.find(isbn);

        return opt.orElseThrow(
            () -> new BookNotFoundException(
                "Book not found with ISBN : " + isbn
            )
        );
    }

    @Override
    public List<Book> list() {
        return dao.list();
    }

    @Override
    public boolean delete(int isbn) throws BookNotFoundException {

        find(isbn);

        return dao.delete(isbn);
    }

    @Override
    public List<Book> findByPrice(double min, double max) {
        return dao.findByPrice(min, max);
    }

    @Override
    public List<Book> listOrderByTitle() {

        List<Book> books = dao.list();

        books.sort(
            Comparator.comparing(Book::getTitle)
        );

        return books;
    }
}