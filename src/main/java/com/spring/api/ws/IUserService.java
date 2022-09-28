package com.spring.api.ws;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    void createUser(User user);
    List<User> getAllUsers();
    Optional<User> getOneUser(Integer Id);
}