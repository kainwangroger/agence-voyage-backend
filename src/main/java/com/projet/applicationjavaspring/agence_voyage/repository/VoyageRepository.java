package com.projet.applicationjavaspring.agence_voyage.repository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.applicationjavaspring.agence_voyage.entites.Voyage;
// Importation des classes nécessaires pour le dépôt VoyageRepository

@Repository
public interface VoyageRepository extends JpaRepository<Voyage, Long> {
    // Cette interface est un dépôt pour l'entité Voyage.
    // Elle hérite de JpaRepository, ce qui fournit des méthodes CRUD pour Voyage.
    boolean existsById(Long id);

    Optional<Voyage> findById(Long id);
}
