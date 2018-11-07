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
        userRoleService.saveRelation(user, roleRepository.findByRole("ADMIN"));
        return userRepository.save(user);
    }

    public Boolean validateUser(Credentials credentials) {
        User user = userRepository.findByEmail(credentials.getEmail());
        if (user == null) {
            return false;
        }
        return bCryptPasswordEncoder.matches(credentials.getPassword(), user.getPassword());
    }
}