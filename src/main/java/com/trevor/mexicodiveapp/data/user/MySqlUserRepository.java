package com.trevor.mexicodiveapp.data.user;

import com.trevor.mexicodiveapp.logic.model.User;
import com.trevor.mexicodiveapp.logic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class MySqlUserRepository implements UserRepository {

    private final UserRowMapper rowMapper = new UserRowMapper();
    private final String tableName = "user";

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public MySqlUserRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User findByEmail(String email) {
        String query = "SELECT * FROM " + tableName + " WHERE email = :email";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("email", email);
        return jdbcTemplate.queryForObject(query, namedParameters, rowMapper);
    }

    @Override
    public User save(User user) {
        String query = "INSERT INTO " + tableName + " VALUES(null, :email, :password, :name, :lastName, :active, :roles)";
        KeyHolder key = new GeneratedKeyHolder();
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(user);
        jdbcTemplate.update(query, namedParameters, key);
        user.setId(key.getKey().intValue());
        return user;
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        String query = "SELECT * FROM " + tableName + " WHERE email = :email and password = :password";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("email", email).addValue("password", password);
        return jdbcTemplate.queryForObject(query, namedParameters, rowMapper);
    }
}
