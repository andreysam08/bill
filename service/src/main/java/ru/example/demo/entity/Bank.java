package ru.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "bank", schema = "bill")
public class Bank extends BaseEntity {
    private String name;
    private String ogrn;
    private String inn;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bank")
    private List<Account> accounts;
}
