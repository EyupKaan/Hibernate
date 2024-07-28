package com.eyupkaan.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "WORKERS")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "F_NAME")
    private String firstName;

    @NotNull
    @Column(name = "L_NAME")
    private String lastName;

    @Size(min = 18)
    @Column(name = "AGE")
    private int age;

    @Email
    @Column(unique = true, name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @FutureOrPresent
    @Temporal(TemporalType.DATE)
    @Column(name = "CREATE_DATE")
    private Date createDate;
    @Embedded
    private Address address;
}
