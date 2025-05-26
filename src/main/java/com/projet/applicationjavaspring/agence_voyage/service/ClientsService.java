package com.projet.applicationjavaspring.agence_voyage.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.projet.applicationjavaspring.agence_voyage.entites.Clients;
import com.projet.applicationjavaspring.agence_voyage.repository.ClientsRepository;

@Service
public class ClientsService {

    private final ClientsRepository clientsRepository;

    public ClientsService(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    public void creerClient(Clients client) {
        // Enregistrement du client
        clientsRepository.save(client);
    }

    // Connexion d'un client
    public Clients connecterClient(String email, String motDePasse) {
        return clientsRepository.findByEmail(email)
                .filter(c -> c.getMotDePasse().equals(motDePasse)) // compare mot de passe
                .orElseThrow(() -> new RuntimeException("Email ou mot de passe incorrect"));
    }

    // Recherche de tous les clients
    public List<Clients> rechercher() {
        return clientsRepository.findAll();
    }

    // Recherche d'un client par ID
    public Clients rechercherParId(Long id) {
        return clientsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client non trouvé avec l'ID : " + id));
    }

    // Mise à jour d'un client
    public void mettreAJour(Long id, Clients client) {
        Clients existant = rechercherParId(id);
        existant.setNom(client.getNom());
        existant.setPrenom(client.getPrenom());
        existant.setSexe(client.getSexe());
        existant.setNationalite(client.getNationalite());
        existant.setDateDeNaissance(client.getDateDeNaissance());
        existant.setEmail(client.getEmail());
        existant.setTelephone(client.getTelephone());
        existant.setAdresse(client.getAdresse());
        clientsRepository.save(existant);
    }

    // Suppression d'un client
    public void supprimer(Long id) {
        Clients client = rechercherParId(id);
        clientsRepository.delete(client);
    }
}
