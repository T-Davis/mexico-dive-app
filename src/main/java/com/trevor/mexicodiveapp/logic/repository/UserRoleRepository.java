package com.trevor.mexicodiveapp.logic.repository;

import com.trevor.mexicodiveapp.logic.model.Role;
import com.trevor.mexicodiveapp.logic.model.User;
import com.trevor.mexicodiveapp.logic.model.UserRole;


public interface UserRoleRepository {

    UserRole save(User user, Role role);

}
