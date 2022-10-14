package com.gestionarticle.article.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="article")
public class Article {




    /**
     * Attributs
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="designation")
    private String designation;

    @Column(name="prix")
    private double prix;

    @Column(name="quantite")
     private int quantite;

    @Column(name="date_entree")
    private Date dateEntree;


    @OneToOne(cascade =CascadeType.REFRESH)
    @JoinColumn(name = "fk_depot")
    private Depot depot;



    /**
     * Constructeurs
     */
    public Article() {}

    public Article(String designation, double prix, int quantite, Date dateEntree, Depot depot) {
        super();
        this.designation = designation;
        this.prix = prix;
        this.quantite = quantite;
        this.dateEntree = dateEntree;
        this.depot = depot;
    }

    public Article(Long id, String designation, double prix, int quantite, Date dateEntree, Depot depot) {
        super();
        this.id = id;
        this.designation = designation;
        this.prix = prix;
        this.quantite = quantite;
        this.dateEntree = dateEntree;
        this.depot = depot;
    }




    /**
     * Getters & Setters
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Date getDateEntree() {
        return dateEntree;
    }

    public void setDateEntree(Date dateEntree) {
        this.dateEntree = dateEntree;
    }

    public Depot getDepot() {
        return depot;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }





}
