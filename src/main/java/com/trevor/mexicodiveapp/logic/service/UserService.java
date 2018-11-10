package com.trevor.mexicodiveapp.logic.service;

import com.trevor.mexicodiveapp.logic.model.User;
import com.trevor.mexicodiveapp.logic.model.security.Credentials;
import com.trevor.mexicodiveapp.logic.repository.RoleRepository;
import com.trevor.mexicodiveapp.logic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private UserRoleService userRoleService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, UserRoleService userRoleService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userRoleService = userRoleService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        User savedUser = userRepository.save(user);
        userRoleService.saveRelation(savedUser, roleRepository.findByRole("ADMIN"));
        return savedUser;
    }

    public Boolean validateUser(Credentials credentials) {
        User user = userRepository.findByEmail(credentials.getEmail());
        if (user == null) {
            throw new InvalidUserException("Invalid user");//todo check why is not being thrown when we dont use valid credentials
        }
        return bCryptPasswordEncoder.matches(credentials.getPassword(), user.getPassword());
    }
}