package org.example.springsec.config;

import org.example.springsec.filter.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// Configuration class for Spring Security settings
@Configuration
@EnableWebSecurity // Enables Spring Security's web security support
public class SecurityConfig {
    // Service to load user-specific data
    @Autowired
    private UserDetailsService userDetailsService;

    // Custom JWT filter for token-based authentication
    @Autowired
    private JwtFilter jwtFilter;

    // Configures the authentication provider with user details and password
    // encoding
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        // Sets the service to load user details
        provider.setUserDetailsService(userDetailsService);
        // Uses BCrypt hashing for passwords with strength 12
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));

        return provider;
    }

    // Creates the authentication manager from the auto-configuration
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    // Configures security filter chain - main security configuration
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Disables CSRF protection as we're using JWT
                .csrf(customizer -> customizer.disable())

                // Configure authorization rules
                .authorizeHttpRequests(request -> request
                        // Allows public access to register and login endpoints
                        .requestMatchers("register", "login")
                        .permitAll()
                        // All other requests require authentication
                        .anyRequest().authenticated())

                // Enables HTTP Basic authentication
                .httpBasic(Customizer.withDefaults())

                // Configures session management to be stateless (for JWT)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // Adds JWT filter before the standard authentication filter
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}

// in-memory user details service
// This was likely used for testing before implementing actual user service
// @Bean
// public UserDetailsService userDetailsService() {
//
// UserDetails user = User.withDefaultPasswordEncoder()
// .username("user")
// .password("password")
// .roles("USER")
// .build();
//
// UserDetails admin = User.withDefaultPasswordEncoder()
// .username("admin")
// .password("password")
// .roles("ADMIN")
// .build();
//
// return new InMemoryUserDetailsManager(user, admin);
// }
