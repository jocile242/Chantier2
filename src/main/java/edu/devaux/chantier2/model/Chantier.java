package edu.devaux.chantier2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
public class Chantier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(length = 100)
    protected String nom;

    protected String adresse;

    @ManyToOne
    protected Operation operations;



}


//Un chantier :
//possède une adresse
//est possédé par un client (un utilisateur)
//est dirigé par un ouvrier (un utilisateur)
//se voit planifier une liste d’opérations
