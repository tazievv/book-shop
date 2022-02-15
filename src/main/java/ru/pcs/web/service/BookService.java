package ru.pcs.web.service;

import ru.pcs.web.form.BookForm;
import ru.pcs.web.models.Book;
import ru.pcs.web.models.Customer;

import java.util.List;

public interface BookService {

    void bookAdd(BookForm Book);

    List<Book> booksGetAll();

    Book bookGet(Integer id);

    void bookDelete(Integer id);

    void bookUpdate(Integer id, BookForm Book);

    List<Book> booksByCustomer(Integer id);

}
