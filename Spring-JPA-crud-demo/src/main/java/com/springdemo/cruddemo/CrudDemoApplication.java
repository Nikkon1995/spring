package com.springdemo.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dao.StudentDAO;
import entity.Student;

@SpringBootApplication(scanBasePackages = { "entity", "dao" })
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object");
		Student tempStudent = new Student("Nikkon", "Dutta", "thor1995@gmail.com");

		// save the student object
		studentDAO.save(tempStudent);

		// display the id of the saved student
		System.out.println("Student id generated: " + tempStudent.getId());
	}
}
