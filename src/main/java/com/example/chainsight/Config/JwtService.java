package com.example.chainsight.Config;

import com.example.chainsight.Entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    private final String SECRET_KEY = "7b64108dde71ca29231de80de1cdc1c35110e373fc8a2396621b218cff35a6ef194e10610410c371a9424b3fe74036988939d53ee287cd772a946e80ef1631d7cb8b7b66a4b079b38ea75bcf656954330f03d7307f4dcf64d5ae1e6346cf47af2b486e2045e37310e2782ff93378f74a2ae69e219586cf69c4dc5e975bad28c16ced26406359304af6f8bfceb281f05e2f20ba75b63778360a693c18a6d95904d7c07a6ecd5685d80c13d86eb5333812beca77b1938fea8968bf0b98230e78d8e9d18e5a902785673ac230389bf1c9655dd469be6662764722e10aef629d2c4deadde3692a329d460d7c84c372b4674d500ea473777bd1befee13ae0c46d5093";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        if (userDetails instanceof User user) {
            claims.put("userId", user.getUserId());
            claims.put("walletAddress", user.getWalletAddress());
            claims.put("role", user.getRole());
        }
        long EXPIRATION_TIME = 864000000;
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}
