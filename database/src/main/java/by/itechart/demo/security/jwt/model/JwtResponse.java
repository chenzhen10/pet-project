package by.itechart.demo.security.jwt.model;


import lombok.Data;

import java.util.Collection;

@Data
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Collection role;

    public JwtResponse(String accessToken,Collection role) {
        this.token = accessToken;
        this.role = role;
    }
}
