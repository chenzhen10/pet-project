package by.itechart.demo.user.dao;

import by.itechart.demo.user.model.User;

import java.util.Optional;

public interface UsrDao extends UsrRepository {
    Optional<User> findByUserName(String userName);
}
