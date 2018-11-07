package com.trevor.mexicodiveapp.logic.service;

import com.trevor.mexicodiveapp.data.UserRoleRepository;
import com.trevor.mexicodiveapp.logic.model.Role;
import com.trevor.mexicodiveapp.logic.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {
    private UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleService(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public void saveRelation(User user, Role role) {
        userRoleRepository.save(user, role);
    }
}
