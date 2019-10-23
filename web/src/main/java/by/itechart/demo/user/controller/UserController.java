package by.itechart.demo.user.controller;


import by.itechart.demo.user.dto.CreateUserDto;
import by.itechart.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/users")
public class UserController {


    @Autowired
    private UserService userService;


    @PostMapping("registration")
    public ResponseEntity<?> registerUser(@Valid @RequestBody CreateUserDto newUser){
        Long id = userService.register(newUser).getId();
        URI uri = URI.create(String.valueOf(id));
        return ResponseEntity.created(uri).build();
    }
}
