package com.trevor.mexicodiveapp.logic.service;

import com.trevor.mexicodiveapp.logic.model.Role;
import com.trevor.mexicodiveapp.logic.model.User;
import com.trevor.mexicodiveapp.logic.model.UserRole;
import com.trevor.mexicodiveapp.logic.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {
    private UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleService(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public UserRole saveRelation(User user, Role role) {
        return userRoleRepository.save(user, role);
    }
}
