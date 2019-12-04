package com.demojquery.service;

import com.demojquery.model.Book;

public interface BookService {
    Iterable<Book> findAll();
    Book findById(int id);
    Book save(Book book);
    Book delete(int id);
}
