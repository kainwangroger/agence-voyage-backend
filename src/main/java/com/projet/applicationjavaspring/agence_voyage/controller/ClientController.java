package com.projet.applicationjavaspring.agence_voyage.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.applicationjavaspring.agence_voyage.entites.Clients;
import com.projet.applicationjavaspring.agence_voyage.service.ClientsService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientsService clientsService;

    public ClientController(ClientsService clientsService) {
        this.clientsService = clientsService;
    }

    // Création d’un client
    @PostMapping
    public ResponseEntity<String> createClient(@RequestBody Clients client) {
        try {
            clientsService.creerClient(client);
            return ResponseEntity.ok("Client créé avec succès");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<Clients> listerClients() {
        return clientsService.rechercher();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clients> lireClient(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(clientsService.rechercherParId(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> mettreAJourClient(@PathVariable Long id, @RequestBody Clients client) {
        try {
            clientsService.mettreAJour(id, client);
            return ResponseEntity.ok("Client mis à jour avec succès.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client non trouvé !");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> supprimerClient(@PathVariable Long id) {
        try {
            clientsService.supprimer(id);
            return ResponseEntity.ok("Client supprimé avec succès.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client non trouvé !");
        }
    }
}

// @RestController
// @RequestMapping("/clients")
// public class ClientController {

// private final ClientsService clientsService;

// public ClientController(ClientsService clientsService) {
// this.clientsService = clientsService;
// }

// // Lire tous les clients
// @GetMapping
// public List<Clients> listerClients() {
// return clientsService.rechercher();
// }

// // Lire un client par ID
// @GetMapping("/{id}")
// public ResponseEntity<Clients> lireClient(@PathVariable int id) {
// try {
// Clients client = clientsService.rechercherParId(id);
// return ResponseEntity.ok(client);
// } catch (RuntimeException e) {
// return ResponseEntity.notFound().build();
// }
// }

// // Mettre à jour un client
// @PutMapping("/{id}")
// public ResponseEntity<String> mettreAJourClient(@PathVariable int id,
// @RequestBody Clients client) {
// try {
// clientsService.mettreAJour(id, client);
// return ResponseEntity.ok("Client mis à jour avec succès.");
// } catch (RuntimeException e) {
// return ResponseEntity.notFound().build();
// }
// }

// // Supprimer un client
// @DeleteMapping("/{id}")
// public ResponseEntity<String> supprimerClient(@PathVariable int id) {
// try {
// clientsService.supprimer(id);
// return ResponseEntity.ok("Client supprimé avec succès.");
// } catch (RuntimeException e) {
// return ResponseEntity.notFound().build();
// }
// }
// }
