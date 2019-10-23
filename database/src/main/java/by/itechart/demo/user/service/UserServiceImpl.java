package by.itechart.demo.user.service;

import by.itechart.demo.user.dto.CreateUserDto;
import by.itechart.demo.user.model.User;
import by.itechart.demo.user.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Transactional
    @Override
    public User register(CreateUserDto newUser) {
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        User usr = mapper.map(newUser,User.class);
        return repository.save(usr);
    }
}