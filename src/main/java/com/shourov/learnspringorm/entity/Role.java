package com.shourov.learnspringorm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    private int id;
    private String name;
    private int rank;
    private String description;

    @ManyToMany(mappedBy = "roles", cascade = CascadeType.ALL)
    private List<UserData> users;
}
