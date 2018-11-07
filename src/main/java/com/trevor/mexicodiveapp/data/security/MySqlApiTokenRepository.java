package com.trevor.mexicodiveapp.data.security;

import com.trevor.mexicodiveapp.logic.model.security.ApiToken;
import com.trevor.mexicodiveapp.logic.repository.ApiTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class MySqlApiTokenRepository implements ApiTokenRepository {

    private final ApiTokenRowMapper rowMapper = new ApiTokenRowMapper();
    private final String tableName = "api_token";

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public MySqlApiTokenRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public ApiToken saveApiToken(ApiToken apiToken) {
        String query = "INSERT INTO " + tableName + " VALUES(null, :token)";
        KeyHolder key = new GeneratedKeyHolder();
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(apiToken);
        jdbcTemplate.update(query, namedParameters, key);
        apiToken.setId(key.getKey().intValue());
        return apiToken;
    }

    private ApiToken getToken(ApiToken apiToken) {
        String query = "SELECT * FROM " + tableName + " WHERE token = :token";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("token", apiToken);
        return jdbcTemplate.queryForObject(query, namedParameters, rowMapper);
    }

    @Override
    public boolean isTokenValid(ApiToken apiToken) {
        ApiToken tokenFromDB = getToken(apiToken);
        return tokenFromDB != null;
    }
}
