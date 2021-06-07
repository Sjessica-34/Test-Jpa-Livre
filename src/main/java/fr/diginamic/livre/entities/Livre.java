package fr.diginamic.livre.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "LIVRE")
public class Livre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String auteur;

    @ManyToMany(mappedBy = "livres",fetch = FetchType.EAGER)
    private Set<Emprunt> reservations;

    public Livre(Long id) {
        this.id = id;
    }

    public Livre() {
    }

    public Livre(Long id, String titre, String auteur) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
    }

    public Livre(String titre, String auteur) {
        this.titre = titre;
        this.auteur = auteur;
    }

    public Livre(Long id, String titre, String auteur, Set<Emprunt> reservations) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.reservations = reservations;
    }


    public Long getId() {
        return this.id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getTitre() {
        return this.titre;
    }


    public void setTitre(String titre) {
        this.titre = titre;
    }


    public String getAuteur() {
        return this.auteur;
    }


    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Livre{");
        sb.append("id=").append(id);
        sb.append(", titre='").append(titre).append('\'');
        sb.append(", auteur='").append(auteur).append('\'');
        sb.append('}');
        return sb.toString();
    }


    public Set<Emprunt> getReservations() {
        return this.reservations;
    }


    public void setReservations(Set<Emprunt> reservations) {
        this.reservations = reservations;
    }
}