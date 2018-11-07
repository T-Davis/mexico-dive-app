package com.trevor.mexicodiveapp.logic.repository;

import com.trevor.mexicodiveapp.logic.model.User;

public interface UserRepository {
    User findByEmail(String email);

    User save(User user);

}