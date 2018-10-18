package com.trevor.mexicodiveapp.logic.repository;

import com.trevor.mexicodiveapp.logic.model.apiWeather.ApiWeatherResponse;

public interface WeatherRepository {
    ApiWeatherResponse getWeather(String location);
}
