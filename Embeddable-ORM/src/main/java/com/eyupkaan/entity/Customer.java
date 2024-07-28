package com.eyupkaan.entity;

import jakarta.persistence.Embedded;

public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    @Embedded
    private Address address;
}
