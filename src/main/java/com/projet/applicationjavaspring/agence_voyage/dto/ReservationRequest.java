package com.projet.applicationjavaspring.agence_voyage.dto;

import java.time.LocalDate;

public class ReservationRequest {
    private Long clientId;
    private Long voyageId;
    private Long typeBilletId;
    private LocalDate dateReservation;
    private LocalDate dateDepart;
    private int nombrePersonnes;
    private String statut;

    public ReservationRequest(Long clientId, Long voyageId, Long typeBilletId, LocalDate dateReservation,
            LocalDate dateDepart,
            int nombrePersonnes, String statut) {
        this.clientId = clientId;
        this.voyageId = voyageId;
        this.typeBilletId = typeBilletId;
        this.dateReservation = dateReservation;
        this.dateDepart = dateDepart;
        this.nombrePersonnes = nombrePersonnes;
        this.statut = statut;
    }

    // Getters et setters

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getVoyageId() {
        return voyageId;
    }

    public void setVoyageId(Long voyageId) {
        this.voyageId = voyageId;
    }

    public Long getTypeBilletId() {
        return typeBilletId;
    }

    public void setTypeBilletId(Long typeBilletId) {
        this.typeBilletId = typeBilletId;
    }

    public LocalDate getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(LocalDate dateReservation) {
        this.dateReservation = dateReservation;
    }

    public LocalDate getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(LocalDate dateDepart) {
        this.dateDepart = dateDepart;
    }

    public int getNombrePersonnes() {
        return nombrePersonnes;
    }

    public void setNombrePersonnes(int nombrePersonnes) {
        this.nombrePersonnes = nombrePersonnes;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

}