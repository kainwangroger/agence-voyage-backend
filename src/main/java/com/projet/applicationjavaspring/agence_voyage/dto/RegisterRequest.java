package com.projet.applicationjavaspring.agence_voyage.dto;

import com.projet.applicationjavaspring.agence_voyage.entites.Role;

public class RegisterRequest {
    private String nom;
    private String prenom;
    private String sexe;
    private String nationalite;
    private String email;
    private String telephone;
    private String adresse;
    private String dateDeNaissance;
    private String motDePasse;
    private Role role;

    // Constructeur par défaut
    public RegisterRequest() {
    }

    // Constructeur avec paramètres
    public RegisterRequest(String nom, String prenom, String sexe, String nationalite, String email, String motDePasse,
            String telephone, String adresse, String dateDeNaissance,
            Role role) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.nationalite = nationalite;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
        this.dateDeNaissance = dateDeNaissance;
        this.motDePasse = motDePasse;
        this.role = role;
    }

    // Getters & Setters
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

    public String getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(String dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
