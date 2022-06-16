package com.Record.Department.repository;

import com.Record.Department.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String name);

    List<Student> findByGuardianGuardianName(String guardianName);
    //Custom Method using query
    //JPQL querry based on classes not tables
    @Query("select s from Student s where s.emailId= ?1")
    Student getStudentByEmailAddress(String emailId);

    @Query("select s.firstName from Student s where s.emailId= ?1")
    String getStudentFirstNameByEmailAddress(String emailId);

    //Native Query use SQL tables
    @Query(
            value = "SELECT * FROM student s where s.email_id=?",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);

    //Native Param query
    @Query(
            value = "SELECT * FROM student s where s.email_id=:emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);
    @Modifying
    @Transactional
    @Query(
            value = "update student set student_first_name=?1 where email_id=?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName,String emailId);
}
