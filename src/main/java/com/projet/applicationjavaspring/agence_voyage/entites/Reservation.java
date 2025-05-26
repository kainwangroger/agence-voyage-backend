package com.projet.applicationjavaspring.agence_voyage.entites;

import java.time.LocalDate;
// import java.time.LocalDateTime;
// import com.projet.applicationjavaspring.agence_voyage.entites.Clients; // ou le chemin correct vers ton entité @Entity Clients
// import com.projet.applicationjavaspring.agence_voyage.entites.TypeBillet; // ou le chemin correct vers ton entité @Entity TypeBillet
// import com.projet.applicationjavaspring.agence_voyage.entites.Voyage; // ou le chemin correct vers ton entité @Entity Voyage

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Reservation")

public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "client_id")
    private Clients client;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JsonBackReference
    @JoinColumn(name = "voyage_id")
    private Voyage voyage;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "type_billet_id")
    private TypeBillet typeBillet;

    // Date à laquelle la réservation a été faite
    private LocalDate dateReservation = LocalDate.now();

    // Date de départ demandée par le client
    private LocalDate dateDepart;

    // Nombre de personnes réservées
    private int nombrePersonnes = 1;

    private String statut;

    // Constructeur par défaut
    public Reservation() {
    }

    // Constructeur avec paramètres
    public Reservation(Clients client, Voyage voyage, TypeBillet typeBillet, LocalDate dateReservation,
            int nombrePersonnes, LocalDate dateDepart, String statut) {
        this.client = client;
        this.voyage = voyage;
        this.typeBillet = typeBillet;
        this.dateReservation = dateReservation;
        this.nombrePersonnes = nombrePersonnes;
        this.dateDepart = dateDepart;
        this.statut = statut;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public Voyage getVoyage() {
        return voyage;
    }

    public void setVoyage(Voyage voyage) {
        this.voyage = voyage;
    }

    public TypeBillet getTypeBillet() {
        return typeBillet;
    }

    public void setTypeBillet(TypeBillet typeBillet) {
        this.typeBillet = typeBillet;
    }

    public LocalDate getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(LocalDate dateReservation) {
        this.dateReservation = dateReservation;
    }

    public int getNombrePersonnes() {
        return nombrePersonnes;
    }

    public void setNombrePersonnes(int nombrePersonnes) {
        this.nombrePersonnes = nombrePersonnes;
    }

    public LocalDate getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(LocalDate dateDepart) {
        this.dateDepart = dateDepart;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}
