package com.example.demo.student;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
 @Bean
CommandLineRunner commandLineRunner(StudentRepository studentRepository){
 return args -> {
  Student s1 = new Student(
    "tester1",
    "test1@test.com",
    LocalDate.of(1966,02,20)

  );
  Student s2 = new Student(
    "tester2",
    "test2@test.com",
    LocalDate.of(1956,02, 23)

  );
  studentRepository.saveAll(
    List.of(s1, s2)
  );
 };
}
}
