package com.projet.applicationjavaspring.agence_voyage.controller;

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

// import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;
import java.util.stream.Collectors;

import com.projet.applicationjavaspring.agence_voyage.dto.VoyageRequest;
import com.projet.applicationjavaspring.agence_voyage.entites.Voyage;
import com.projet.applicationjavaspring.agence_voyage.service.VoyageService;

@CrossOrigin(origins = "http://localhost:5173") // Autorise les requêtes du front-end
@RestController
@RequestMapping("/voyages") // Tous les endpoints commenceront par /api/voyages
public class VoyageController {

    private final VoyageService voyageService;

    // Constructeur pour injecter le service
    public VoyageController(VoyageService voyageService) {
        this.voyageService = voyageService;
    }

    // 🔵 1. Créer un voyage à partir du DTO
    @PostMapping
    public ResponseEntity<String> creerVoyage(@RequestBody VoyageRequest request) {
        Voyage voyage = new Voyage();

        // Copier les données du DTO vers l'entité
        voyage.setVilleDepart(request.getVilleDepart());
        voyage.setVilleArrivee(request.getVilleArrivee());
        voyage.setDateDepart(request.getDateDepart());
        voyage.setPrix(request.getPrix());
        voyage.setNombrePlaces(request.getNombrePlaces());
        voyage.setLibelle(request.getLibelle());

        // Sauvegarder dans la base via le service
        voyageService.creer(voyage);

        return ResponseEntity.status(HttpStatus.CREATED).body("Voyage créé avec succès !");
    }

    // 🔵 2. Récupérer tous les voyages
    @GetMapping
    public ResponseEntity<List<VoyageRequest>> getAllVoyages() {
        List<Voyage> voyages = voyageService.listerTous(); // Liste d'entités

        // On transforme chaque entité en DTO
        List<VoyageRequest> dtoList = voyages.stream().map(voyage -> {
            VoyageRequest dto = new VoyageRequest();
            dto.setId(voyage.getId());
            dto.setVilleDepart(voyage.getVilleDepart());
            dto.setVilleArrivee(voyage.getVilleArrivee());
            dto.setDateDepart(voyage.getDateDepart());
            dto.setPrix(voyage.getPrix());
            dto.setNombrePlaces(voyage.getNombrePlaces());
            dto.setLibelle(voyage.getLibelle());
            return dto;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(dtoList);
    }

    // 🔵 3. Supprimer un voyage
    @DeleteMapping("/{id}")
    public ResponseEntity<String> supprimer(@PathVariable Long id) {
        voyageService.supprimer(id);
        return ResponseEntity.ok("Voyage supprimé !");
    }

    // 🔵 4. Mettre à jour un voyage
    @PutMapping("/{id}")
    public ResponseEntity<String> mettreAJour(@PathVariable Long id, @RequestBody VoyageRequest request) {
        Voyage voyage = new Voyage();

        // Mettre à jour les champs
        voyage.setId(id); // Important pour la mise à jour
        voyage.setVilleDepart(request.getVilleDepart());
        voyage.setVilleArrivee(request.getVilleArrivee());
        voyage.setDateDepart(request.getDateDepart());
        voyage.setPrix(request.getPrix());
        voyage.setNombrePlaces(request.getNombrePlaces());
        voyage.setLibelle(request.getLibelle());

        voyageService.mettreAJour(id, voyage);
        return ResponseEntity.ok("Voyage mis à jour !");
    }
}

// @CrossOrigin(origins = "http://localhost:5173")
// @RestController
// @RequestMapping("/voyages")
// public class VoyageController {

// private final VoyageService voyageService;

// public VoyageController(VoyageService voyageService) {
// this.voyageService = voyageService;
// }

// // Création d’un voyage
// @PostMapping(consumes = APPLICATION_JSON_VALUE)
// public ResponseEntity<String> creer(@RequestBody Voyage voyage) {
// voyageService.creer(voyage);
// return ResponseEntity.status(HttpStatus.CREATED).body("Voyage créé !");
// }

// @GetMapping("/{id}")
// public ResponseEntity<Voyage> getVoyage(@PathVariable Long id) {
// try {
// return ResponseEntity.ok(voyageService.rechercherParId(id));
// } catch (RuntimeException e) {
// return ResponseEntity.notFound().build();
// }
// }

// @GetMapping
// public List<Voyage> listerTous() {
// return voyageService.listerTous();
// }

// @PutMapping("/{id}")
// public ResponseEntity<String> mettreAJour(@PathVariable Long id, @RequestBody
// Voyage voyage) {
// try {
// voyageService.mettreAJour(id, voyage);
// return ResponseEntity.ok("Voyage mis à jour !");
// } catch (RuntimeException e) {
// return ResponseEntity.badRequest().body("Erreur : " + e.getMessage());
// }
// }

// @DeleteMapping("/{id}")
// public ResponseEntity<String> supprimer(@PathVariable Long id) {
// try {
// voyageService.supprimer(id);
// return ResponseEntity.ok("Voyage supprimé !");
// } catch (RuntimeException e) {
// return ResponseEntity.badRequest().body("Erreur : " + e.getMessage());
// }
// }
// }
