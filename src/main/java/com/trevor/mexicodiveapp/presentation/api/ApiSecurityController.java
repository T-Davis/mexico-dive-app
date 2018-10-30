package com.trevor.mexicodiveapp.presentation.api;

import com.trevor.mexicodiveapp.logic.security.ApiSecurityService;
import com.trevor.mexicodiveapp.logic.security.ApiToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/authenticate")
public class ApiSecurityController {

    ApiSecurityService apiSecurityService;

    @Autowired
    public ApiSecurityController(ApiSecurityService apiSecurityService) {
        this.apiSecurityService = apiSecurityService;
    }

    @GetMapping("/{username}+{password}")
    public ApiToken getDiveByLocation(@PathVariable String username, @PathVariable String password) {
        return apiSecurityService.getApiToken(username, password);
    }
}
