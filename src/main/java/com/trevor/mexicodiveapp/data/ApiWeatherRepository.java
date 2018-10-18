package com.trevor.mexicodiveapp.data;

import com.trevor.mexicodiveapp.logic.model.apiWeather.ApiWeatherResponse;
import com.trevor.mexicodiveapp.logic.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    public ApiWeatherRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ApiWeatherResponse getWeather(String location) {
        URI uri = new DefaultUriBuilderFactory()
                .uriString(BASE_URL)
                .path(PATH)
                .queryParam(QUERY, location)
                .queryParam(APPID, API_KEY)
                .build();
        ResponseEntity<ApiWeatherResponse> result = restTemplate.getForEntity(uri, ApiWeatherResponse.class);
        return result.getBody();
    }

}