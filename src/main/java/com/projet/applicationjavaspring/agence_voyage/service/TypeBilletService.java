package com.projet.applicationjavaspring.agence_voyage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projet.applicationjavaspring.agence_voyage.entites.TypeBillet;
import com.projet.applicationjavaspring.agence_voyage.repository.TypeBilletRepository;

@Service
public class TypeBilletService {

    private final TypeBilletRepository typeBilletRepository;

    public TypeBilletService(TypeBilletRepository typeBilletRepository) {
        this.typeBilletRepository = typeBilletRepository;
    }

    public void creer(TypeBillet typeBillet) {
        this.typeBilletRepository.save(typeBillet);
        // Logique pour créer un type de billet
    }

    // Récupérer tous les types de billets
    public List<TypeBillet> recupererTous() {
        // Logique pour récupérer tous les types de billets
        return this.typeBilletRepository.findAll();
    }

    // Récupérer un type de billet par son ID
    public TypeBillet recuperer(Long id) {
        // Vérification de l'existence du type de billet avant la récupération
        Optional<TypeBillet> optionalTypeBillet = typeBilletRepository.findById(id);
        if (optionalTypeBillet.isPresent()) {
            return optionalTypeBillet.get();
        } else {
            throw new IllegalArgumentException("Type de billet non trouvé");
        }
    }

    // Mettre à jour un type de billet
    public void mettreAJour(Long id, TypeBillet typeBillet) {
        // Vérification de l'existence du type de billet avant la mise à jour
        Optional<TypeBillet> optionalTypeBillet = typeBilletRepository.findById(id);
        if (optionalTypeBillet.isPresent()) {
            TypeBillet existant = optionalTypeBillet.get();
            // Mise à jour des champs nécessaires
            existant.setTypeDeBillet(typeBillet.getTypeDeBillet());
            existant.setPrixSupplementaire(typeBillet.getPrixSupplementaire());
            typeBilletRepository.save(existant);
        } else {
            throw new IllegalArgumentException("Type de billet non trouvé");
        }
    }

    // supprimer un type de billet
    // Vérification de l'existence du type de billet avant la suppression
    public void supprimer(Long id) {
        Optional<TypeBillet> optionalTypeBillet = typeBilletRepository.findById(id);
        if (optionalTypeBillet.isPresent()) {
            typeBilletRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Type de billet non trouvé");
        }
    }

}