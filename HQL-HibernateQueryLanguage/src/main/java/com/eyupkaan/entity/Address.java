package com.eyupkaan.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "C_ADDRESS")
public class Address {

    @ManyToMany(mappedBy = "addresses", fetch = FetchType.LAZY)
    Set<Customer> customerList = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADDRESS_ID")
    private Long id;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STREET")
    private String state;

    public Address(String country, String city, String state) {
        this.country = country;
        this.city = city;
        this.state = state;
    }
}
