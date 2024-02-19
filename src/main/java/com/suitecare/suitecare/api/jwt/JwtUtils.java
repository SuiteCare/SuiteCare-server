package com.suitecare.suitecare.api.jwt;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.security.Key;
import java.util.Date;
import java.util.List;

@Component
@NoArgsConstructor
public class JwtUtils {
    // JJWT 제공 API 활용하여 HS256(HMAC SHA-256) 해싱된 시크릿 키 생성
    private static final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // Access Token 만료시간 설정
    public static final long ACCESS_TOKEN_VALIDATION_SECOND = 1000L * 60 * 60;

    // 헤더 이름
    public static final String AUTHORIZATION_HEADER = "Authorization";

    // Access Token 생성 메서드
    public String createAccessToken(String id, String role){
        // 현재 시점 Date 객체 생성
        Date now = new Date();

        // JWT 생성. AccessToken 생성하여 반환, id 로 구분, 'role' claim 설정
        return Jwts.builder()
                .setSubject(id)
                .claim("role", role)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + ACCESS_TOKEN_VALIDATION_SECOND))
                .signWith(secretKey)
                .compact();
    }

    // Token 유효성 검증 메서드
    public boolean validateToken(String token) {
        // Token 파싱 후 문제 시 false, 정상 시 true
        try {
            Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);

            return true;
        } catch (SignatureException e) {
            // 서명이 잘못되었을 때
            System.out.println(e.getMessage() + "\n잘못된 서명입니다.");
        } catch (ExpiredJwtException e) {
            // Token이 만료되었을 때
            System.out.println(e.getMessage() + "\n만료된 Token 입니다.");
        } catch (IllegalArgumentException | MalformedJwtException e) {
            // Token 변조가 의심될 때
            System.out.println(e.getMessage() + "\n잘못된 Token 입니다.");
        }

        return false;

    }

    // Token 에서 id 추출하여 반환하는 메서드
    public String getId(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Token 에서 role 추출하여 반환하는 메서드
    public String getRole(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("role")
                .toString();
    }

    // HttpServletRequest 에서 Authrization Header 를 통해 Access Token 추출하는 메서드
    public String getAccessToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);

        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }

        return null;
    }

    public Authentication getAuthenticationToken(String token) {
        String id = getId(token);
        String role = getRole(token);

        return new UsernamePasswordAuthenticationToken(id, null, List.of(new SimpleGrantedAuthority(role)));
    }
}
