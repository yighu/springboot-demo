package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
 private final StudentRepository studentRepository;
 @Autowired
 public StudentService(StudentRepository studentRepository){
  this.studentRepository = studentRepository;
 }
 public List<Student> getStudents(){
  return studentRepository.findAll();
 }

 public void addNewStudent(Student student) {
  Optional<Student> studentopt = studentRepository.findStudentByEmail(student.getEmail());
  if (studentopt.isPresent()) {
   throw new IllegalStateException("email taken");
  }
  studentRepository.save(student);
 }

 public void deleteStudent(Long id) {
  if(!studentRepository.existsById(id)){
   throw new IllegalStateException("Student with id" + id +" not exist");
  }
  studentRepository.deleteById(id);
 }

 @Transactional
 public void updateStudent(Long studentId, String name, String email){
  Student student = studentRepository.findById(studentId).orElseThrow(() ->
    new IllegalStateException("Student with id "+ studentId +" does not exist"));
 if (name != null && name.length()>0 && !Objects.equals(student.getName(),name)){
  student.setName(name);
 }
  if (email != null && email.length()>0 && !Objects.equals(student.getEmail(),email)){
   Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
   if (studentOptional.isPresent()){
    throw new IllegalStateException("Email taken");
   }
   student.setEmail(email);
  }

 }
}
