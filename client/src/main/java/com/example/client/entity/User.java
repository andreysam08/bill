package com.example.client.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(schema = "client", name = "user")
public class User extends BaseEntity {
    private String username;
    private String password;
}
