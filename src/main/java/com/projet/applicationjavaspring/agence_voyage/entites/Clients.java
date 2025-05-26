package com.projet.applicationjavaspring.agence_voyage.entites;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Clients")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // La stratégie d'identité signifie que la valeur de l'identifiant sera générée
    // automatiquement
    private Long id;
    private String nom;
    private String prenom;
    private String sexe;
    private String nationalite;
    private String email;
    private String telephone;
    private String adresse;
    private LocalDate dateDeNaissance;
    private LocalDate dateInscription = LocalDate.now();

    private String motDePasse;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Reservation> reservations;

    // Constructeur par défaut
    // Le constructeur par défaut est nécessaire pour que JPA puisse créer des
    // instances de l'entité
    public Clients() {
    }

    // Constructeur avec paramètres
    // Ce constructeur est utilisé pour créer des instances de l'entité Clients avec
    // des valeurs spécifiques
    public Clients(String nom, String prenom, String sexe, String nationalite, String email, String telephone,
            String adresse,
            LocalDate dateDeNaissance,
            String motDePasse, LocalDate dateInscription,
            Role role) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.nationalite = nationalite;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
        this.dateDeNaissance = dateDeNaissance;
        this.dateInscription = dateInscription;
        this.motDePasse = motDePasse;
        this.role = role;
    }

    // Getters et Setters
    // Les getters et setters sont utilisés pour accéder et modifier les propriétés
    // de l'entité
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public LocalDate getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(LocalDate dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public LocalDate getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(LocalDate dateInscription) {
        this.dateInscription = dateInscription;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
