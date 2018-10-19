package com.trevor.mexicodiveapp.data.apiWeather;

import com.trevor.mexicodiveapp.logic.model.Weather;
import com.trevor.mexicodiveapp.logic.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.net.URI;

@Repository
@PropertySource("classpath:openWeatherApi.properties")
public class ApiWeatherRepository implements WeatherRepository {


    private static final String PATH = "weather";
    private static final String QUERY = "q";
    @Value("${api.weather.baseurl}")
    private String BASE_URL;
    @Value("${api.weather.apikey.param}")
    private String APPID;
    @Value("${api.weather.apikey.value}")
    private String API_KEY;
    private RestTemplate restTemplate;
    private ApiWeatherMapper apiWeatherMapper;


    @Autowired
    public ApiWeatherRepository(RestTemplate restTemplate, ApiWeatherMapper apiWeatherMapper) {
        this.restTemplate = restTemplate;
        this.apiWeatherMapper = apiWeatherMapper;
    }

    @Override
    public Weather getWeatherByCity(String city) {
        URI uri = new DefaultUriBuilderFactory()
                .uriString(BASE_URL)
                .path(PATH)
                .queryParam(QUERY, city)
                .queryParam(APPID, API_KEY)
                .build();
        return apiWeatherMapper.apiWeatherMapper(restTemplate.getForObject(uri, ApiWeatherResponse.class));
    }

    @Override
    public Weather getWeatherByCoordinates(Double lat, Double lon) {
        URI uri = new DefaultUriBuilderFactory()
                .uriString(BASE_URL)
                .path(PATH)
                .queryParam("lat", lat)
                .queryParam("lon", lon)
                .queryParam(APPID, API_KEY)
                .build();
        return apiWeatherMapper.apiWeatherMapper(restTemplate.getForObject(uri, ApiWeatherResponse.class));
    }


}