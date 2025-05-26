package com.projet.applicationjavaspring.agence_voyage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projet.applicationjavaspring.agence_voyage.entites.Voyage;
import com.projet.applicationjavaspring.agence_voyage.repository.VoyageRepository;

@Service
public class VoyageService {

    private VoyageRepository voyageRepository;

    public VoyageService(VoyageRepository voyageRepository) {
        this.voyageRepository = voyageRepository;
    }

    public void creer(Voyage voyage) {
        this.voyageRepository.save(voyage);
        // Logique pour créer un voyage
    }

    // READ ALL (Lister tous les voyages)
    public List<Voyage> listerTous() {
        return this.voyageRepository.findAll();
    }

    // READ (rechercher par ID)
    public Voyage rechercherParId(Long id) {
        Optional<Voyage> optionalVoyage = voyageRepository.findById(id);
        if (optionalVoyage.isPresent()) {
            return optionalVoyage.get();
        } else {
            throw new RuntimeException("Voyage non trouvé avec l'ID : " + id);
        }
    }

    // UPDATE
    public void mettreAJour(Long id, Voyage voyage) {
        // Vérifie si le voyage existe avant de le mettre à jour
        Optional<Voyage> optionalVoyage = voyageRepository.findById(id);
        if (optionalVoyage.isPresent()) {
            Voyage existant = optionalVoyage.get();
            // Mets à jour les champs nécessaires :
            existant.setLibelle(voyage.getLibelle());
            existant.setVilleDepart(voyage.getVilleDepart());
            existant.setVilleArrivee(voyage.getVilleArrivee());
            existant.setDateDepart(voyage.getDateDepart());
            existant.setPrix(voyage.getPrix());
            existant.setNombrePlaces(voyage.getNombrePlaces());

            // Ajoute les autres champs de Voyage si besoin
            voyageRepository.save(existant);
        } else {
            throw new RuntimeException("Voyage non trouvé avec l'ID : " + id);
        }

    }

    // DELETE
    public void supprimer(Long id) {
        // Vérifie si le voyage existe avant de le supprimer
        Optional<Voyage> optionalVoyage = voyageRepository.findById(id);
        if (optionalVoyage.isPresent()) {
            voyageRepository.delete(optionalVoyage.get());
        } else {
            throw new RuntimeException("Voyage non trouvé avec l'ID : " + id);
        }
    }
}