package fr.diginamic.livre.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "CLIENT")
public class Client implements Serializable {

    @Id
    private Long id;

    @Column(name = "NOM", nullable = false)
    private String nom;

    @Column(name = "PRENOM")
    private String prenom;

    @OneToMany(mappedBy = "client")
    private Set<Emprunt> emprunts;

    public Client() {
        emprunts = new HashSet<Emprunt>();
    }

    public Client(Long id) {
        this.id = id;
    }

    public Client(Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Client(Long id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Client(Long id, String nom, String prenom, Set<Emprunt> emprunts) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.emprunts = emprunts;
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


    public String getPrenom() {
        return this.prenom;
    }


    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    public Set<Emprunt> getEmprunts() {
        return this.emprunts;
    }


    public void setEmprunts(Set<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }


    public void addEmprunt(Emprunt emprunt) {
        if (emprunt != null) {
            emprunt.setClient(this);
        }
    }
}