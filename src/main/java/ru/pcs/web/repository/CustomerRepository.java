package ru.pcs.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pcs.web.models.Customer;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Optional<Customer> findByEmail(String email);
}
