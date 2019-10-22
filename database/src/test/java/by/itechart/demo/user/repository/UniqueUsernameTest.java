package by.itechart.demo.user.repository;


import by.itechart.demo.common.configuration.UserJpaConfig;
import by.itechart.demo.user.model.User;
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
    private UserRepository userRepository;

    @Test
    public void saveUserThenTryToRetrieveIt() {
        User user = new User(null, "John", "Blake", "Admin");
        userRepository.save(user);
        Optional<User> foundUser = userRepository.findById(1L);

        String expected = "John";
        String result = foundUser.get().getUserName();
        assertEquals(expected, result);
    }
}
