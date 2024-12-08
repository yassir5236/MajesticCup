package org.yassir.MajesticCup.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final String secretKey = "mySecretKey";
    private final String HEADER_STRING = "Authorization";
    private final String TOKEN_PREFIX = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(HEADER_STRING);

        if (token != null && token.startsWith(TOKEN_PREFIX)) {
            String jwtToken = token.replace(TOKEN_PREFIX, "");

//            try {
//                Claims claims = Jwts.parser()
//                        .setSigningKey(secretKey)
//                        .parseClaimsJws(jwtToken)
//                        .getBody();
//
//                String username = claims.getSubject();
//
//                if (username != null) {
//                    Authentication authentication = new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
//                    SecurityContextHolder.getContext().setAuthentication(authentication);
//                }
//            } catch (Exception e) {
//                logger.error("Invalid JWT token", e);
//            }
        }

        filterChain.doFilter(request, response);
    }
}
