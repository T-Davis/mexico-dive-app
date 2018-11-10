package com.trevor.mexicodiveapp.data.user;

import com.trevor.mexicodiveapp.logic.model.User;
import com.trevor.mexicodiveapp.logic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class MySqlUserRepository implements UserRepository {

    private static final String TABLE_NAME = "user";

    private UserRowMapper rowMapper;
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public MySqlUserRepository(UserRowMapper rowMapper, NamedParameterJdbcTemplate jdbcTemplate) {
        this.rowMapper = rowMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User findByEmail(String emailParam) {
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE email = :email";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("email", emailParam);
        try {
            User user = jdbcTemplate.queryForObject(query, namedParameters, rowMapper);
            return user;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public User save(User user) {
        String query = "INSERT INTO " + TABLE_NAME + " VALUES(null, :active, :email, :lastName, :name, :password )";
        KeyHolder key = new GeneratedKeyHolder();
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(user);
        jdbcTemplate.update(query, namedParameters, key);
        user.setId(key.getKey().intValue());
        return user;
    }

}
