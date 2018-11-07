package com.trevor.mexicodiveapp.logic.service.weatherApi;


import com.trevor.mexicodiveapp.data.weatherApi.WeatherApiRepository;
import com.trevor.mexicodiveapp.logic.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    private WeatherApiRepository weatherApiRepository;

    @Autowired
    public WeatherService(WeatherApiRepository weatherApiRepository) {
        this.weatherApiRepository = weatherApiRepository;
    }

    public Weather getWeatherByCity(String city) {
        return weatherApiRepository.getWeatherByCity(city);
    }

    public Weather getWeatherByCoordinates(Double lat, Double lon) {
        return weatherApiRepository.getWeatherByCoordinates(lat, lon);
    }
}
