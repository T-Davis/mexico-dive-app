package com.trevor.mexicodiveapp.data;

import com.trevor.mexicodiveapp.logic.model.Role;
import com.trevor.mexicodiveapp.logic.model.User;


public interface UserRoleRepository {

    void save(User user, Role role);

}
