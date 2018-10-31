package com.trevor.mexicodiveapp.security.apiSecurity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiToken {

    private int id;
    private String token;
}
