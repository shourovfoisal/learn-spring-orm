package com.shourov.learnspringorm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "jpa_address")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    private int addressId;
    private String street;
    private String city;
    private String country;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
