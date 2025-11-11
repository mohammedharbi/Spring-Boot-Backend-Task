//package org.example.joblisting.Model;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.Pattern;
//import lombok.*;
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @NotEmpty(message = "Username is required")
//    @Column(unique = true, nullable = false)
//    private String username;
//
//    @NotEmpty(message = "Password is required")
//    @Column(nullable = false)
//    private String password;
//
//    @Column(nullable = false)
//    @Pattern(regexp = "(?i)USER|HR", message = "Invalid role type")
//    private String role;
//}
