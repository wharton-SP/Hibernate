package com.hib.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employe")
public class Employe {

    @Id
    @Column(name = "codeemp", length = 20, unique = true, nullable = false)
    private String codeemp;  // Changé de Long à String

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "poste")
    private String poste;

    // Constructeurs
    public Employe() {}

    public Employe(String codeemp, String nom, String prenom, String poste) {
        this.codeemp = codeemp;
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
    }

    // Getters et setters
    public String getCodeemp() {  // Retourne String maintenant
        return codeemp;
    }

    public void setCodeemp(String codeemp) {  // Prend un String en paramètre
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

    // Méthode toString() mise à jour
    @Override
    public String toString() {
        return "Employe{" +
               "code='" + codeemp + '\'' +
               ", nom='" + nom + '\'' +
               ", prenom='" + prenom + '\'' +
               ", poste='" + poste + '\'' +
               '}';
    }
}