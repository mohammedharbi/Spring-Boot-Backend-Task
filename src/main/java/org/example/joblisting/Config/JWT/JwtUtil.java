//package org.example.joblisting.Config.JWT;
//
//import io.jsonwebtoken.*;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.stereotype.Component;
//import javax.crypto.SecretKey;
//import java.util.Date;
//
//@Component
//public class JwtUtil {
//
//    private final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//
//    public String generateToken(String username, Role role) {
//        return Jwts.builder()
//                .claim("role", role.name())
//                .setSubject(username)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
//                .signWith(key)
//                .compact();
//    }
//
//    public Claims getClaims(String token) {
//        return Jwts.parserBuilder()
//                .setSigningKey(key)
//                .build()
//                .parseClaimsJws(token)
//                .getBody();
//    }
//
//    public boolean validate(String token) {
//        try {
//            getClaims(token);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//}
