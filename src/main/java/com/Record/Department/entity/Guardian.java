package com.Record.Department.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(
                name = "guardianName",
                column = @Column(name = "guardian_name")
        ),
        @AttributeOverride(
                name = "guardianEmail",
                column = @Column(name = "guardian_email")
        ),

        @AttributeOverride(
                name = "guardianMobile",
                column = @Column(name = "guardian_mobile")
        )
})
public class Guardian {

    private String guardianName;
    private String guardianEmail;
    private String guardianMobile;
}
