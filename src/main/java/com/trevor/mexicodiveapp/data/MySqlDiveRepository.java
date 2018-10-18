package com.trevor.mexicodiveapp.data;

import com.trevor.mexicodiveapp.logic.model.Dive;
import com.trevor.mexicodiveapp.logic.repository.DiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final DiveRowMapper rowMapper = new DiveRowMapper();
    private final String diveTable = "dives";

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public MySqlDiveRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Dive> getAllDives() {
        return jdbcTemplate.query("SELECT * FROM " + diveTable, rowMapper);
    }

    @Override
    public List<Dive> getDiveByLocation(String location) {
        String query = "SELECT * FROM " + diveTable + " WHERE d_location = :location ";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("location", location);
        return jdbcTemplate.query(query, namedParameters, rowMapper);
    }

    @Override
    public List<Dive> getDiveByDate(LocalDate date) {
        String query = "SELECT * FROM " + diveTable + " WHERE d_date = :date";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("date", date);
        return jdbcTemplate.query(query, namedParameters, rowMapper);
    }

    @Override
    public Dive getDiveById(int id) {
        String query = "SELECT * FROM " + diveTable + " WHERE d_id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        return jdbcTemplate.queryForObject(query, namedParameters, rowMapper);
    }

    @Override
    public Dive save(Dive dive) {
        String query = "INSERT INTO " + diveTable + " VALUES(null, :date, :location, :durationInMinutes, :maxDepthInMeters, :waterConditions, :safetyStop)";
        KeyHolder key = new GeneratedKeyHolder();
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(dive);
        jdbcTemplate.update(query, namedParameters, key);
        dive.setId(key.getKey().intValue());
        return dive;
    }

    @Override
    public Dive updateDiveById(int id, Dive dive) {
        String query = "UPDATE " + diveTable + " SET d_date=:date, d_location = :location, d_duration_in_minutes = :durationInMinutes, " +
                "d_max_depth_in_meters = :maxDepthInMeters, d_water_conditions = :waterConditions, d_safety_stop = :safetyStop " +
                "WHERE d_id = :id";
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(dive);
        jdbcTemplate.update(query, namedParameters);
        return dive;
    }

    @Override
    public Dive delete(int id) {
        Dive dive = getDiveById(id);
        String query = "DELETE FROM " + diveTable + " WHERE d_id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        jdbcTemplate.update(query, namedParameters);
        return dive;

    }
}


































