package com.thalesmonteiro.user_service.user_service.controller;

import com.thalesmonteiro.user_service.user_service.model.Username;
import com.thalesmonteiro.user_service.user_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<Username> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Username getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public List<Username> updateUser(@PathVariable(value = "id") Long id, @RequestBody @Valid Username user) {
        return userService.update(user);
    }

    @PostMapping
    public List<Username> createUser(@Valid @RequestBody Username username) {
        return userService.update(username);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }
}
