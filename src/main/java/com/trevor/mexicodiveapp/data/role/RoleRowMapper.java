package com.trevor.mexicodiveapp.data.role;

import com.trevor.mexicodiveapp.logic.model.Role;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleRowMapper implements RowMapper<Role> {

    @Override
    public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
        Role.builder()
                .id(rs.getInt("role_id"))
                .role(rs.getString("role"));
        return Role.builder().build();
    }
}