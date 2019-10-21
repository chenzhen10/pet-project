package by.itechart.demo.user.service;

import by.itechart.demo.user.dto.CreateUserDto;
import by.itechart.demo.user.model.User;

public interface UserService {

    User register(CreateUserDto newUser);
}
