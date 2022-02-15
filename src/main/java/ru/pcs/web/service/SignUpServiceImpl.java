package ru.pcs.web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.pcs.web.form.SignUpForm;
import ru.pcs.web.models.Customer;
import ru.pcs.web.repository.CustomerRepository;

@RequiredArgsConstructor
@Component
public class SignUpServiceImpl implements SignUpService {

    private final PasswordEncoder passwordEncoder;
    private final CustomerRepository customerRepository;

    @Override
    public void signUpCustomer(SignUpForm form) {
        Customer customer = Customer.builder()
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .email(form.getEmail())
                .role(Customer.Role.USER)
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .build();
        customerRepository.save(customer);
    }
}
