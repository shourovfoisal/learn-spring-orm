package com.shourov.learnspringorm;

import com.shourov.learnspringorm.entity.Address;
import com.shourov.learnspringorm.entity.Laptop;
import com.shourov.learnspringorm.entity.Student;
import com.shourov.learnspringorm.reposiotry.LaptopRepository;
import com.shourov.learnspringorm.reposiotry.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class LearnSpringOrmApplication implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final LaptopRepository laptopRepository;

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

        student1.setLaptop(hp);
        hp.setStudent(student1);

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
                .student(student2)
                .build();

        Address address2 = Address.builder()
                .addressId(2)
                .city("Pabna")
                .street("10 AR Plaza Road")
                .country("Bangladesh")
                .student(student2)
                .build();

        List<Address> addressList = List.of(address1, address2);
        student2.setAddress(addressList);

        studentRepository.save(student2);

    }
}
