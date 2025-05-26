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

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.projet.applicationjavaspring.agence_voyage.dto.ReservationRequest;
import com.projet.applicationjavaspring.agence_voyage.entites.Clients;
import com.projet.applicationjavaspring.agence_voyage.entites.Reservation;
import com.projet.applicationjavaspring.agence_voyage.entites.TypeBillet;
import com.projet.applicationjavaspring.agence_voyage.entites.Voyage;
import com.projet.applicationjavaspring.agence_voyage.service.ClientsService;
import com.projet.applicationjavaspring.agence_voyage.service.ReservationService;
import com.projet.applicationjavaspring.agence_voyage.service.TypeBilletService;
import com.projet.applicationjavaspring.agence_voyage.service.VoyageService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;
    private final ClientsService clientsService;
    private final VoyageService voyageService;
    private final TypeBilletService typeBilletService;

    public ReservationController(ReservationService reservationService,
            ClientsService clientsService,
            VoyageService voyageService,
            TypeBilletService typeBilletService) {
        this.reservationService = reservationService;
        this.clientsService = clientsService;
        this.voyageService = voyageService;
        this.typeBilletService = typeBilletService;
    }

    // @PostMapping(consumes = APPLICATION_JSON_VALUE)
    // public ResponseEntity<String> creer(@RequestBody Reservation reservation) {
    // try {
    // reservation.setClient(clientsService.rechercherParId(reservation.getClient().getId()));
    // reservation.setVoyage(voyageService.rechercherParId(reservation.getVoyage().getId()));
    // reservation.setTypeBillet(typeBilletService.recuperer(reservation.getTypeBillet().getId()));
    // reservationService.creer(reservation);
    // return ResponseEntity.status(HttpStatus.CREATED).body("Réservation
    // enregistrée !");
    // } catch (RuntimeException e) {
    // return ResponseEntity.badRequest().body("Erreur lors de la réservation : " +
    // e.getMessage());
    // }
    // }
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> creer(@RequestBody ReservationRequest request) {
        try {
            Clients client = clientsService.rechercherParId(request.getClientId());
            Voyage voyage = voyageService.rechercherParId(request.getVoyageId());
            TypeBillet typeBillet = typeBilletService.recuperer(request.getTypeBilletId());

            Reservation reservation = new Reservation();
            reservation.setClient(client);
            reservation.setVoyage(voyage);
            reservation.setTypeBillet(typeBillet);
            reservation.setDateReservation(
                    request.getDateReservation() != null ? request.getDateReservation() : LocalDate.now());
            reservation.setDateDepart(request.getDateDepart());
            reservation.setNombrePersonnes(request.getNombrePersonnes());
            reservation.setStatut(request.getStatut());

            reservationService.creer(reservation);
            return ResponseEntity.status(HttpStatus.CREATED).body("Réservation enregistrée !");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Erreur lors de la réservation : " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(reservationService.recuperer(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<Reservation> listerTous() {
        return reservationService.recupererTous();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> mettreAJour(@PathVariable Long id, @RequestBody Reservation reservation) {
        try {
            reservationService.mettreAJour(id, reservation);
            return ResponseEntity.ok("Réservation mise à jour !");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Erreur : " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> supprimer(@PathVariable Long id) {
        try {
            reservationService.supprimer(id);
            return ResponseEntity.ok("Réservation supprimée !");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Erreur : " + e.getMessage());
        }
    }
}

// @RestController
// @RequestMapping(path = "/reservations")
// public class ReservationController {

// private final ReservationService reservationService;
// private final ClientsService clientsService;
// private final VoyageService voyageService;
// private final TypeBilletService typeBilletService;

// public ReservationController(
// ReservationService reservationService,
// ClientsService clientsService,
// VoyageService voyageService,
// TypeBilletService typeBilletService) {
// this.reservationService = reservationService;
// this.clientsService = clientsService;
// this.voyageService = voyageService;
// this.typeBilletService = typeBilletService;
// }

// @ResponseStatus(value = HttpStatus.CREATED)
// @PostMapping(consumes = APPLICATION_JSON_VALUE)
// public void creer(@RequestBody Reservation reservation) {
// int idClient = reservation.getClient().getId();
// int idVoyage = reservation.getVoyage().getId();
// int idTypeBillet = reservation.getTypeBillet().getId();

// Clients client = clientsService.rechercherParId(idClient);
// Voyage voyage = voyageService.rechercherParId(idVoyage);
// TypeBillet typeBillet = typeBilletService.recuperer(idTypeBillet);

// reservation.setClient(client);
// reservation.setVoyage(voyage);
// reservation.setTypeBillet(typeBillet);

// reservationService.creer(reservation); // Enregistre dans la base
// }

// // READ by ID
// @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
// public Reservation getReservation(@PathVariable int id) {
// return this.reservationService.recuperer(id);
// }

// // READ all
// @GetMapping(produces = APPLICATION_JSON_VALUE)
// public List<Reservation> listerTous() {
// return this.reservationService.recupererTous();
// }

// // UPDATE
// @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE)
// public void mettreAJour(@PathVariable int id, @RequestBody Reservation
// reservation) {
// this.reservationService.mettreAJour(id, reservation);
// }

// // DELETE
// @DeleteMapping("/{id}")
// public void supprimer(@PathVariable int id) {
// this.reservationService.supprimer(id);
// }
// }
