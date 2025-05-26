package com.projet.applicationjavaspring.agence_voyage.entites;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

// La classe TypeBillet représente un type de billet dans le système de réservation
@Entity
@Table(name = "TypeBillet")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class TypeBillet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // nom du type de billet Par exemple : "Standard", "Premium", "VIP"
    private String typeDeBillet;

    // prix supplementaire pour ce type de billet
    private double prixSupplementaire;

    @OneToMany(mappedBy = "typeBillet", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Reservation> reservations;

    // Constructeur par défaut
    public TypeBillet() {
    }

    // Constructeur avec paramètres
    public TypeBillet(String typeDeBillet, double prixSupplementaire) {
        this.typeDeBillet = typeDeBillet;
        this.prixSupplementaire = prixSupplementaire;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeDeBillet() {
        return typeDeBillet;
    }

    public void setTypeDeBillet(String typeDeBillet) {
        this.typeDeBillet = typeDeBillet;
    }

    public double getPrixSupplementaire() {
        return prixSupplementaire;
    }

    public void setPrixSupplementaire(double prixSupplementaire) {
        this.prixSupplementaire = prixSupplementaire;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

}