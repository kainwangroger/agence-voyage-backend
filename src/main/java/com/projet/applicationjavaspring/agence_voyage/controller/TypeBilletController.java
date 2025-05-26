package com.projet.applicationjavaspring.agence_voyage.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import com.projet.applicationjavaspring.agence_voyage.entites.TypeBillet;
import com.projet.applicationjavaspring.agence_voyage.service.TypeBilletService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/type-billets")
public class TypeBilletController {

    private final TypeBilletService typeBilletService;

    public TypeBilletController(TypeBilletService typeBilletService) {
        this.typeBilletService = typeBilletService;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> creer(@RequestBody TypeBillet typeBillet) {
        typeBilletService.creer(typeBillet);
        return ResponseEntity.status(HttpStatus.CREATED).body("Type de billet créé !");
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeBillet> getTypeBillet(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(typeBilletService.recuperer(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<TypeBillet> listerTous() {
        return typeBilletService.recupererTous();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> mettreAJour(@PathVariable Long id, @RequestBody TypeBillet typeBillet) {
        try {
            typeBilletService.mettreAJour(id, typeBillet);
            return ResponseEntity.ok("Type de billet mis à jour !");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Erreur : " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> supprimer(@PathVariable Long id) {
        try {
            typeBilletService.supprimer(id);
            return ResponseEntity.ok("Type de billet supprimé !");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Erreur : " + e.getMessage());
        }
    }
}

// @RestController
// @RequestMapping(path = "/type-billets")
// public class TypeBilletController {

// private TypeBilletService typeBilletService;

// public TypeBilletController(TypeBilletService typeBilletService) {
// this.typeBilletService = typeBilletService;
// }

// // CREATE
// // La méthode creer() est annotée avec @ResponseStatus(HttpStatus.CREATED),
// ce qui signifie que
// // si la création du type de billet réussit, la réponse HTTP aura le statut
// 201 (Created).
// @ResponseStatus(value = HttpStatus.CREATED)
// @PostMapping(consumes = APPLICATION_JSON_VALUE)
// public void creer(@RequestBody TypeBillet typeBillet) {
// this.typeBilletService.creer(typeBillet);
// }

// // READ by ID
// @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
// public TypeBillet getTypeBillet(@PathVariable int id) {
// return this.typeBilletService.recuperer(id);

// }

// // READ all
// @GetMapping(produces = APPLICATION_JSON_VALUE)
// public List<TypeBillet> listerTous() {
// return this.typeBilletService.recupererTous();
// }

// // UPDATE
// @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE)
// public void mettreAJour(@PathVariable int id, @RequestBody TypeBillet
// typeBillet) {
// this.typeBilletService.mettreAJour(id, typeBillet);
// }

// // DELETE
// @DeleteMapping("/{id}")
// public void supprimer(@PathVariable int id) {
// this.typeBilletService.supprimer(id);
// }
// }
