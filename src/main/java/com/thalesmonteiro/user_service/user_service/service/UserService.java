package com.thalesmonteiro.user_service.user_service.service;


import com.thalesmonteiro.user_service.user_service.model.Username;
import com.thalesmonteiro.user_service.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Username> getAllUsers() {
        Sort sort = Sort.by("id").ascending().and(
                Sort.by("name").ascending())
        ;

        return userRepository.findAll(sort);
    }

    public Username getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<Username> update (Username username) {
        userRepository.save(username);
        return getAllUsers();
    }

    public List<Username>  deleteUser(Long id) {
        userRepository.deleteById(id);
        return getAllUsers();
    }
}
