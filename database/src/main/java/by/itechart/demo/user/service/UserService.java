package by.itechart.demo.user.service;

import by.itechart.demo.user.dto.CreateUserDto;
import by.itechart.demo.user.model.Role;
import by.itechart.demo.user.model.User;

import java.util.List;

public interface UserService {

    User register(CreateUserDto newUser);
    void assignRole(Long id, List<Role> role);
}
