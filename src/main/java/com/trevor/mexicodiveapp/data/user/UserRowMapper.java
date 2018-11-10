package com.trevor.mexicodiveapp.data.user;

import com.trevor.mexicodiveapp.logic.model.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return User.builder()
                .id(rs.getInt("user_id"))
                .email(rs.getString("email"))
                .password(rs.getString("password"))
                .name(rs.getString("name"))
                .lastName(rs.getString("last_name"))
                .active(rs.getInt("active"))
                .build();

    }
}
