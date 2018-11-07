package com.trevor.mexicodiveapp.logic.repository;

import com.trevor.mexicodiveapp.logic.model.security.ApiToken;

public interface ApiTokenRepository {

    ApiToken saveApiToken(ApiToken apiToken);

    boolean isTokenValid(ApiToken apiToken);


}
