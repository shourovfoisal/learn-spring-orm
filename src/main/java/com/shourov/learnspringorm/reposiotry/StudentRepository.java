package com.shourov.learnspringorm.reposiotry;

import com.shourov.learnspringorm.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
