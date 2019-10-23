package by.itechart.demo.user.service;

import by.itechart.demo.user.dto.CreateUserDto;
import by.itechart.demo.user.model.Role;
import by.itechart.demo.user.model.User;
import by.itechart.demo.user.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;


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
        User usr = mapper.map(newUser, User.class);
        return repository.save(usr);
    }

    @Transactional
    @Override
    public void assignRoles(Long id, Role role) {
        User usr = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found ..."));
        usr.setRole(role);
        repository.save(usr);
    }

}
