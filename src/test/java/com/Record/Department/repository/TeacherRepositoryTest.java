package com.Record.Department.repository;

import com.Record.Department.entity.Course;
import com.Record.Department.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course course1=Course.builder()
                .title("ESA")
                .credit(4)
                .build();

        Course course2=Course.builder()
                .title("DSA")
                .credit(4)
                .build();

        Teacher teacher=Teacher.builder()
                .firstName("Arjun")
                .lastName("Ram")
                //.courses(List.of(course1,course2))
                .build();

        teacherRepository.save(teacher);
    }
}