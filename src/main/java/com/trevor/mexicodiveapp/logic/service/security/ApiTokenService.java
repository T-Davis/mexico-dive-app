package com.trevor.mexicodiveapp.logic.service.security;

import com.trevor.mexicodiveapp.logic.model.security.ApiToken;
import com.trevor.mexicodiveapp.logic.model.security.Credentials;
import com.trevor.mexicodiveapp.logic.repository.ApiTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiTokenService {

    private ApiTokenRepository apiTokenRepository;

    @Autowired
    public ApiTokenService(ApiTokenRepository apiTokenRepository) {
        this.apiTokenRepository = apiTokenRepository;
    }

    public ApiToken createToken(Credentials credentials) {
        ApiToken apiToken = new ApiToken();
        apiToken.setToken(String.valueOf(credentials.hashCode()));
        return apiTokenRepository.saveApiToken(apiToken);
    }

    public void validateToken(ApiToken apiToken) {
        if (!apiTokenRepository.isTokenValid(apiToken)) {
            throw new ApiTokenInvalidException("Invalidn Token");
        }
    }
}
