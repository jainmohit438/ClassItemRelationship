package com.Record.Department.repository;

import com.Record.Department.entity.Guardian;
import com.Record.Department.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student=Student.builder()
                .emailId("jainmohit438@gmail.com")
                .firstName("Mohit")
                .lastName("Jain")
                //.guardianName("Anjana")
                //.guardianEmail("jain@gmail.com")
                //.guardianMobile("1236547895")
                .build();
        studentRepository.save(student);
    }
    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian=Guardian.builder()
                .guardianEmail("pradeep@gmail.com")
                .guardianMobile("7896541230")
                .guardianName("Pradeep")
                .build();
        Student student=Student.builder()
                .firstName("Harshit")
                .emailId("singhalHarshit@gmail.com")
                .lastName("Singhal")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }
    @Test
    public void printAllStudents(){
        List<Student> studentList=
                studentRepository.findAll();

        System.out.println("studentList= "+studentList);
    }
    @Test
    public void printStudentByFirstName(){
        List<Student> students=studentRepository.findByFirstName("Mohit");
        System.out.println("students: "+students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students=studentRepository.findByFirstNameContaining("Mo");
        System.out.println("students: "+students);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> students = studentRepository.findByGuardianGuardianName("Anjana");
        System.out.println("students: " + students);
    }

    @Test
    public void printgetStudentByEmailAddress(){
        Student student=
                studentRepository.getStudentByEmailAddress("jainmohit438@gmail.com");
        System.out.println("student : "+student);
    }
    @Test
    public void printgetStudentFirstNameByEmailAddress(){
        String firstName=studentRepository.getStudentFirstNameByEmailAddress("jainmohit438@gmail.com");
        System.out.println(firstName);
    }

    @Test
    public void printgetStudentByEmailAddressNative(){
        Student student=studentRepository.getStudentByEmailAddressNative("singhalHarshit@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printgetStudentByEmailAddressNativeNamedParam(){
        Student student=studentRepository.getStudentByEmailAddressNativeNamedParam("jainmohit438@gmail.com");
        System.out.println(student);
    }
    @Test
    public void updateStudentByEmailId(){
        studentRepository.updateStudentNameByEmailId(
                "Monti","jainmohit438@gmail.com"
        );
    }
}