package ru.example.demo.test;

import org.springframework.stereotype.Component;

@Component
public class Test {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
