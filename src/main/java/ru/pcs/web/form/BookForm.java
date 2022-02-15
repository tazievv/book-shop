package ru.pcs.web.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
public class BookForm {
    @NotEmpty
    @Length(max = 50)
    private String name;

    @NotEmpty
    @Length(max = 50)
    private String authorName;

    @NotEmpty
    private Integer cost;

}
