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

    @OneToMany(
            mappedBy = "customer",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
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

    public void addOrder(Order order){
        orders.add(order);
        order.setCustomer(this);
    }

    public void removeOrder(Order order){
        orders.add(order);
        order.setCustomer(null);
    }


    public Customer(){}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
