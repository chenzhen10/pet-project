package by.itechart.demo.user.service;


import by.itechart.demo.common.configuration.UserJpaConfig;
import by.itechart.demo.user.model.Role;
import by.itechart.demo.user.model.User;
import by.itechart.demo.user.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {UserJpaConfig.class},
        loader = AnnotationConfigContextLoader.class)
@Transactional
@ActiveProfiles("test")
public class UniqueUsernameTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveUserThenTryToRetrieveIt() {
        List<Role> roles = new ArrayList<>();
        roles.add(Role.Anonym);
        roles.add(Role.User);
        User user = User.builder().userName("John").password("test").role(roles).build();
        Long id = userRepository.save(user).getId();
        Optional<User> foundUser = userRepository.findById(id);

        String expected = "John";
        String result = foundUser.get().getUserName();
        assertEquals(expected, result);
    }
}
