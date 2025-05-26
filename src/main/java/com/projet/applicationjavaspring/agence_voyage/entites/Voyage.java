package com.projet.applicationjavaspring.agence_voyage.entites;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

// La classe Voyage représente un voyage dans le système de réservation
@Entity
@Table(name = "Voyage")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Voyage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // ville de départ
    private String villeDepart;
    // ville d'arrivée
    private String villeArrivee;
    // Date de départ
    private LocalDate dateDepart;
    // prix du voyage
    private double prix = 0.0;
    // Nombre de places
    private int nombrePlaces = 1;
    // Libellé du voyage
    private String libelle;

    @OneToMany(mappedBy = "voyage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations;

    // Constructeur par défaut
    public Voyage() {
    }

    // Constructeur avec paramètres
    public Voyage(String villeDepart, String villeArrivee, LocalDate dateDepart, double prix,
            int nombrePlaces, String libelle) {
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.dateDepart = dateDepart;
        this.prix = prix;
        this.nombrePlaces = nombrePlaces;
        this.libelle = libelle;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    public String getVilleArrivee() {
        return villeArrivee;
    }

    public void setVilleArrivee(String villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    public LocalDate getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(LocalDate dateDepart) {
        this.dateDepart = dateDepart;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getNombrePlaces() {
        return nombrePlaces;
    }

    public void setNombrePlaces(int nombrePlaces) {
        this.nombrePlaces = nombrePlaces;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
