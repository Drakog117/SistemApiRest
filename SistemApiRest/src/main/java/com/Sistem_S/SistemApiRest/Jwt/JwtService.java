package com.Sistem_S.SistemApiRest.Jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    public static final String SECRET_KEY = "9a3062ea7f2dcc7907cae3ca72da8b52824a8c2527f9ba72fe784b959dc68f37";

    public String getToken(UserDetails systemUsers) {
        return getToken(new HashMap<>(), systemUsers);
    }

    private String getToken(Map<String, Object> extraClaims, UserDetails systemUsers) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(systemUsers.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
