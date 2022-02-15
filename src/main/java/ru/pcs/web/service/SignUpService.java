package ru.pcs.web.service;


import org.springframework.stereotype.Component;
import ru.pcs.web.form.SignUpForm;


public interface SignUpService {
    void signUpCustomer(SignUpForm form);
}
