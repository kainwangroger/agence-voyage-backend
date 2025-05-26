package com.projet.applicationjavaspring.agence_voyage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.projet.applicationjavaspring.agence_voyage.entites.Reservation;
import com.projet.applicationjavaspring.agence_voyage.repository.ReservationRepository;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    // Créer une réservation
    // Cette méthode est responsable de la création d'une réservation.
    public void creer(Reservation reservation) {
        this.reservationRepository.save(reservation);
        // Logique pour créer une réservation
    }

    // Récupérer toutes les réservations
    public List<Reservation> recupererTous() {
        // Logique pour récupérer toutes les réservations
        return this.reservationRepository.findAll();
    }

    // Récupérer une réservation par son ID
    public Reservation recuperer(Long id) {
        // Logique pour récupérer une réservation par son ID
        Optional<Reservation> optionalReservation = this.reservationRepository.findById(id);
        if (optionalReservation.isPresent()) {
            return optionalReservation.get();
        } else {
            throw new IllegalArgumentException("Réservation non trouvée");
        }
    }

    // Mettre à jour une réservation
    public void mettreAJour(Long id, Reservation reservation) {
        // Logique pour mettre à jour une réservation
        Optional<Reservation> optionalReservation = this.reservationRepository.findById(id);
        if (optionalReservation.isPresent()) {
            Reservation existant = optionalReservation.get();
            // Mets à jour les champs nécessaires :
            existant.setDateReservation(reservation.getDateReservation());
            existant.setClient(reservation.getClient());
            existant.setVoyage(reservation.getVoyage());
            // Ajoute les autres champs de Reservation si besoin
            this.reservationRepository.save(existant);
        } else {
            throw new IllegalArgumentException("Réservation non trouvée");
        }
    }

    // Supprimer une réservation
    public void supprimer(Long id) {
        // Logique pour supprimer une réservation
        Optional<Reservation> optionalReservation = this.reservationRepository.findById(id);
        if (optionalReservation.isPresent()) {
            this.reservationRepository.delete(optionalReservation.get());
        } else {
            throw new IllegalArgumentException("Réservation non trouvée");
        }
    }

}
