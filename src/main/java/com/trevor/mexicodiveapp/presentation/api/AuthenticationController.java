package com.trevor.mexicodiveapp.presentation.api;

import com.trevor.mexicodiveapp.logic.model.security.ApiToken;
import com.trevor.mexicodiveapp.logic.model.security.Credentials;
import com.trevor.mexicodiveapp.logic.service.UserService;
import com.trevor.mexicodiveapp.logic.service.security.ApiTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/authenticate")
public class AuthenticationController {

    private ApiTokenService apiTokenService;
    private UserService userService;

    @Autowired
    public AuthenticationController(ApiTokenService apiTokenService, UserService userService) {
        this.apiTokenService = apiTokenService;
        this.userService = userService;
    }

    @PostMapping
    public ApiToken getApiToken(@RequestBody Credentials credentials) {
        if (userService.validateUser(credentials)) {
            return apiTokenService.createToken(credentials);
        }
        return null;
    }


}
