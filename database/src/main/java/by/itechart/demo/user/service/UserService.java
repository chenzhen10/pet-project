package by.itechart.demo.user.service;

import by.itechart.demo.user.dto.CreateUserDto;
import by.itechart.demo.user.model.Role;
import by.itechart.demo.user.model.User;

public interface UserService {

    User register(CreateUserDto newUser);
    void assignRoles(Long id, Role role);
}
