package com.gestionarticle.article.model;

import javax.persistence.*;


@Entity
@Table(name="depot")
public class Depot {



    /**
     * Attributs
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nom")
    private String nom;



    /**
     * Constructeurs
     */
    public Depot() {}

    public Depot(String nom) {
        this.nom = nom;
    }

    public Depot(Long id, String nom) {
        this.id = id;
        this.nom = nom;
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }



}
