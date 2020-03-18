package com.example.LoginRegisterAPI.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account {

    @Id
    @GeneratedValue
    private int id;

    @Valid
    @NotBlank(message = "username is required")
    private String username;

    @Valid
    @NotBlank(message = "password is required")
    private String password;
}
