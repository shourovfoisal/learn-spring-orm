package com.shourov.learnspringorm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "jpa_laptop")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Laptop {

    @Id
    private int laptopId;
    private String modelNumber;
    private String brand;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

}
