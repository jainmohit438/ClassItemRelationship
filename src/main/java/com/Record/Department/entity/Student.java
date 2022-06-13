package com.Record.Department.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name="student",
        uniqueConstraints = @UniqueConstraint(
                name = "emailid_unique",
                columnNames = "student_email_id"
        )
)
public class Student {
    @Id
    @SequenceGenerator(
            name="student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(name="student_id")
    private Long studentId;
    @Column(name="student_first_name")
    private String firstName;
    @Column(name="student_last_name")
    private String lastName;
    @Column(
            name="student_email_id",
            nullable = false
    )
    private String emailId;

    @Embedded
    private Guardian guardian;

}
