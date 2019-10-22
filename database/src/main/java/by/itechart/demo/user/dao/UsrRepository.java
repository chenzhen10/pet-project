package by.itechart.demo.user.dao;

import by.itechart.demo.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsrRepository extends JpaRepository<User,Long> {
}
