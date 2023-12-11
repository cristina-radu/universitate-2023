package com.mvc.demo.model;

import jakarta.persistence.*;

@Table
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String street;
    @Column
    private Integer street_no;
    @Column
    private String building;

   // @OneToOne(mappedBy = "address")
   // private Student student;
}
