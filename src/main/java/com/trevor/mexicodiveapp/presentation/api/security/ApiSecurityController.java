package com.trevor.mexicodiveapp.presentation.api.security;

import com.trevor.mexicodiveapp.logic.model.User;
import com.trevor.mexicodiveapp.logic.model.security.ApiToken;
import com.trevor.mexicodiveapp.logic.model.security.Credentials;
import com.trevor.mexicodiveapp.logic.service.UserService;
import com.trevor.mexicodiveapp.logic.service.security.ApiSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/authenticate")
public class ApiSecurityController {

    private ApiSecurityService apiSecurityService;
    private UserService userService;

    @Autowired
    public ApiSecurityController(ApiSecurityService apiSecurityService, UserService userService) {
        this.apiSecurityService = apiSecurityService;
        this.userService = userService;
    }

    @PostMapping
    public ApiToken getApiToken(@RequestBody Credentials credentials) {
        User user = userService.findByEmailAndPassword(credentials.getEmail(), credentials.getPassword());
        if (!user.getEmail().equals(credentials.getEmail()) || !user.getPassword().equals(credentials.getPassword())) {
            return null;
        }
        return apiSecurityService.getApiToken();
    }
}
