package com.suitecare.suitecare.api.custom.filter;

import com.suitecare.suitecare.api.jwt.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;
    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    public JwtAuthenticationFilter(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        String token = jwtUtils.getAccessToken(request);

        // 요청 정보와 토큰 정보 로깅
        logger.info("Request URL: {}", request.getRequestURI());
        logger.info("Access token: {}", token);

        if (token != null && jwtUtils.validateToken(token)) {
            Authentication authentication = jwtUtils.getAuthenticationToken(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String login_id = jwtUtils.getLoginId(token);
            request.setAttribute("login_id", login_id);

            // 인증 성공 로깅
            logger.info("Authentication successful for request: {}", request.getRequestURI());
        } else {
            // 인증 실패 로깅
            logger.warn("Authentication failed for request: {}", request.getRequestURI());
        }

        filterChain.doFilter(request, response);
    }
}
