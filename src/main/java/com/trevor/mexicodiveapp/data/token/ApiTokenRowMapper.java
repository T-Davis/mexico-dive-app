package com.trevor.mexicodiveapp.data.token;

import com.trevor.mexicodiveapp.logic.model.security.ApiToken;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ApiTokenRowMapper implements RowMapper<ApiToken> {

    @Override
    public ApiToken mapRow(ResultSet rs, int rowNum) throws SQLException {
        ApiToken.builder()
                .id(rs.getInt("token_id"))
                .token(rs.getString("token"));
        return ApiToken.builder().build();
    }
}
