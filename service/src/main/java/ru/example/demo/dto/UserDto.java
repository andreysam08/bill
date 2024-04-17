package ru.example.demo.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private UUID id;
    private String email;
    private String surname;
    private String name;
    private String patronymic;
    private List<AccountDto> accounts;
}
