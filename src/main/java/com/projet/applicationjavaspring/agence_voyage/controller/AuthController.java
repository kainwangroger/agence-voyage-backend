package com.projet.applicationjavaspring.agence_voyage.controller;

import com.projet.applicationjavaspring.agence_voyage.entites.Clients;
import com.projet.applicationjavaspring.agence_voyage.service.ClientsService;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// import com.projet.applicationjavaspring.agence_voyage.dto.AuthResponse;
// import com.projet.applicationjavaspring.agence_voyage.dto.LoginRequest;
// import com.projet.applicationjavaspring.agence_voyage.entites.Utilisateur;
// import com.projet.applicationjavaspring.agence_voyage.service.AuthService;
// import com.projet.applicationjavaspring.agence_voyage.service.UtilisateurService;
// import org.springframework.security.core.Authentication;

// @CrossOrigin(origins = "http://localhost:5173")
// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final AuthService authService;
//     private final UtilisateurService utilisateurService;

//     public AuthController(AuthService authService, UtilisateurService utilisateurService) {
//         this.authService = authService;
//         this.utilisateurService = utilisateurService;
//     }

//     // Endpoint de connexion

//     @PostMapping("/login")
//     public ResponseEntity<?> login(@RequestBody LoginRequest request) {
//         try {
//             AuthResponse response = authService.login(request.getEmail(), request.getMotDePasse());
//             return ResponseEntity.ok(response);
//         } catch (Exception e) {
//             return ResponseEntity.status(401).body("Erreur d'authentification : " + e.getMessage());
//         }
//     }

//     // @PostMapping("/login")
//     // public ResponseEntity<?> login(@RequestBody Utilisateur utilisateur) {
//     // try {
//     // String token =
//     // authService.authenticateAndGenerateToken(utilisateur.getEmail(),
//     // utilisateur.getMotDePasse());
//     // return ResponseEntity.ok("Bearer " + token);
//     // } catch (Exception e) {
//     // return ResponseEntity.status(401).body("Échec de l'authentification : " +
//     // e.getMessage());
//     // }
//     // }

//     // Endpoint d'inscription
//     @PostMapping("/register")
//     public ResponseEntity<String> register(@RequestBody Utilisateur utilisateur) {
//         try {
//             utilisateurService.creerUtilisateurAvecClient(utilisateur);
//             return ResponseEntity.ok("Utilisateur enregistré avec succès !");
//         } catch (RuntimeException e) {
//             return ResponseEntity.badRequest().body(e.getMessage());
//         }
//     }
// }

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final ClientsService clientsService;

    public AuthController(ClientsService clientsService) {
        this.clientsService = clientsService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Clients client) {
        try {
            clientsService.creerClient(client);
            return ResponseEntity.ok("Inscription réussie");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        try {
            String email = request.get("email");
            String motDePasse = request.get("motDePasse");

            Clients client = clientsService.connecterClient(email, motDePasse);

            return ResponseEntity.ok(Map.of(
                    "email", client.getEmail(),
                    "nom", client.getNom(),
                    "prenom", client.getPrenom(),
                    "role", client.getRole()));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
