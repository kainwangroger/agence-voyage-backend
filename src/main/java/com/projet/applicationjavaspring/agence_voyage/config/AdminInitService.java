package com.projet.applicationjavaspring.agence_voyage.config;

import com.projet.applicationjavaspring.agence_voyage.entites.Role;
import com.projet.applicationjavaspring.agence_voyage.entites.Clients;
import com.projet.applicationjavaspring.agence_voyage.repository.ClientsRepository;

import jakarta.annotation.PostConstruct;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class AdminInitService {

    private final ClientsRepository ClientsRepository;

    public AdminInitService(ClientsRepository ClientsRepository) {
        this.ClientsRepository = ClientsRepository;
    }

    @PostConstruct
    public void initAdmin() {
        String email = "admin@admin.com";

        if (!ClientsRepository.existsByEmail(email)) {
            Clients admin = new Clients();
            admin.setNom("Admin");
            admin.setPrenom("Principal");
            admin.setSexe("M");
            admin.setNationalite("Tchadienne");
            admin.setEmail(email);
            admin.setTelephone("22871257014");
            admin.setAdresse("Adresse Admin");
            admin.setDateDeNaissance(LocalDate.parse("1990-01-01"));
            admin.setMotDePasse("Admin123"); // à sécuriser plus tard
            admin.setRole(Role.ADMIN);

            ClientsRepository.save(admin);
            System.out.println(" Admin créé avec succès !");
        } else {
            System.out.println(" Admin déjà existant.");
        }
    }

}

// package com.projet.applicationjavaspring.agence_voyage.config;
// import com.projet.applicationjavaspring.agence_voyage.entites.Role;

// import com.projet.applicationjavaspring.agence_voyage.entites.Utilisateur;
// import
// com.projet.applicationjavaspring.agence_voyage.repository.UtilisateurRepository;

// import jakarta.annotation.PostConstruct;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// @Service
// public class AdminInitService {

// private final UtilisateurRepository utilisateurRepository;
// private final PasswordEncoder passwordEncoder;

// public AdminInitService(UtilisateurRepository utilisateurRepository,
// PasswordEncoder passwordEncoder) {
// this.utilisateurRepository = utilisateurRepository;
// this.passwordEncoder = passwordEncoder;
// }

// @PostConstruct
// public void initAdmin() {
// String email = "admin@admin.com";

// if (!utilisateurRepository.existsByEmail(email)) {
// Utilisateur admin = new Utilisateur();
// admin.setNom("Admin");
// admin.setPrenom("Principal");
// admin.setEmail(email);
// admin.setMotDePasse(passwordEncoder.encode("Admin123"));
// admin.setRole(Role.ADMIN);

// utilisateurRepository.save(admin);
// System.out.println(" Admin créé avec succès !");
// } else {
// System.out.println(" Admin déjà existant.");
// }
// }
// }