package org.example.joblisting.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Job {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty(message = "title address is required!")
    @Size(max = 25, message = "title cannot exceed 25 characters!")
    @Column(columnDefinition = "varchar(25) not null")
    private String title;

    @NotEmpty(message = "description address is required!")
    @Size(max = 255, message = "description cannot exceed 255 characters!")
    @Column(columnDefinition = "varchar(255) not null")
    private String description;

    @NotEmpty(message = "location address is required!")
    @Size(max = 64, message = "location cannot exceed 64 characters!")
    @Column(columnDefinition = "varchar(64) not null")
    private String location;


    @Column(columnDefinition = "int")
    private Integer salary;


    @NotEmpty(message = "Employment type is required!")
    @Column(columnDefinition = "varchar(9) not null")
    @Pattern(regexp = "(?i)FULL_TIME|PART_TIME|REMOTE|CONTRACT", message = "Invalid Employment type")
    private String employmentType;


    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

}
