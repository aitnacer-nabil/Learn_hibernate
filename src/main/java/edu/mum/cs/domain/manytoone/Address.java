package edu.mum.cs.domain.manytoone;

import lombok.Data;

import javax.persistence.*;

//@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String zipCode;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
//    @ManyToOne
//    //@JoinColumn(name = "person_id")
//    @JoinTable(name = "user_address")
//    private User user;

}
