package service;

import model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User getUserByUsername(String username);
}
