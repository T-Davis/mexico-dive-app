package com.trevor.mexicodiveapp.logic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

//todo refactor DB naming for consistency
//todo add userId to sql queries

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dive {
    private Integer id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String location;
    private Double durationInMinutes;
    private Double maxDepthInMeters;
    private String waterConditions;
    private Boolean safetyStop;
    private Integer userId;
}
