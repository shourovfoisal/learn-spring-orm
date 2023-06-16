package com.shourov.learnspringorm.reposiotry;

import com.shourov.learnspringorm.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepository extends JpaRepository<UserData, Integer> {
}
