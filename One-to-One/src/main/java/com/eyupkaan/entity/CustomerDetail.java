package com.eyupkaan.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "T_CUSTOMER_DETAIL")
public class CustomerDetail {

    //TODO Refactor here to modern usage (@GenericGenerator deprecated since Hibernate 6.5)

    @OneToOne
    @JoinColumn
    private Customer customer;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "generator", strategy = "foreign" ,
            parameters = @org.hibernate.annotations.Parameter(name = "property", value = "customer"))
    @Column(name = "CUSTOMER_DETAIL_ID")
    private Long id;
    private String address;
    private String phoneNumber;
    private String email;
    @Temporal(TemporalType.DATE)
    @Column(name = "CREATE_DATE")
    private Date createDate;
}
