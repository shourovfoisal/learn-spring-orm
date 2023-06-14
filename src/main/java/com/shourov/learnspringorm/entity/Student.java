package com.shourov.learnspringorm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "jpa_student")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    private int studentId;
    private String studentName;
    private String about;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "student")
    private Laptop laptop;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<Address> address;

}
