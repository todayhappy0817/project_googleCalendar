package com.project1.project1.config;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtConfig {
    public String createAccessToken(String userId){
        Date now = new Date();
        Date expiresAt = new Date(now.getTime() + 24 * 60 * 60 * 1000);
        return Jwts.builder()
                .claim("userId", userId)
                .setIssuedAt(now)
                .setExpiration(expiresAt)
//                .signWith(SignatureAlgorithm.HS256, S)
                .compact();
    }
}
