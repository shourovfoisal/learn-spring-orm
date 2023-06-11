package com.shourov.learnspringorm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "jpa_student")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    private int studentId;
    private String studentName;
    private String about;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "laptop_id")
    private Laptop laptop;

}
