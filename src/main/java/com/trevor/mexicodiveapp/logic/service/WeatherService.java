package com.trevor.mexicodiveapp.logic.service;


import com.trevor.mexicodiveapp.data.apiWeather.ApiWeatherRepository;
import com.trevor.mexicodiveapp.logic.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    private ApiWeatherRepository apiWeatherRepository;

    @Autowired
    public WeatherService(ApiWeatherRepository apiWeatherRepository) {
        this.apiWeatherRepository = apiWeatherRepository;
    }

    public Weather getWeatherByCity(String city) {
        return apiWeatherRepository.getWeatherByCity(city);
    }

    public Weather getWeatherByCoordinates(Double lat, Double lon) {
        return apiWeatherRepository.getWeatherByCoordinates(lat, lon);
    }
}
