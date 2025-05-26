package com.projet.applicationjavaspring.agence_voyage.dto;


public class LoginRequest {
    private String email;
    private String motDePasse;

    // Constructeur par défaut
    public LoginRequest() {
    }

    // Constructeur avec paramètres
    public LoginRequest(String email, String motDePasse) {
        this.email = email;
        this.motDePasse = motDePasse;
    }

    // Getters & Setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
}