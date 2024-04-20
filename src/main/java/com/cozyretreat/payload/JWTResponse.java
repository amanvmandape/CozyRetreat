package com.cozyretreat.payload;

import lombok.Data;

@Data
public class JWTResponse {
    private String type="Bearer";
    private String token;

    public JWTResponse(String token) {
        this.token = token;
    }
}
