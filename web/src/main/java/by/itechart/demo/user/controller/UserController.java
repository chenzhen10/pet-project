package by.itechart.demo.user.controller;


import by.itechart.demo.user.dto.CreateUserDto;
import by.itechart.demo.user.model.Role;
import by.itechart.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {


    @Autowired
    private UserService userService;


    @PostMapping("registration")
    public ResponseEntity<?> registerUser(@Valid @RequestBody CreateUserDto newUser) {
        Long id = userService.register(newUser).getId();
        URI uri = URI.create(String.valueOf(id));
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("{id}/roles/assign")
    public ResponseEntity<?> assignRole(@PathVariable Long id, @RequestBody List<Role> role) {
        userService.assignRoles(id, role);
        return ResponseEntity.ok("Updated role");
    }

    @PutMapping("{id}/roles/delete")
    public ResponseEntity<?> deleteRole(@PathVariable Long id) {
        userService.assignRoles(id, Collections.singletonList(Role.Anonym));
        return ResponseEntity.ok("Role deleted");
    }


}
