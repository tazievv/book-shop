package ru.pcs.web.service;

import ru.pcs.web.form.BookForm;
import ru.pcs.web.form.CustomerForm;
import ru.pcs.web.models.Customer;

import java.util.List;

public interface CustomerService {

    void customerAdd(CustomerForm customer);

    List<Customer> customersGetAll();

    Customer customerGet(Integer id);

    void customerDelete(Integer id);

    void customerUpdate(Integer id, CustomerForm customer);

    void customerAddBook(Integer id, Integer bookId);

}
