package com.projet.applicationjavaspring.agence_voyage.dto;

import java.time.LocalDate;

public class VoyageRequest {

    private Long id;
    private String villeDepart;
    private String villeArrivee;
    private LocalDate dateDepart;
    private double prix;
    private int nombrePlaces;
    private String libelle;

    // Constructeurs

    public VoyageRequest() {
    }

    public VoyageRequest(Long id, String villeDepart, String villeArrivee, LocalDate dateDepart, double prix,
            int nombrePlaces, String libelle) {
        this.id = id;
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

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
