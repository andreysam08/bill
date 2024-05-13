package com.example.authorizationserver.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user", schema = "auth_server")
public class User extends BaseEntity {
    private String username;
    private String surname;
    private String name;
    private String patronymic;
    private String password;
    private String role;
}
