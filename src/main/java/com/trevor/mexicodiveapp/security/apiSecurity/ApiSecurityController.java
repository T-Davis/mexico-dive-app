package com.trevor.mexicodiveapp.security.apiSecurity;

import com.trevor.mexicodiveapp.logic.model.User;
import com.trevor.mexicodiveapp.logic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{email}+{password}")
    public ApiToken getApiToken(@PathVariable String email, @PathVariable String password) {
        User user = userService.findByEmailAndPassword(email, password);
        return apiSecurityService.getApiToken();
    }
}
