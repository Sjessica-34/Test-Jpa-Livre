package fr.diginamic.livre.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FOURNISSEUR")
public class Fournisseur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @Transient
    private String adresse;


    public Fournisseur() {
    }

    public Fournisseur(Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Fournisseur(String nom) {
        this.nom = nom;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getNom() {
        return this.nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Fournisseur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }



}
