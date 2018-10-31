package com.trevor.mexicodiveapp.security.apiSecurity;

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
