package my.examples.jdbcboard.service;

import my.examples.jdbcboard.dto.User;

public interface UserService {
    void addUser(User user);
    User getUser(String email);
}