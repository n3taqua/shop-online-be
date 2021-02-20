package com.truong.shop.security;

import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class jwtUtil {
    private final String securityKey="shoppee2";
    static final String TOKEN_PREFIX = "Bearer";

    public String getJwt(Authentication authentication){
        Date now=new Date();
        int expired=5*60*60;
        Date expiredDate=new Date(now.getTime()+expired*1000);
        customUserDetails userDetails= (customUserDetails) authentication.getPrincipal();
        String jwt= Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setExpiration(expiredDate)
                .setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256,securityKey)
                .compact();
        jwt =TOKEN_PREFIX+" "+jwt;
        return jwt;
    }
    public  String getUserNameFormJWT(String jwt){

        return
                Jwts.parser().setSigningKey(securityKey).parseClaimsJws(jwt)
                        .getBody().getSubject();
    }
    public boolean validateToken(String jwt){
        try{
            Jwts.parser().setSigningKey(securityKey).parseClaimsJws(jwt);
            return true;
        }
        catch (MalformedJwtException exception){

        }
        catch (ExpiredJwtException exception){

        }
        catch (UnsupportedJwtException exception){

        }
        return false;
    }
}
