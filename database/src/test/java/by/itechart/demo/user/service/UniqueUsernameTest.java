package by.itechart.demo.user.service;


import by.itechart.demo.common.configuration.UserJpaConfig;
import by.itechart.demo.user.dto.CreateUserDto;
import by.itechart.demo.user.dto.UserDto;
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
    private UserService userService;


    @Test

    public void saveUserThenTryToRetrieveIt() {
        String userName = "John";
        CreateUserDto user = userWithFirsNameAndPassword(userName, "test");

        Long id = userService.register(user).getId();
        UserDto foundUser = userService.getUser(id);


        assertEquals(userName, foundUser.getUserName());
    }

    public void testUserRegistration() {
        String username = "John";
        CreateUserDto user = userWithFirsNameAndPassword(username, "test");

        Long id = userService.register(user).getId();
        UserDto foundUser = userService.getUser(id);

        assertEquals(username, foundUser.getUserName());

    }



    private CreateUserDto userWithFirsNameAndPassword(String name, String password) {
        CreateUserDto mockUser = new CreateUserDto();
        mockUser.setUserName(name);
        mockUser.setPassword(password);
        return mockUser;
    }

}
