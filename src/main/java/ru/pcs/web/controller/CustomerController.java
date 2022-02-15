package ru.pcs.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.pcs.web.form.CustomerForm;
import ru.pcs.web.models.Book;
import ru.pcs.web.models.Customer;
import ru.pcs.web.service.BookService;
import ru.pcs.web.service.CustomerService;

import javax.validation.Valid;
import java.util.List;


@RequiredArgsConstructor
@Controller
public class CustomerController {

    private final CustomerService customerService;
    private final BookService bookService;

    @GetMapping("/customers")
    public String getCustomersPage(Model model) {
        model.addAttribute("customers", customerService.customersGetAll());
        return "customers";
    }

    @GetMapping("/catalog_of_books/{customer-id}")
    public String getCatalog(Model model, @PathVariable("customer-id")Integer id) {
        List<Book> books = bookService.booksGetAll();
        Customer customer = customerService.customerGet(id);
        List<Book> booksOnCustomer = bookService.booksByCustomer(id);
        model.addAttribute("books", books);
        model.addAttribute("customer",customer);
        model.addAttribute("booksOnCustomer",booksOnCustomer);
        return "catalog_of_books";
    }

    @GetMapping("/pay/{customer-id}")
    public String getPayPage(Model model,@PathVariable("customer-id") Integer id) {
        List<Book> books = bookService.booksByCustomer(id);
        model.addAttribute("books",books);
        return "pay";

    }

    @GetMapping("/customers/{customer-id}")
    public String getCustomerPage(Model model,@PathVariable("customer-id") Integer id) {
        model.addAttribute("customer", customerService.customerGet(id));
        return "customer";
    }

    @PostMapping("/customers/add")
    public String addCustomer(@Valid CustomerForm customerForm) {
        customerService.customerAdd(customerForm);
        return "redirect:/customers";
    }

    @PostMapping("/customers/{customer-id}/delete")
    public String deleteCustomer(@PathVariable("customer-id") Integer id) {
        customerService.customerDelete(id);
        return "redirect:/customers";
    }

    @PostMapping("/customers/{customer-id}/update")
    public String updateCustomer(@PathVariable("customer-id") Integer id, @Valid CustomerForm customerForm) {
        customerService.customerUpdate(id,customerForm);
        return "redirect:/customers";
    }

    @PostMapping("/catalog_of_books/addBook/{customer-Id}")
    public String addBookToCustomer(Model model,@PathVariable("customer-id")Integer id, @RequestParam("bookId")Integer bookId) {
        customerService.customerAddBook(id,bookId);
        return "redirect:/catalog_of_books/" + id;
    }


}
