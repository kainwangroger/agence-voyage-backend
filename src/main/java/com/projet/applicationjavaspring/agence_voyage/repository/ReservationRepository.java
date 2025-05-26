package com.projet.applicationjavaspring.agence_voyage.repository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projet.applicationjavaspring.agence_voyage.entites.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // Cette interface est un dépôt pour l'entité Reservation.
    // Elle hérite de JpaRepository pour accéder aux méthodes CRUD.
    boolean existsById(Long id);

    Optional<Reservation> findById(Long id);
}
