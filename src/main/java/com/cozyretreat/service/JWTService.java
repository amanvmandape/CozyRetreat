package com.cozyretreat.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.cozyretreat.entity.AppUser;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWTService{


    @Value("${jwt.secret_key}")
    private String algorithmKey;

    @Value("${jwt.issuer}")
    private String issuer;

    @Value("${jwt.expiry}")
    private int expiry;

    private Algorithm algorithm;

    @PostConstruct
    public void init(){
        algorithm = Algorithm.HMAC256(algorithmKey);
    }

    public String generateToken(AppUser user){
        return JWT.create()
                .withClaim("name", user.getName())
                .withExpiresAt(new Date(System.currentTimeMillis() + expiry))
                .withIssuer(issuer)
                .sign(algorithm);
    }

    public String validateToken(String token)
    {
        DecodedJWT verify = JWT.require(algorithm).withIssuer(issuer).build().verify(token);
        return verify.getClaim("name").asString();
    }
}
