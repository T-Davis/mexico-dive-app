package com.trevor.mexicodiveapp.data.role;

import com.trevor.mexicodiveapp.logic.model.Role;
import com.trevor.mexicodiveapp.logic.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class MySqlRoleRepository implements RoleRepository {

    private final RoleRowMapper rowMapper = new RoleRowMapper();
    private final String tableName = "role";

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public MySqlRoleRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Role findByRole(String role) {
        String query = "SELECT * FROM " + tableName + " WHERE role = :role";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("role", role);
        return jdbcTemplate.queryForObject(query, namedParameters, rowMapper);
    }
}
