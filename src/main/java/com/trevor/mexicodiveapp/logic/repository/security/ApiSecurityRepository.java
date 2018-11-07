package com.trevor.mexicodiveapp.logic.repository.security;

import com.trevor.mexicodiveapp.logic.model.security.ApiToken;

public interface ApiSecurityRepository {

    ApiToken getApiToken();
}
