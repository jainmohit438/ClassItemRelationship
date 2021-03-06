package com.Record.Department.repository;

import com.Record.Department.entity.Course;
import com.Record.Department.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course=
                Course.builder()
                        .title("DSA")
                        .credit(3)
                        .build();

        CourseMaterial courseMaterial=
                CourseMaterial.builder()
                        .url("www.google.com")
                        .course(course)
                        .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial>courseMaterials=
                courseMaterialRepository.findAll();

        System.out.println(courseMaterials);
    }
}