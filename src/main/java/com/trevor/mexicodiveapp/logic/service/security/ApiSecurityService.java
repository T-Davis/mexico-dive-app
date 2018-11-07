package com.trevor.mexicodiveapp.logic.service.security;

import com.trevor.mexicodiveapp.logic.model.security.ApiToken;
import com.trevor.mexicodiveapp.logic.repository.security.ApiSecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiSecurityService {

    private ApiSecurityRepository apiSecurityRepository;

    @Autowired
    public ApiSecurityService(ApiSecurityRepository apiSecurityRepository) {
        this.apiSecurityRepository = apiSecurityRepository;
    }

    public ApiToken getApiToken() {
        return apiSecurityRepository.getApiToken();
    }
}
