package ru.pcs.web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.pcs.web.form.CustomerForm;
import ru.pcs.web.models.Book;
import ru.pcs.web.models.Customer;
import ru.pcs.web.repository.BookRepository;
import ru.pcs.web.repository.CustomerRepository;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final BookRepository bookRepository;

    @Override
    public void customerAdd(CustomerForm customer) {
        Customer customerforCreate = Customer.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .build();
        repository.save(customerforCreate);
    }

    @Override
    public List<Customer> customersGetAll() {
        return repository.findAll();
    }

    @Override
    public Customer customerGet(Integer id) {
        return repository.getById(id);
    }

    @Override
    public void customerDelete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void customerUpdate(Integer id, CustomerForm customer) {
        Customer customerforUpdate = repository.getById(id);
        customerforUpdate.setFirstName(customer.getFirstName());
        customerforUpdate.setLastName(customer.getLastName());
        repository.save(customerforUpdate);
    }

    @Override
    public void customerAddBook(Integer id, Integer bookId) {
        Customer customer = repository.getById(id);
        Book book = bookRepository.getById(bookId);
        customer.getBooks().add(book);
        repository.save(customer);
    }
}
