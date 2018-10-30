package com.trevor.mexicodiveapp.data.security;

import com.trevor.mexicodiveapp.logic.security.ApiSecurityRepository;
import com.trevor.mexicodiveapp.logic.security.ApiToken;

public class ApiSecurityRepositoryImpl implements ApiSecurityRepository {
    @Override
    public ApiToken getApiToken(String username, String password) {
        return null;
    }

//    private final DiveRowMapper rowMapper = new DiveRowMapper();
//    private final String diveTable = "dives";
//
//    private NamedParameterJdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public MySqlDiveRepository(NamedParameterJdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    @Override
//    public ApiToken getApiToken(String username, String password) {
//        String query = "SELECT * FROM " + diveTable + " WHERE d_location = :location ";
//        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("location", location);
//        return jdbcTemplate.query(query, namedParameters, rowMapper);
//    }
}
