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
        return Dive.builder()
                .id(rs.getInt("d_id"))
                .date(rs.getDate("d_date").toLocalDate())
                .location(rs.getString("d_location"))
                .durationInMinutes(rs.getDouble("d_duration_in_minutes"))
                .maxDepthInMeters(rs.getDouble("d_max_depth_in_meters"))
                .waterConditions(rs.getString("d_water_conditions"))
                .safetyStop(rs.getBoolean("d_safety_stop"))
                .userId(rs.getInt("d_user_id"))
                .build();
    }
}

