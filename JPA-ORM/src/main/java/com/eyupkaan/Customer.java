package com.eyupkaan;

import lombok.Getter;
import lombok.Setter;

public class Customer {
    @Getter
    private Long id;

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    public Customer(){};

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
