package com.shourov.learnspringorm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
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

    @OneToOne(mappedBy = "laptop")
    private Student student;

}
