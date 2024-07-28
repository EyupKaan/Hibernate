package com.eyupkaan.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "T_CUSTOMER")
public class Customer {

    @OneToMany(mappedBy = "customer",
                fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    private Set<Order> orders = new HashSet<Order>();

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
