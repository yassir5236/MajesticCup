package org.yassir.MajesticCup.Security;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Service
public class JwtTokenProvider {

    private String secretKey ="";
    public JwtTokenProvider() throws NoSuchAlgorithmException {
        KeyGenerator generator = KeyGenerator.getInstance("HmacSHA256");
        SecretKey sk = generator.generateKey();
        secretKey = Base64.getEncoder().encodeToString(sk.getEncoded());

    }

    public String generateToken(String username, String role) {
        Map <String , Objects> claims = new HashMap<>();

        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .and()
                .signWith(getKey())
                .compact();
    }


    private Key getKey(){
    byte[] keyBytes = Decoders.BASE64.decode(secretKey);
    return Keys.hmacShaKeyFor(keyBytes);
    }
}
