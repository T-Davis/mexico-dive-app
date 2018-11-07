package com.trevor.mexicodiveapp.data.weatherApi;

import com.trevor.mexicodiveapp.logic.model.Weather;
import com.trevor.mexicodiveapp.logic.repository.weatherApi.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.net.URI;

@Repository
@PropertySource("classpath:openWeatherApi.properties")
public class WeatherApiRepository implements WeatherRepository {


    private static final String PATH = "weather";
    private static final String QUERY = "q";
    @Value("${api.weather.baseurl}")
    private String BASE_URL;
    @Value("${api.weather.apikey.param}")
    private String APPID;
    @Value("${api.weather.apikey.value}")
    private String API_KEY;
    private RestTemplate restTemplate;
    private WeatherApiMapper weatherApiMapper;


    @Autowired
    public WeatherApiRepository(RestTemplate restTemplate, WeatherApiMapper weatherApiMapper) {
        this.restTemplate = restTemplate;
        this.weatherApiMapper = weatherApiMapper;
    }

    @Override
    public Weather getWeatherByCity(String city) {
        URI uri = new DefaultUriBuilderFactory()
                .uriString(BASE_URL)
                .path(PATH)
                .queryParam(QUERY, city)
                .queryParam(APPID, API_KEY)
                .build();
        return weatherApiMapper.apiWeatherMapper(restTemplate.getForObject(uri, WeatherApiResponse.class));
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
        return weatherApiMapper.apiWeatherMapper(restTemplate.getForObject(uri, WeatherApiResponse.class));
    }


}