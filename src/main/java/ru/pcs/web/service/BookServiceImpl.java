package ru.pcs.web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.pcs.web.form.BookForm;
import ru.pcs.web.form.CustomerForm;
import ru.pcs.web.models.Book;
import ru.pcs.web.models.Customer;
import ru.pcs.web.repository.BookRepository;

import java.util.List;

@RequiredArgsConstructor
@Component
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    @Override
    public void bookAdd(BookForm book) {
        Book bookforCreate = Book.builder()
                .name(book.getName())
                .authorName(book.getAuthorName())
                .cost(book.getCost())
                .build();
        repository.save(bookforCreate);
    }

    @Override
    public List<Book> booksGetAll() {
        return repository.findAll();
    }

    @Override
    public Book bookGet(Integer id) {
        return repository.getById(id);
    }

    @Override
    public void bookDelete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void bookUpdate(Integer id, BookForm book) {
        Book bookForUpdate = repository.getById(id);
        bookForUpdate.setName(book.getName());
        bookForUpdate.setAuthorName(book.getAuthorName());
        bookForUpdate.setCost(book.getCost());
    }

    @Override
    public List<Book> booksByCustomer(Integer id) {
        return repository.findAllByCustomer_Id(id);
    }
}
