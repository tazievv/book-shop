package ru.pcs.web.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
public class CustomerForm {
    @NotEmpty
    @Length(max = 20)
    private String firstName;

    @NotEmpty
    @Length(max = 20)
    private String lastName;

}
