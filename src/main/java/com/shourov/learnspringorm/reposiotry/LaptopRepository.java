package com.shourov.learnspringorm.reposiotry;

import com.shourov.learnspringorm.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<Laptop, Integer> {
}
