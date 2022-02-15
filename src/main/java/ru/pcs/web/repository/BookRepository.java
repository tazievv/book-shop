package ru.pcs.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pcs.web.models.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer > {
    List<Book> findAllByCustomer_Id(Integer id);
}