package com.projet.applicationjavaspring.agence_voyage.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.projet.applicationjavaspring.agence_voyage.entites.TypeBillet;
import com.projet.applicationjavaspring.agence_voyage.repository.TypeBilletRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final TypeBilletRepository typeBilletRepository;

    public DataInitializer(TypeBilletRepository typeBilletRepository) {
        this.typeBilletRepository = typeBilletRepository;
    }

    @Override
    public void run(String... args) {
        createTypeBilletIfNotExists("Standard", 0.0);
        createTypeBilletIfNotExists("Premium", 25.0);
        createTypeBilletIfNotExists("VIP", 50.0);
    }

    private void createTypeBilletIfNotExists(String typeNom, double prixSupp) {
        if (typeBilletRepository.findByTypeDeBillet(typeNom).isEmpty()) {
            TypeBillet billet = new TypeBillet();
            billet.setTypeDeBillet(typeNom);
            billet.setPrixSupplementaire(prixSupp);
            typeBilletRepository.save(billet);
        }
    }
}
