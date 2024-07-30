package com.eyupkaan.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "T_CUSTOMER")
public class Customer {

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "CUSTOMERS_ADDRESS",schema = "public",
        joinColumns = {
                @JoinColumn(name = "CUSTOMER_ID", nullable = false)
        },
        inverseJoinColumns = {
                @JoinColumn(name = "ADDRESS_ID", nullable = false)
        }
    )
    Set<Address> addresses = new HashSet<>();

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
    public Customer(){}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
