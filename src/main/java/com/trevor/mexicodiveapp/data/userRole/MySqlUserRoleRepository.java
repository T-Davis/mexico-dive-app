package com.trevor.mexicodiveapp.data.userRole;

import com.trevor.mexicodiveapp.logic.model.Role;
import com.trevor.mexicodiveapp.logic.model.User;
import com.trevor.mexicodiveapp.logic.model.UserRole;
import com.trevor.mexicodiveapp.logic.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class MySqlUserRoleRepository implements UserRoleRepository {

    private final String tableName = "user_role";

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public MySqlUserRoleRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public UserRole save(User user, Role role) {
        String query = "INSERT INTO " + tableName + " VALUES(:userId, :roleId)";
        UserRole userRole = new UserRole(user.getId(), role.getId());
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(userRole);
        jdbcTemplate.update(query, namedParameters);
        return userRole;
    }

}
