// package com.projet.applicationjavaspring.agence_voyage.config;

// import io.jsonwebtoken.*;
// import org.springframework.stereotype.Component;

// import java.util.Date;

// @Component
// public class JwtUtil {

// private final String SECRET_KEY = "ma_clé_secrète"; // Remplace par une vraie
// clé en prod
// private final long EXPIRATION_TIME = 86400000; // 24h

// public String generateToken(String email) {
// return Jwts.builder()
// .setSubject(email)
// .setIssuedAt(new Date())
// .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
// .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
// .compact();
// }

// public String getEmailFromToken(String token) {
// return Jwts.parser().setSigningKey(SECRET_KEY)
// .parseClaimsJws(token).getBody().getSubject();
// }

// public boolean validateToken(String token) {
// try {
// Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
// return true;
// } catch (JwtException | IllegalArgumentException e) {
// return false;
// }
// }
// }