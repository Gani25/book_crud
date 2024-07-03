package com.sprk.book_crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprk.book_crud.entity.Book;
import com.sprk.book_crud.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public boolean saveBook(Book book) {

        bookRepository.save(book);

        return true;

    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
