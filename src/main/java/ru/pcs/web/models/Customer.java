package ru.pcs.web.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "customer")
public class Customer {

    public enum Role {
        ADMIN, USER
    }

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;

    private String hashPassword;

    @OneToMany(mappedBy = "customer", cascade =  {CascadeType.ALL})
    private List<Book> books;

//    @ManyToOne(cascade = {CascadeType.ALL}, mappedBy = mappedBy = "customer")
//    private List<Book> books;

    //    public Map<Book,Integer> brew(Book booking){
//        Map<Book, Integer> books = new HashMap<>();
//
//        for(Map.Entry<Book,Integer> pair : books.entrySet()) {
//            if(books.equals(booking)){
//                int count = pair.getValue() + 1;
//                books.put(booking,count);
//            } else{
//                books.put(booking,1);
//            }
//        }
//        return books;
    //(mappedBy = "customer", cascade = {CascadeType.ALL})

}
