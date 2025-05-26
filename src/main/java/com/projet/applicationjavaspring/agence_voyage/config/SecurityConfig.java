
// // VERSION COMPLETE

// package com.projet.applicationjavaspring.agence_voyage.config;

// // import java.util.Arrays;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import
// org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
// import
// org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
// // import org.springframework.web.cors.CorsConfiguration;
// // import org.springframework.web.cors.CorsConfigurationSource;
// // import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

// private final UserDetailsService userDetailsService;
// private final JwtFilter jwtFilter;

// public SecurityConfig(UserDetailsService userDetailsService, JwtFilter
// jwtFilter) {
// this.userDetailsService = userDetailsService;
// this.jwtFilter = jwtFilter;
// }

// @Bean
// public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
// Exception {
// http
// .csrf().disable()
// .cors()
// .and()
// .authorizeHttpRequests(auth -> auth
// // Routes publiques
// .requestMatchers("/api/auth/**", "/api/utilisateurs").permitAll() // login,
// register
// .requestMatchers("/").permitAll()
// // Les autres routes doivent être sécurisées
// .requestMatchers(
// "/api/voyages/**",
// "/api/typebillets/**",
// "/api/reservations/**",
// "/api/clients/**")
// .authenticated()

// // Optionnel : tout le reste est sécurisé aussi
// .anyRequest().authenticated())
// .sessionManagement(sess -> sess
// .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
// .formLogin().disable()
// .httpBasic().disable();

// // http.addFilterBefore(jwtFilter,
// UsernamePasswordAuthenticationFilter.class);
// return http.build();
// }

// // @Bean
// // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
// // Exception {
// // http
// // .csrf().disable()
// // .cors()
// // .and()
// // .authorizeHttpRequests(auth -> auth
// // .anyRequest().permitAll())

// // .sessionManagement(sess -> sess
// // .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
// // .formLogin().disable()
// // .httpBasic().disable();

// // http.addFilterBefore(jwtFilter,
// UsernamePasswordAuthenticationFilter.class);
// // return http.build();
// // }

// @Bean
// public AuthenticationManager authenticationManager(HttpSecurity http) throws
// Exception {
// return http.getSharedObject(AuthenticationManagerBuilder.class)
// .userDetailsService(userDetailsService)
// .passwordEncoder(new BCryptPasswordEncoder())
// .and()
// .build();
// }

// @Bean
// public PasswordEncoder passwordEncoder() {
// return new BCryptPasswordEncoder();
// }
// }
