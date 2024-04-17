package ru.example.demo.dto;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankDto {
    private String name;
    private String ogrn;
    private String inn;
}
