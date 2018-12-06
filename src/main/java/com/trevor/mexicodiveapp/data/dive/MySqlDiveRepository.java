package com.trevor.mexicodiveapp.data.dive;

import com.trevor.mexicodiveapp.logic.model.Dive;
import com.trevor.mexicodiveapp.logic.repository.DiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Primary
@Repository
public class MySqlDiveRepository implements DiveRepository {
    private static final String TABLE_NAME = "dives";

    private DiveRowMapper rowMapper;
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public MySqlDiveRepository(DiveRowMapper rowMapper, NamedParameterJdbcTemplate jdbcTemplate) {
        this.rowMapper = rowMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Cacheable("dives")
    public List<Dive> getAllDives() {
        return jdbcTemplate.query("SELECT * FROM " + TABLE_NAME, rowMapper);
    }

    @Override
    @Cacheable("dives")
    public List<Dive> getDiveByLocation(String location) {
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE d_location = :location ";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("location", location);
        return jdbcTemplate.query(query, namedParameters, rowMapper);
    }

    @Override
    public List<Dive> getDiveByDate(LocalDate date) {
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE d_date = :date";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("date", date);
        return jdbcTemplate.query(query, namedParameters, rowMapper);
    }

    @Override
    public Dive getDiveById(int id) {
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE d_id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        return jdbcTemplate.queryForObject(query, namedParameters, rowMapper);
    }

    @Override
    public Dive save(Dive dive) {
        String query = "INSERT INTO " + TABLE_NAME + " VALUES(null, :date, :location, :durationInMinutes, :maxDepthInMeters, :waterConditions, :safetyStop, :userId)";
        KeyHolder key = new GeneratedKeyHolder();
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(dive);
        jdbcTemplate.update(query, namedParameters, key);
        dive.setId(key.getKey().intValue());
        return dive;
    }

    @Override
    public Dive updateDiveById(Dive dive) {
        String query = "UPDATE " + TABLE_NAME + " SET d_date = :date, d_location = :location, d_duration_in_minutes = :durationInMinutes, " +
                "d_max_depth_in_meters = :maxDepthInMeters, d_water_conditions = :waterConditions, d_safety_stop = :safetyStop, d_user_id = :userId " +
                "WHERE d_id = :id";
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(dive);
        jdbcTemplate.update(query, namedParameters);
        return dive;
    }

    @Override
    public Dive delete(int id) {
        Dive dive = getDiveById(id);
        String query = "DELETE FROM " + TABLE_NAME + " WHERE d_id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        jdbcTemplate.update(query, namedParameters);
        return dive;
    }
}
