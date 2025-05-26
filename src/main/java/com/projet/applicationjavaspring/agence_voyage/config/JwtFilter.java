// package com.projet.applicationjavaspring.agence_voyage.config;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import
// org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import
// org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;
// import java.io.IOException;

// @Component
// public class JwtFilter extends OncePerRequestFilter {

// private final JwtUtil jwtUtil;
// private final UserDetailsService userDetailsService;

// public JwtFilter(JwtUtil jwtUtil, UserDetailsService userDetailsService) {
// this.jwtUtil = jwtUtil;
// this.userDetailsService = userDetailsService;
// }

// @Override
// protected void doFilterInternal(HttpServletRequest request,
// HttpServletResponse response,
// FilterChain filterChain)
// throws ServletException, IOException {

// String authHeader = request.getHeader("Authorization");

// if (authHeader != null && authHeader.startsWith("Bearer ")) {
// String token = authHeader.substring(7);
// String email = jwtUtil.getEmailFromToken(token);

// if (email != null && SecurityContextHolder.getContext().getAuthentication()
// == null) {
// UserDetails userDetails = userDetailsService.loadUserByUsername(email);

// if (jwtUtil.validateToken(token)) {
// UsernamePasswordAuthenticationToken authToken = new
// UsernamePasswordAuthenticationToken(
// userDetails, null, userDetails.getAuthorities());

// authToken.setDetails(
// new WebAuthenticationDetailsSource().buildDetails(request));

// SecurityContextHolder.getContext().setAuthentication(authToken);
// }
// }
// }

// filterChain.doFilter(request, response);
// }

// // NE PAS filtrer les routes publiques comme login/register
// @Override
// protected boolean shouldNotFilter(HttpServletRequest request) throws
// ServletException {
// String path = request.getServletPath();
// return path.startsWith("/api/auth");
// }
// }
