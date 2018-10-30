package com.trevor.mexicodiveapp.logic.security;

public interface ApiSecurityRepository {

    ApiToken getApiToken(String username, String password);
}
