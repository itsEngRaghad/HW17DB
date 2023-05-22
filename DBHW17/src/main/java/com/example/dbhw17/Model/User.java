package com.example.dbhw17.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    //User class: ID , name , username , password, email ,role, age
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name can't be empty")
    @Size(min = 4, message = "name has to be at least 4 character")
    @Column(columnDefinition = " varchar(20) not null") //constraint
    private String name;

    @NotEmpty(message = "username can't be empty")
    @Size(min = 4, message = "username has to be at least 4 character")
    @Column(columnDefinition = " varchar(20) unique  not null") //constraint
    private String username;

    @NotEmpty(message = "password can't be empty")
    @Column(columnDefinition = " varchar(20) not null") //constraint
    private String password;

    @NotEmpty(message = "role can't be empty")
    @Column(columnDefinition = " varchar(20) not null check(role='user' or role='admin')")
    private String role;

    @Email(message = "write valid email")
    @NotEmpty(message = "email can't be empty")
    @Column(columnDefinition = " varchar(20) unique  not null") //constraint
    private String email;

    @NotNull(message = "id can't be null")
    @Column(columnDefinition = " varchar(20) not null") //constraint
    private Integer age;
}
