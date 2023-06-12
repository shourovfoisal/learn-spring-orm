package com.shourov.learnspringorm;

import com.shourov.learnspringorm.entity.Laptop;
import com.shourov.learnspringorm.entity.Student;
import com.shourov.learnspringorm.reposiotry.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class LearnSpringOrmApplication implements CommandLineRunner {

	private final StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringOrmApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		/*
		* Saving the data
		* */
		Student student = Student.builder()
				.studentId(1)
				.studentName("Shourov")
				.about("Learning ORM")
				.laptop(Laptop.builder()
						.laptopId(1)
						.modelNumber("Core 2 Duo")
						.brand("HP")
						.build())
				.build();

		student.getLaptop().setStudent(student);

		Student savedStudent = studentRepository.save(student);

		//		log.info("Created student: {}", savedStudent);

		/*
		 * Printing the value
		 * */
		Student student_1 = studentRepository.findById(1).orElse(null);

		assert student_1 != null;
		log.info("Name is {}", student_1.getStudentName());

		Laptop laptop = student_1.getLaptop();
		log.info("Laptop is {}", laptop.getModelNumber());



	}
}
