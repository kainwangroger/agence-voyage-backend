// package com.projet.applicationjavaspring.agence_voyage.config;

// import java.util.List;

// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import
// org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// import com.projet.applicationjavaspring.agence_voyage.entites.Utilisateur;
// import
// com.projet.applicationjavaspring.agence_voyage.repository.UtilisateurRepository;

// @Service
// public class CustomUserDetailsService implements UserDetailsService {

// private final UtilisateurRepository utilisateurRepository;

// public CustomUserDetailsService(UtilisateurRepository utilisateurRepository)
// {
// this.utilisateurRepository = utilisateurRepository;
// }

// public UserDetails loadUserByUsername(String email) throws
// UsernameNotFoundException {
// Utilisateur utilisateur = utilisateurRepository.findByEmail(email)
// .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé avec
// l’email : " + email));

// return new org.springframework.security.core.userdetails.User(
// utilisateur.getEmail(),
// utilisateur.getMotDePasse(),
// List.of(new SimpleGrantedAuthority("ROLE_" + utilisateur.getRole().name())));
// }
// }
