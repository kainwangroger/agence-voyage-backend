package com.projet.applicationjavaspring.agence_voyage.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projet.applicationjavaspring.agence_voyage.entites.Clients;

import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends JpaRepository<Clients, Long> {

    boolean existsById(Long id);

    boolean existsByEmail(String email);

    Optional<Clients> findById(Long id);

    Optional<Clients> findByEmail(String email);
}
