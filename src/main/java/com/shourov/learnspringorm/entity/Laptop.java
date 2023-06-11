package com.shourov.learnspringorm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "jpa_laptop")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Laptop {

    @Id
    private int laptopId;
    private String modelNumber;
    private String brand;

    @OneToOne(mappedBy = "laptop")
    @JoinColumn(name = "student_id")
    private Student student;

}
