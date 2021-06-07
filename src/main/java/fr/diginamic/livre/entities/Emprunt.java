package fr.diginamic.livre.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "EMPRUNT")
public class Emprunt implements Serializable {

    @Id
    private Long id;

    @Column(name = "DATE_DEBUT")
    private Timestamp date_debut;

    @Column(name = "DELAI")
    private Integer delai;

    @Column(name = "DATE_FIN")
    private Timestamp date_fin;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENT")
    private Client client;

    @ManyToMany
    @JoinTable(name = "COMPO",
            joinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID")
    )
    private Set<Livre> livres;

    public Emprunt() {
        livres = new HashSet<Livre>();
    }

    public Emprunt(Long id) {
        this.id = id;
    }

    public Emprunt(Long id, Timestamp date_debut) {
        this.id = id;
        this.date_debut = date_debut;
    }

    public Emprunt(Long id, Timestamp date_debut, Integer delai) {
        this.id = id;
        this.date_debut = date_debut;
        this.delai = delai;
    }

    public Emprunt(Long id, Timestamp date_debut, Integer delai, Timestamp date_fin) {
        this.id = id;
        this.date_debut = date_debut;
        this.delai = delai;
        this.date_fin = date_fin;
    }

    public Emprunt(Long id, Timestamp date_debut, Integer delai, Timestamp date_fin, Client client) {
        this.id = id;
        this.date_debut = date_debut;
        this.delai = delai;
        this.date_fin = date_fin;
        this.client = client;
    }

    public Emprunt(Long id, Timestamp date_debut, Integer delai, Timestamp date_fin, Client client, Set<Livre> livres) {
        this.id = id;
        this.date_debut = date_debut;
        this.delai = delai;
        this.date_fin = date_fin;
        this.client = client;
        this.livres = livres;
    }

    public Emprunt(Timestamp date_debut, Integer delai, Timestamp date_fin, Client client, Set<Livre> livres) {
        this.date_debut = date_debut;
        this.delai = delai;
        this.date_fin = date_fin;
        this.client = client;
        this.livres = livres;
    }

    /**
     * get field @Id
     *
     * @return id @Id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * set field @Id
     *
     * @param id @Id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * get field @Column(name = "DATE_DEBUT")
     *
     * @return date_debut @Column(name = "DATE_DEBUT")
     */
    public Timestamp getDate_debut() {
        return this.date_debut;
    }

    /**
     * set field @Column(name = "DATE_DEBUT")
     *
     * @param date_debut @Column(name = "DATE_DEBUT")
     */
    public void setDate_debut(Timestamp date_debut) {
        this.date_debut = date_debut;
    }

    /**
     * get field @Column(name = "DELAI")
     *
     * @return delai @Column(name = "DELAI")
     */
    public Integer getDelai() {
        return this.delai;
    }

    /**
     * set field @Column(name = "DELAI")
     *
     * @param delai @Column(name = "DELAI")
     */
    public void setDelai(Integer delai) {
        this.delai = delai;
    }

    /**
     * get field @Column(name = "DATE_FIN")
     *
     * @return date_fin @Column(name = "DATE_FIN")
     */
    public Timestamp getDate_fin() {
        return this.date_fin;
    }

    /**
     * set field @Column(name = "DATE_FIN")
     *
     * @param date_fin @Column(name = "DATE_FIN")
     */
    public void setDate_fin(Timestamp date_fin) {
        this.date_fin = date_fin;
    }

    /**
     * get field @ManyToOne
     *
     * @return client @ManyToOne
     * @JoinColumn(name = "ID_CLIENT")
     * @JoinColumn(name = "ID_CLIENT")
     */
    public Client getClient() {
        return this.client;
    }

    /**
     * set field @ManyToOne
     *
     * @param client @ManyToOne
     * @JoinColumn(name = "ID_CLIENT")
     * @JoinColumn(name = "ID_CLIENT")
     */
    public void setClient(Client client) {
        if (this.client != null) {
            this.client.getEmprunts().remove(this);
        }

        this.client = client;

        if (this.client != null) {
            this.client.getEmprunts().add(this);
        }
    }

    /**
     * get field @ManyToMany
     @JoinTable(name = "COMPO",
     joinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"),
     inverseJoinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID")
     )
      *
      * @return livres @ManyToMany
     @JoinTable(name = "COMPO",
     joinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"),
     inverseJoinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID")
     )
     */
    public Set<Livre> getLivres() {
        return this.livres;
    }

    /**
     * set field @ManyToMany
     @JoinTable(name = "COMPO",
     joinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"),
     inverseJoinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID")
     )
     *@param livres @ManyToMany
     @JoinTable(name = "COMPO",
     joinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"),
     inverseJoinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID")
     )
      * @return
     */
    public Set<Emprunt> setLivres(Set<Livre> livres) {
        this.livres = livres;
        return null;
    }

}}