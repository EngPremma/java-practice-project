package com.example.java_practice_project.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RequestLoggingFilter extends HttpFilter {
    private static final Logger logger = LoggerFactory.getLogger(RequestLoggingFilter.class);

    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String httpMethod = request.getMethod();

        logger.info("{} {}", httpMethod, request.getRequestURL());

        chain.doFilter(request, response);
    }
}
