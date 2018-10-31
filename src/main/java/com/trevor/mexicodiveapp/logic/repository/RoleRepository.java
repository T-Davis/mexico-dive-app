package com.trevor.mexicodiveapp.logic.repository;

import com.trevor.mexicodiveapp.logic.model.Role;

public interface RoleRepository {
    Role findByRole(String role);

}
