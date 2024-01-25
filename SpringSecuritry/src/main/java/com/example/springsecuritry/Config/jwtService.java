package com.example.springsecuritry.Config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Base64;

@Service
public class jwtService {

    private static final String SECRET_KEY="5215AE9176522B726CA299B74E675";
    public String extractUserName(String token) {
        return null;
    }

    public Claims extractAllclaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSigninKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSigninKey() {
        byte[] keys= Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keys);
    }
}
