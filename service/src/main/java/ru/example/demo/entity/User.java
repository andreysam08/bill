package ru.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user", schema = "bill")
public class User extends BaseEntity {
    private String email;
    private String surname;
    private String name;
    private String patronymic;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Account> accounts = new ArrayList<>();
}
