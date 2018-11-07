package com.trevor.mexicodiveapp.logic.repository.weatherApi;

import com.trevor.mexicodiveapp.logic.model.Weather;

public interface WeatherRepository {
    Weather getWeatherByCity(String location);

    Weather getWeatherByCoordinates(Double lat, Double lon);
}
