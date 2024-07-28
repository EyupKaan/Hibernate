package com.eyupkaan.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "T_CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    @Getter
    private Long id;

    @Column(name = "FIRST_NAME", length = 50, nullable = false)
    @Getter
    @Setter
    private String firstName;

    @Column(name = "LAST_NAME", length = 30, nullable = false)
    @Getter
    @Setter
    private String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Embedded
    private Address address;

    public Customer(){}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
