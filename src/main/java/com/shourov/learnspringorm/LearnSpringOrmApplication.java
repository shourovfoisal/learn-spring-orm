package com.shourov.learnspringorm;

import com.shourov.learnspringorm.entity.*;
import com.shourov.learnspringorm.reposiotry.LaptopRepository;
import com.shourov.learnspringorm.reposiotry.StudentRepository;
import com.shourov.learnspringorm.reposiotry.UserDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class LearnSpringOrmApplication implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final LaptopRepository laptopRepository;
    private final UserDataRepository userDataRepository;

    public static void main(String[] args) {
        SpringApplication.run(LearnSpringOrmApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        /*
         * One to One
         * */
        Student student1 = Student.builder()
                .studentId(1)
                .studentName("Shourov")
                .about("Learning ORM")
                .build();

        Laptop hp = Laptop.builder()
                .laptopId(1)
                .modelNumber("Core 2 Duo")
                .brand("HP")
                .build();

        // one way insertion from the student side is enough
        student1.setLaptop(hp);
        studentRepository.save(student1);

        // Testing

        Student student = studentRepository.findById(1).orElse(null);
        Laptop laptop = laptopRepository.findById(1).orElse(null);


        assert student != null;
        log.info("Laptop is {}", student.getLaptop().getModelNumber());

        assert laptop != null;
        log.info("Student is {}", laptop.getStudent().getStudentName());


        /*
         * One To Many
         * */
        Student student2 = Student.builder()
                .studentId(2)
                .studentName("Foisal")
                .about("Learning Typescript")
                .build();

        Address address1 = Address.builder()
                .addressId(1)
                .city("Dhaka")
                .street("17 Banani Road")
                .country("Bangladesh")
                .student(student2)  // two-way insert
                .build();

        Address address2 = Address.builder()
                .addressId(2)
                .city("Pabna")
                .street("10 AR Plaza Road")
                .country("Bangladesh")
                .student(student2)  // two-way insert
                .build();

        List<Address> addressList = List.of(address1, address2);

        student2.setAddress(addressList);     // two-way insert
        studentRepository.save(student2);

        /*
        * Many To Many
        * */
        Role admin = Role.builder()
                .id(1)
                .rank(1)
                .name("Admin")
                .description("Admin with all privileges.")
                .build();

        Role moderator = Role.builder()
                .id(2)
                .rank(2)
                .name("Moderator")
                .description("Moderator gets less privileges than the admin.")
                .build();

        Role generalUser = Role.builder()
                .id(3)
                .rank(3)
                .name("General User")
                .description("General users get only read privileges.")
                .build();

        UserData shourov = UserData.builder()
                .id(1)
                .firstName("Shourov")
                .lastName("Foisal")
                .username("shourovfoisal")
                .password("1234")
                .build();

        UserData yeasir = UserData.builder()
                .id(2)
                .firstName("Yeasir")
                .lastName("Arafat")
                .username("yeasir_arafat")
                .password("5678")
                .build();

        // shourov -> admin, generalUser
        // yeasir -> moderator, generalUser
        // 1 user -> 2 roles
        // generalUser -> shourov, yeasir
        // 1 role -> 2 users
        // one way insertion from the user side is enough
        shourov.setRoles(List.of(generalUser, admin));
        yeasir.setRoles(List.of(generalUser, moderator));

        userDataRepository.saveAll(List.of(shourov, yeasir));
    }
}
