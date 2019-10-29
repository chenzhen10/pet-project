package by.itechart.demo.user.service;


import by.itechart.demo.configuration.UserJpaConfig;
import by.itechart.demo.user.dto.CreateUserDto;
import by.itechart.demo.user.dto.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {UserJpaConfig.class},
        loader = AnnotationConfigContextLoader.class)
@Transactional
@ActiveProfiles("test")
public class UserServiceImplTest {


    @Autowired
    private UserService userService;



    @Test
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
