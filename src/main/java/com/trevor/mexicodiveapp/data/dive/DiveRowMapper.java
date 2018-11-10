package com.trevor.mexicodiveapp.data.dive;

import com.trevor.mexicodiveapp.logic.model.Dive;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
class DiveRowMapper implements RowMapper<Dive> {
    @Override
    public Dive mapRow(ResultSet rs, int rowNum) throws SQLException {
        Dive dive = new Dive();
        dive.setId(rs.getInt("d_id"));
        dive.setDate(rs.getDate("d_date").toLocalDate());
        dive.setLocation(rs.getString("d_location"));
        dive.setDurationInMinutes(rs.getDouble("d_duration_in_minutes"));
        dive.setMaxDepthInMeters(rs.getDouble("d_max_depth_in_meters"));
        dive.setWaterConditions(rs.getString("d_water_conditions"));
        dive.setSafetyStop(rs.getBoolean("d_safety_stop"));
        return dive;
    }
}

