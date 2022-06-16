package com.Record.Department.repository;

import com.Record.Department.entity.Course;
import com.Record.Department.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses=
                courseRepository.findAll();
        System.out.println(courses);
    }
    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher=Teacher.builder()
                .firstName("Ajay")
                .lastName("jain")
                .build();

        Course course=Course
                .builder()
                .title("Python")
                .credit(3)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){

        Pageable firstPageWithThreeRecords=
                PageRequest.of(1,3);

        List<Course>courses=
                courseRepository.findAll(firstPageWithThreeRecords).getContent();
        System.out.println(courses);

        long totalPages=courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();
        System.out.println(totalPages);

        long totalElements=courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
        System.out.println(totalPages);

    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle=
                PageRequest.of(0,2,Sort.by("title"));
        Pageable sortByCreditDesc=
                PageRequest.of(0,2,Sort.by("credit").descending());

        Pageable sortByTitleAndCreditDesc=
                PageRequest.of(0,2,Sort.by("title").descending()
                        .and(Sort.by("credit"))
                );

        List<Course>courses=
                courseRepository.findAll(sortByTitle).getContent();

        System.out.println(courses);
    }
    @Test
    public void printfindByTitleContaining(){
        Pageable firstPageTenRecords=
                PageRequest.of(0,10);

        List<Course>courses=
                courseRepository.findByTitleContaining("D",firstPageTenRecords).getContent();

        System.out.println(courses);
    }
}