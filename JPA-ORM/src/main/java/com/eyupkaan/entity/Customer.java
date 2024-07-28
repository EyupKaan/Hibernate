package com.eyupkaan.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "edudb", name = "T_CUSTOMERS")
public class Customer {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private Long id;

    @Getter
    @Setter
    @Column(name = "FIRST_NAME", length = 55, nullable = false)
    private String firstName;

    @Getter
    @Setter
    @Column(name = "LAST_NAME", length = 30, nullable = false)
    private String lastName;

    public Customer(){};

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
