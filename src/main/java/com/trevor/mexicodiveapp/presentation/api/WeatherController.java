package com.trevor.mexicodiveapp.presentation.api;

import com.trevor.mexicodiveapp.logic.model.Weather;
import com.trevor.mexicodiveapp.logic.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {
    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

//    @GetMapping("/city/{city}")
//    public WeatherApiResponse getWeatherByCity(@PathVariable("city") String city) {
//        return weatherService.getWeatherByCity(city);
//    }

    @GetMapping("/city")
    public Weather getWeatherByCity(@PathVariable("city") String city) {
        return weatherService.getWeatherByCity(city);
    }

    @GetMapping("/coordinates")
    public Weather getWeatherByCoordinatesa(@PathVariable("lat") Double lat, @PathVariable("lon") Double lon) {
        return weatherService.getWeatherByCoordinates(lat, lon);
    }

}
