package com.trevor.mexicodiveapp.logic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Weather {
    private String description;
    private Double temp;
    private Integer humidity;
    private Double minTemp;
    private Double maxTemp;
    private Double windSpeed;
    private String city;
}
