package com.eyupkaan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "ORDERS")
public class Order {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer")
    private Customer customer;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID", nullable = false)
    private Long orderId;

    @Column(name = "PRODUCT")
    private String product;
    private String code;

    @Column(name = "AMOUNT", precision = 10)
    private float amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ORDER_DATE")
    private Date createDate;


}
