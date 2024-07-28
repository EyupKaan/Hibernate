package com.eyupkaan.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String country;
    private String city;
    private String state;
    private String phone;
    private String zip;
}
