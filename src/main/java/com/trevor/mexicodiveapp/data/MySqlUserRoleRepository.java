package com.trevor.mexicodiveapp.data;

import com.trevor.mexicodiveapp.logic.model.Role;
import com.trevor.mexicodiveapp.logic.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class MySqlUserRoleRepository implements UserRoleRepository {
    @Override
    public void save(User user, Role role) {
        //todo your query to save in the user_role table
    }
}
