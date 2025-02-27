package com.hib.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employe")
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeemp;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "poste")
    private String poste;

    // Constructors, getters, setters, and toString() method
    public Employe() {}

    public Employe(String nom, String prenom, String poste) {
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
    }

    // Getters and setters
    public Long getCodeemp() {  
        return codeemp;
    }

    public void setCodeemp(Long codeemp) {  
        this.codeemp = codeemp;
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

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    // toString() method
    @Override
    public String toString() {
        return "Employe{" +
               "id=" + codeemp +
               ", nom='" + nom + '\'' +
               ", prenom='" + prenom + '\'' +
               ", poste='" + poste + '\'' +
               '}';
    }
}
