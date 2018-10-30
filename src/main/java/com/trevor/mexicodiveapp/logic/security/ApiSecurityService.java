package com.trevor.mexicodiveapp.logic.security;

import org.springframework.beans.factory.annotation.Autowired;

public class ApiSecurityService {

    ApiSecurityRepository apiSecurityRepository;

    @Autowired
    public ApiSecurityService(ApiSecurityRepository apiSecurityRepository) {
        this.apiSecurityRepository = apiSecurityRepository;
    }

    public ApiToken getApiToken(String username, String password) {
        return apiSecurityRepository.getApiToken(username, password);
    }
}
