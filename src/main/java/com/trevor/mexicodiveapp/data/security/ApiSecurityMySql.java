package com.trevor.mexicodiveapp.data.security;

import com.trevor.mexicodiveapp.logic.model.security.ApiToken;
import com.trevor.mexicodiveapp.logic.repository.security.ApiSecurityRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class ApiSecurityMySql implements ApiSecurityRepository {

    private final String tableName = "api_token";

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public ApiSecurityMySql(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private ApiToken createApiToken() {
        return null;
    }

    @Override
    public ApiToken getApiToken() {
        ApiToken apiToken = createApiToken();
        apiToken.setToken(RandomStringUtils.random(10, true, true));
        String query = "INSERT INTO " + tableName + " VALUES(null, :token)";
        KeyHolder key = new GeneratedKeyHolder();
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(apiToken);
        jdbcTemplate.update(query, namedParameters, key);
        apiToken.setId(key.getKey().intValue());
        return apiToken;
    }
}
