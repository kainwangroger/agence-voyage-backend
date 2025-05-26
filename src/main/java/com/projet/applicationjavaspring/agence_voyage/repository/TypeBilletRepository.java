package com.projet.applicationjavaspring.agence_voyage.repository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.applicationjavaspring.agence_voyage.entites.TypeBillet;

@Repository
public interface TypeBilletRepository extends JpaRepository<TypeBillet, Long> {

    // Recherche par nom de type de billet
    Optional<TypeBillet> findByTypeDeBillet(String typeDeBillet);
}