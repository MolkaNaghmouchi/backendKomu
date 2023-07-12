package com.bezkoder.spring.security.postgresql.models;

import com.fasterxml.jackson.annotation.JsonIgnore;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
@Entity
@Table(name = "themes")

public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "themes")
    @JsonIgnore
    private Set<Tutorial> tutorials = new HashSet<>();

    public Theme() {
    }


    public Theme(Long id, String nom, Set<Tutorial> tutorials) {
        this.id = id;
        this.nom = nom;
        this.tutorials = tutorials;
    }

    //getTutorials
    public Set<Tutorial> getTutorials() {

        return tutorials;
    }

    //setTutorials
    public void setTutorials(Set<Tutorial> tutorials) {
        this.tutorials = tutorials;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
}