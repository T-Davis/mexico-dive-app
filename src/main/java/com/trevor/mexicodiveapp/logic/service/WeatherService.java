package com.trevor.mexicodiveapp.logic.service;


import com.trevor.mexicodiveapp.data.ApiWeatherRepository;
import com.trevor.mexicodiveapp.logic.model.apiWeather.ApiWeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    private ApiWeatherRepository apiWeatherRepository;

    @Autowired
    public WeatherService(ApiWeatherRepository apiWeatherRepository) {
        this.apiWeatherRepository = apiWeatherRepository;
    }

    public ApiWeatherResponse getResult(String location) {
        return apiWeatherRepository.getWeather(location);
    }
}
