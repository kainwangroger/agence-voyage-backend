package com.projet.applicationjavaspring.agence_voyage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.applicationjavaspring.agence_voyage.dto.AuthResponse;
import com.projet.applicationjavaspring.agence_voyage.entites.Clients;
import com.projet.applicationjavaspring.agence_voyage.repository.ClientsRepository;

@Service
public class AuthService {

        private final ClientsRepository ClientsRepository;

        @Autowired
        public AuthService(ClientsRepository ClientsRepository) {
                this.ClientsRepository = ClientsRepository;
        }

        public AuthResponse login(String email, String motDePasse) {
                Clients utilisateur = ClientsRepository.findByEmail(email)
                                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

                // Comparaison simple des mots de passe (en clair)
                if (!utilisateur.getMotDePasse().equals(motDePasse)) {
                        throw new RuntimeException("Mot de passe incorrect");
                }

                return new AuthResponse(
                                null, // pas de token
                                utilisateur.getEmail(),
                                utilisateur.getRole().toString(),
                                utilisateur.getNom(),
                                utilisateur.getPrenom());
        }
}

// package com.projet.applicationjavaspring.agence_voyage.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.authentication.AuthenticationManager;
// import
// org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// // import org.springframework.security.core.AuthenticationException;
// import
// org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// import com.projet.applicationjavaspring.agence_voyage.config.JwtUtil;
// import com.projet.applicationjavaspring.agence_voyage.dto.AuthResponse;
// import com.projet.applicationjavaspring.agence_voyage.entites.Utilisateur;
// import
// com.projet.applicationjavaspring.agence_voyage.repository.UtilisateurRepository;

// @Service
// public class AuthService {

// private final AuthenticationManager authenticationManager;
// private final JwtUtil jwtUtil;
// private final UtilisateurRepository utilisateurRepository;

// @Autowired
// public AuthService(AuthenticationManager authenticationManager,
// JwtUtil jwtUtil,
// UtilisateurRepository utilisateurRepository) {
// this.authenticationManager = authenticationManager;
// this.jwtUtil = jwtUtil;
// this.utilisateurRepository = utilisateurRepository;
// }

// public String authenticateAndGenerateToken(String email, String motDePasse) {
// Authentication authentication = authenticationManager.authenticate(
// new UsernamePasswordAuthenticationToken(email, motDePasse));
// return jwtUtil.generateToken(email);
// }

// public AuthResponse login(String email, String motDePasse) {
// authenticationManager.authenticate(
// new UsernamePasswordAuthenticationToken(email, motDePasse));

// Utilisateur utilisateur = utilisateurRepository.findByEmail(email)
// .orElseThrow(() -> new UsernameNotFoundException("Utilisateur introuvable"));

// String token = jwtUtil.generateToken(email);

// return new AuthResponse(
// token,
// utilisateur.getEmail(),
// utilisateur.getRole().toString(),
// utilisateur.getNom(),
// utilisateur.getPrenom());
// }
// }