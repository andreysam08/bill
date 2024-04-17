package ru.example.demo.database.service;

import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import ru.example.demo.entity.Account;
import ru.example.demo.entity.Bank;
import ru.example.demo.entity.User;
import ru.example.demo.repository.AccountRepository;
import ru.example.demo.repository.BankRepository;
import ru.example.demo.repository.UserRepository;
import ru.example.demo.service.UserService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.instancio.Select.all;
import static org.instancio.Select.field;

class UserServiceTest extends IntegrationTestBase {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private BankRepository bankRepository;

    @Test
    void getAllUsers() {
        User user1 = Instancio.of(User.class)
                .ignore(all(all(UUID.class), all(LocalDateTime.class)))
                .create();
        User user2 = Instancio.of(User.class)
                .ignore(all(all(UUID.class), all(LocalDateTime.class)))
                .create();
        userRepository.save(user1);
        userRepository.save(user2);
        assertThat(userService.getAllUsers().size()).isEqualTo(3);
    }

    @Test
    void testRepoMethod() {
        User user = Instancio.create(User.class);
        user.setAccounts(new ArrayList<>());
        User save = userRepository.save(user);

        Bank bank = Instancio.create(Bank.class);
        bank.setAccounts(null);
        bankRepository.save(bank);

        Account account = Instancio.of(Account.class)
                .ignore(field("transactions"))
                .create();
        account.setUser(user);
        user.getAccounts().add(account);
        account.setBank(bank);
        accountRepository.save(account);
        Optional<User> byId = userRepository.findById(save.getId());
        List<Account> account1 = byId.get().getAccounts();

        assertThat(account1).isEmpty();
    }

    @Test
//    @Sql({"/test.sql"})
    void testRepoLevel() {
        List<User> all = userRepository.findAll();
        assertThat(all.size()).isEqualTo(1);
        User user = all.get(0);
        assertThat(user.getAccounts().size()).isEqualTo(1);
    }
}