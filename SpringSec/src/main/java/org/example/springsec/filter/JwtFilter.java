package org.example.springsec.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.springsec.service.JwtService;
import org.example.springsec.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

// JWT Filter class that intercepts every request to validate JWT tokens
@Component
public class JwtFilter extends OncePerRequestFilter {

    // Service to handle JWT operations like token validation and extraction
    @Autowired
    JwtService jwtService;

    // Application context to get beans
    @Autowired
    ApplicationContext context;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Get the Authorization header from the request
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String userName = null;

        // Check if Authorization header exists and starts with "Bearer "
        if(authHeader != null && authHeader.startsWith("Bearer ")){
            // Extract the token (remove "Bearer " prefix)
            token = authHeader.substring(7);
            // Extract username from the token
            userName = jwtService.extractUsername(token);
        }

        // Proceed only if username is extracted and no authentication exists in SecurityContext
        if(userName != null && SecurityContextHolder.getContext().getAuthentication()==null){

            // Load user details from database using username
            UserDetails userDetails = context.getBean(MyUserDetailsService.class).loadUserByUsername(userName);

            // Validate the token against user details
            if(jwtService.validateToken(token, userDetails)){
                // Create authentication token with user details and authorities
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                // Set additional authentication details from the request
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // Store authentication in the SecurityContext
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        // Continue the filter chain
        filterChain.doFilter(request, response);
    }
}
